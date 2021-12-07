package fdu.daslab.executorcenter.environments.hpc;

import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import fdu.daslab.executorcenter.executor.KubernetesExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author zjchen
 * @time 2021/9/17 10:24 上午
 * @description
 */

@Component
public class HpcStrategy {

    private Logger logger = LoggerFactory.getLogger(KubernetesExecutor.class);

    private static final int SESSION_TIMEOUT = 10000;
    private static final int CHANNEL_TIMEOUT = 5000;

    // 手动输入账号密码
    @Value("${hpc.host}")
    private String host;

//    @Value("${hpc.username}")
//    private String username;
//
//    @Value("${hpc.password}")
//    private String password;

    @Value("${hpc.port}")
    private int port;


    public void createJob(String command, String username, String password) throws JSchException {
        Session jschSession = null;
        try {
            logger.info("hpc address: " + host + ":" + port + "\n");
            JSch jsch = new JSch();
//            jsch.setKnownHosts("/Users/zjchen/.ssh/known_hosts");
            jschSession = jsch.getSession(username, host, port);
            jschSession.setConfig("StrictHostKeyChecking", "no");
            // not recommend, uses jsch.setKnownHosts
            //jschSession.setConfig("StrictHostKeyChecking", "no");

            // authenticate using password
            jschSession.setPassword(password);

            // 10 seconds timeout session
            jschSession.connect(SESSION_TIMEOUT);
            ChannelExec channelExec = (ChannelExec) jschSession.openChannel("exec");

            // run a shell script
            channelExec.setCommand(command);
            //            channelExec.setCommand("source /es01/shanhe/hpc_mnt/home/usr-dDyDTogd/.bashrc; cjobs");
            // display errors to System.err
            channelExec.setErrStream(System.err);

            InputStream in = channelExec.getInputStream();

            // 5 seconds timeout channel
            channelExec.connect(CHANNEL_TIMEOUT);
            // read the result from remote server
            byte[] tmp = new byte[1024];
            while (true) {
                while (in.available() > 0) {
                    int i = in.read(tmp, 0, 1024);
                    if (i < 0) break;
                    logger.info(new String(tmp, 0, i));
                }
                if (channelExec.isClosed()) {
                    if (in.available() > 0) continue;
                    logger.info("exit-status: "
                            + channelExec.getExitStatus());
                    break;
                }
                try {
                    Thread.sleep(1000);
                } catch (Exception ee) {
                    logger.error(ee.getMessage());
                }
            }

            channelExec.disconnect();
        } catch (JSchException | IOException e) {

            logger.error(e.getMessage());

        } finally {
            if (jschSession != null) {
                jschSession.disconnect();
            }
        }
    }
}
