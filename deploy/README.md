微服务部署手册，按照下面的顺序部署系统依赖的服务

## 前置部署

- 1.系统依赖nfs（或者其他分布式存储）进行部署，因此需要先部署nfs，再部署k8s访问的pv和pvc
   
   - nfs的部署脚本在nfs路径下（nfs-client中需要修改server）
   - nfs的pv和pvc可以根据情况更改（比如挂载路径）
   - 需要在挂载路径下创建我们需要的文件夹：
     - 目前元信息存放位置：挂载目录为 /nfs/data
        - dag：/data/system/dags
        - 中间结果： /data/system/inter_files
        - 日志文件： /data/logs
    - 用户的udf和输入文件，建议存放到 /data/user
  
  补充：
     - 这里有个坑需要对logs和system（system内的dags和inter_files也要）进行权限修改，方法为`chmod 777 file`，否则spark-context初始化对时候会报permission denied的错误
     - 创建完pvc后查看绑定情况，如果是pending状态，那说明pv和pvc没绑定成功，最大的可能性是storage class没有对应，这个时候先查看pvc的storage class，再去修改pv中的storage class重新apply
- 2.系统需要依赖k8s的高权限的service account的token去创建job、operator。下面直接获取了kube-system的admin的权限，
  实际并不太好，只是为了方便，最好自己根据需求创建对应的sa，然后获取token

  ```shell script
    # 获取最高权限的token，后面executor-center的configmap的配置token需要使用这一个token
    $(kubectl get secret $(kubectl get serviceaccount admin -n kube-system -o jsonpath='{.secrets[0].name}') -n kube-system -o jsonpath='{.data.token}' | base64 --decode )
  ```
  补充先创建service account再获取token的方法

  - 创建admin-role.yaml

  ```yaml
  kind: ClusterRoleBinding
  apiVersion: rbac.authorization.k8s.io/v1beta1
  metadata:
    name: admin
    annotations:
      rbac.authorization.kubernetes.io/autoupdate: "true"
  roleRef:
    kind: ClusterRole
    name: cluster-admin
    apiGroup: rbac.authorization.k8s.io
  subjects:
  - kind: ServiceAccount
    name: admin
    namespace: kube-system
  ---
  apiVersion: v1
  kind: ServiceAccount
  metadata:
    name: admin
    namespace: kube-system
    labels:
      kubernetes.io/cluster-service: "true"
      addonmanager.kubernetes.io/mode: Reconcile
  ```

  - 执行`kubectl create -f admin-role.yaml`

  - 获取token

  ```yaml
    # 获取admin-token的secret名字
    $ kubectl -n kube-system get secret|grep admin-token
    admin-token-nwphb          kubernetes.io/service-account-token    3     6m
    # 获取token的值
    $ kubectl -n kube-system get secret admin-token-nwphb -o jsonpath={.data.token} | base64 -d
  ```

- 3.系统底层需要不同的执行引擎，比如spark、flink、tensorflow，需要先在k8s上安装对应的环境的operator
    - 这一步需要先拉取spark-operator的镜像
    - 参考网络的解决方案，建议使用helm的方式
    - [spark安装](https://github.com/GoogleCloudPlatform/spark-on-k8s-operator/tree/master/charts/spark-operator-chart)：
        ```shell script
        # 需要先创建一个spark的service account
        helm repo add spark-operator https://googlecloudplatform.github.io/spark-on-k8s-operator
        # 使用最新的版本，否则有bug，registry.ap-southeast-1.aliyuncs.com/sparkonk8/sparkonk8s:1.0
        # 重命名gcr.io/spark-operator/spark-operator:latest或者下面参数指定 
        # 需要添加webhook，否则无法挂载
        helm install spark spark-operator/spark-operator --set webhook.enable=true --set serviceAccounts.spark.name=spark 
        # --set image.repository=registry.ap-southeast-1.aliyuncs.com/sparkonk8/sparkonk8s --set image.tag=1.0
        ```

## 微服务部署

每一个微服务包含三个部分，分别是config、deployment、service。所有平台部署均使用CRD的方式，本仓库维护了基本的部署文件。
其中：config保存了spring的生产环境的配置文件的configmap、deployment是部署的文件、service是对外的服务。
依次执行每一个微服务应用的config、deployment、service即可。
- 1.创建config：`kubectl create -f xxx-config.yaml`
- 2.创建deployment: `kubectl create -f xxx.yaml`
- 3.创建service：`kubectl create -f xxx-svc.yaml`
- 当需要更改config的时候，直接通过`kubectl edit configmap xxx`来更新对应的配置

## 版本更新

更新对应deployment的镜像即可
kubectl set image deployment/clic-operator-center operator-template=edwardtang/operator-center:micro-service-rebuild --record

## kubernetes的服务发现（dns）经常出现问题

原因：
- 1.如果k8s的版本较高，需要将coredns升级到新版本，见[链接](https://blog.csdn.net/heian_99/article/details/114950602)
- 2.如果Node上安装的Docker版本大于1.12，那么Docker 会把默认的 iptables FORWARD 策略改为 DROP。
    这会引发 Pod 网络访问的问题。解决方法则在每个 Node 上面运行 iptables -P FORWARD ACCEPT:
    
    一劳永逸的方法
   ```shell script
    echo "ExecStartPost=/sbin/iptables -P FORWARD ACCEPT" >> /etc/systemd/system/docker.service.d/exec_start.conf
    systemctl daemon-reload
    systemctl restart docker
   ```
    如何docker正在运行，或者直接执行：`/sbin/iptables -P FORWARD ACCEPT`，然后按照上面命令重启docker
- 3.iptable需要设置，见[链接](https://imroc.cc/post/202105/why-enable-bridge-nf-call-iptables/)
- 4.检查防火墙是否关闭：
    ```shell script
    sudo swapoff -a
    sudo ufw disable
    ```

## 常用
- 重启pod的方法
kubectl get pod coredns-74ff55c5b-s7qkb -n kube-system -o yaml | kubectl replace --force -f -

## 平台环境部署

推荐使用 operator的方式部署

