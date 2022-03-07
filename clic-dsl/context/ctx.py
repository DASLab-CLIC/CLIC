import random
import time
import logging

from clic.context.conf import *
from clic.components.operators import *
from clic.components.superoperator import *
from clic.components.operator_type import *
import requests
from progress.bar import Bar


def singleton(cls):
    _instance = {}

    def inner():
        if cls not in _instance:
            _instance[cls] = cls()
        return _instance[cls]
    return inner


class PipelineState(Enum):
    """
    pipeline state
    """
    # 正在构建pipeline
    Creating = 1
    # pipeline已经被编译
    Compiled = 2
    # pipeline 被提交到server上
    Running = 3
    # pipeline运行完成
    Finished = 4


# 单例模式
@singleton
class ClicContext(object):
    """
    controller
    """
    # mapping Operator Enum to corresponding build_xx_op function
    _operator_name2func = {
        Operator.SourceOperator: build_src_op,

        Operator.PreprocessImdbOperator: build_join_op,
        Operator.NetProcessOperator: build_join_op,

        Operator.TrainOperator: build_sink_op,
        Operator.SinkOperator: build_sink_op,
        Operator.W2VOperator: build_sink_op,

        Operator.GetWordDictOperator: build_map_op,
        Operator.DataLoadOperator: build_map_op,

        Operator.GetVocabOperator: build_fork_op,
        Operator.TokenizedOperator: build_fork_op


    }

    # mapping operator string name to corresponding build_xxx_op_from_url function
    _operator_str2func = {
        Operator.SourceOperator: build_src_op_from_url,
        Operator.SinkOperator: build_sink_op_from_url
    }

    planParams = [
        # {
        #     "name": "udfPath-Java",
        #     "value": "/data/user/simplecase/TestFunc.class"
        # },
        {
            "name": "dev-imagePolicy",
            "value": "Always"
        }
    ]

    def __init__(self):
        self._state: PipelineState = PipelineState.Creating
        self._conf = None
        # hold current pipeline json object (not string)
        self._pipeline_json = None

    def set_conf(self, conf: ClicConf):
        """
        :param conf: ClicConf used to configure ClicContext
        """
        self._conf: ClicConf = conf

    def load_operator(self,
                      operator_name: Operator):
        """
        return build_xx_op function given Operator Enum to get built-in operator
        :param operator_name: Operator Enum given by user
        :return: build_xx_op function; e.g. build_map_op function
        """
        return self._operator_name2func[operator_name]

    def load_operator_from_url(self,
                               op_url: str,
                               op_name: Operator):
        """
        load operator from remote address
        :param op_url: "http://ip:port/operators/op_name" ; e.g. "http://localhost:18089/operators/MapOperator"
        :param op_name: user designates which operator to load
        :return: build_xx_op_from_json function; e.g. build_map_op_from_json
        """
        response = requests.get(op_url)
        data = response.json()
        # op_name: str = data["operatorInfo"]["operatorName"]
        return self._operator_str2func[op_name](data)

    def compile(self):
        """
        used chained operator to assemble json
        """
        keys: list[SuperOperator] = list(SuperOperator.get_op_id_mapping().keys())
        self._pipeline_json = {"planParams": self.planParams}
        node_list = []
        for k in keys:
            node_list.append(k.op2dict())
        self._pipeline_json["operators"] = node_list

        self._state = PipelineState.Compiled

    def show_pipeline(self) -> ImmutableDict:
        """
        :return: constructed pipeline
        """
        if self._state != PipelineState.Creating:
            pipeline = ImmutableDict(self._pipeline_json)
            # #生成json并写入文件
            f = open("./myJob.json","w")

            json.dump(pipeline,f)
            logging.info("成功生成json文件 !")
            return pipeline

        else:
            print("pipeline does not finish preparing!")


    def submit(self):
        """
        submit jsonify pipeline to cluster to run
        """
        ip = self._conf.get_cluster_ip()
        port = self._conf.get_cluster_port()
        r = requests.post("http://"+ip+":"+str(port)+"/job/submit?jobName=simpleTest", data=json.dumps(self._pipeline_json))
        if r.status_code != 200:
            raise Exception("request fail!")
        else :
            logging.info("submit success !")

        self._state = PipelineState.Running



    # get progress of submitted task from cluster_ip:port/progbar
    # return json {"finished": 0/1, "estimated_time": int}  1: finished
    # twice communication -- first, get estimated_time, second ping successful
    def progbar(self):
        """
        check progress of pipeline execution
        """
        ip = self._conf.get_cluster_ip()
        port = self._conf.get_cluster_port()
        progbar_url = "http://"+ip+":"+str(port)+"/progbar"

        response = requests.get(progbar_url).json()
        estimates_time = response["estimated_time"]
        used_time = 0
        bar = Bar('Processing', max=estimates_time, check_tty=False, hide_cursor=False)
        eight_percent_time = int(estimates_time * 0.8)
        while used_time < eight_percent_time:
            delta = random.uniform(0, 1)
            time.sleep(delta)
            bar.next()
            used_time = used_time + 1

        # loop ping progress state until successful
        while response["finished"] != 1:
            response = requests.get(progbar_url).json()
            time.sleep(2)

        # show remaining progress bar
        while used_time < estimates_time:
            delta = random.uniform(0, 1)
            time.sleep(delta)
            bar.next()
            used_time = used_time + 1
        bar.finish()
        self._state = PipelineState.Finished



