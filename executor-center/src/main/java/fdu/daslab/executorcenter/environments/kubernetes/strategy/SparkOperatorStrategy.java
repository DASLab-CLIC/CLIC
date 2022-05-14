package fdu.daslab.executorcenter.environments.kubernetes.strategy;

import fdu.daslab.executorcenter.environments.kubernetes.KubernetesRestClient;
import fdu.daslab.thrift.base.Platform;
import fdu.daslab.thrift.base.Stage;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.util.StreamUtils;
import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author 唐志伟
 * @version 1.0
 * @since 6/6/21 3:09 PM
 */
@Component("sparkOperator") // 格式为 平台 + Operator
public class SparkOperatorStrategy implements KubernetesResourceStrategy {
    private Logger logger = LoggerFactory.getLogger(SparkOperatorStrategy.class);
    @Autowired
    private KubernetesRestClient kubernetesRestClient;

    private Yaml yaml = new Yaml();

    @Value("${kubernetes.spark.create}")
    private String createSparkUrl;

    @Override
    public void create(Stage stage, Platform platformInfo, List<String> params) throws Exception {
        final InputStream inputStream = new ClassPathResource("templates/spark-template.yaml").getInputStream();
        String templateYaml = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
        String sparkYaml = templateYaml.replace("$name$", kubernetesRestClient.generateKubernetesName(stage))
                .replace("$image$", stage.others.getOrDefault("sparkImage", platformInfo.defaultImage))
                .replace("$mainClass$", platformInfo.params.get("mainClass"))
                .replace("$mainJar$", platformInfo.params.get("mainJar"))
                .replace("$imagePolicy$", stage.others.getOrDefault("dev-imagePolicy", "IfNotPresent"))
                .replace("$sparkVersion$", platformInfo.params.get("sparkVersion"))
                .replace("$argument$", StringUtils.joinWith(",", params.toArray()));
        HttpClient httpClient = kubernetesRestClient.getIgnoreHttpClient();
        try {
            httpClient.execute(kubernetesRestClient.getDefaultHttpPost(createSparkUrl, yaml.load(sparkYaml)));
        } catch (Exception e){
            logger.error(e.toString());
        }

    }
}
