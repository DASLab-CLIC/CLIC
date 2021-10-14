//package fdu.daslab.executable.hpc;
//
//import org.junit.Test;
//import com.jcraft.jsch.*;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Date;
//import java.util.List;
//
///**
// * @author zjchen
// * @time 2021/9/6 10:39 上午
// * @description
// */
//
//public class jschTest {
//    private static final String REMOTE_HOST = "10.106.10.71";
//    private static final String USERNAME = "usr-dDyDTogd";
//    private static final String PASSWORD = "Sdsc@0199";
//    private static final int REMOTE_PORT = 20023;
//    private static final int SESSION_TIMEOUT = 10000;
//    private static final int CHANNEL_TIMEOUT = 5000;
//    private final static String SCRIPT_PATH = "/es01/shanhe/hpc_mnt/src/COAWST_v1467/Projects/JOE_TC/Coupled/clic.bash";
//
//
//    @Test
//    public void arraySetTest() {
//        List<String> command = new ArrayList<>();
//        command.add(0, "SCRIPT_PATH");
//        command.add(1, "MIX");
//        command.add(0, "STH");
//        System.out.println(command);;
//
//    }
//
//
//    @Test
//    public void hpcWrapperTest() throws ParseException {
//        String start = "2005-09-01 00:00:00";
//        String end = "2005-09-06 00:00:00";
//        System.out.println(parseRunHour(start,end));
//        System.out.println(parseNtimes(start,end));
//
//    }
//
//
//    private String parseRunHour(String startTime, String endTime) throws ParseException {
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date start = ft.parse(startTime);
//        Date end = ft.parse(endTime);
//        int a = (int)((end.getTime() - start.getTime()) / (1000 * 60 * 60));
//        return String.valueOf(a);
//    }
//
//    private String parseNtimes(String startTime, String endTime) throws ParseException {
//        SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
//        Date start = ft.parse(startTime);
//        Date end = ft.parse(endTime);
//        int a = (int)((end.getTime() - start.getTime()) / (1000 * 25));
//        return String.valueOf(a);
//    }
//
//
//    @Test
//    public void sshTest(){
//        Session jschSession = null;
//        try {
//            JSch jsch = new JSch();
////            jsch.setKnownHosts("/Users/zjchen/.ssh/known_hosts");
//            jschSession = jsch.getSession(USERNAME, REMOTE_HOST, REMOTE_PORT);
//            jschSession.setConfig("StrictHostKeyChecking", "no");
//            // not recommend, uses jsch.setKnownHosts
//            //jschSession.setConfig("StrictHostKeyChecking", "no");
//
//            // authenticate using password
//            jschSession.setPassword(PASSWORD);
//
//            // 10 seconds timeout session
//            jschSession.connect(SESSION_TIMEOUT);
//
//            ChannelExec channelExec = (ChannelExec) jschSession.openChannel("exec");
//
//            // run a shell script
////            channelExec.setCommand("echo $PWD; source /es01/shanhe/hpc_mnt/home/usr-dDyDTogd/.bashrc; /opt/skyformai/bin/csub -n 56 -cwd /es01/shanhe/hpc_mnt/src/COAWST_v1467/Projects/JOE_TC/Coupled ./joe_tc.aip.slurm");
////            channelExec.setCommand("source /es01/shanhe/hpc_mnt/home/usr-dDyDTogd/.bashrc; /opt/skyformai/bin/cjobs");
//            channelExec.setCommand(SCRIPT_PATH + " WRF 3 2 2;" + SCRIPT_PATH + " MIX 2 2");
//
//
//            // display errors to System.err
//            channelExec.setErrStream(System.err);
//
//            InputStream in = channelExec.getInputStream();
//
//            // 5 seconds timeout channel
//            channelExec.connect(CHANNEL_TIMEOUT);
//            // read the result from remote server
//            byte[] tmp = new byte[1024];
//            while (true) {
//                while (in.available() > 0) {
//                    int i = in.read(tmp, 0, 1024);
//                    if (i < 0) break;
//                    System.out.print(new String(tmp, 0, i));
//                }
//                if (channelExec.isClosed()) {
//                    if (in.available() > 0) continue;
//                    System.out.println("exit-status: "
//                            + channelExec.getExitStatus());
//                    break;
//                }
//                try {
//                    Thread.sleep(1000);
//                } catch (Exception ee) {
//                }
//            }
//
//            channelExec.disconnect();
//        } catch (JSchException | IOException e) {
//
//            e.printStackTrace();
//
//        } finally {
//            if (jschSession != null) {
//                jschSession.disconnect();
//            }
//        }
//
//    }
//
//}
