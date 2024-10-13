import top.syewiki.sushcli.utils.*;

import javax.management.InstanceNotFoundException;
import java.net.ConnectException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String hostaddr = "syewiki.top";
        int hostport = 1618;    //穗的生日哦(⊙o⊙)

        ClassGlobalConsts global = new ClassGlobalConsts(
                "SuiShell.Console - Client - 1.0.0",
                "SuiShell",
                "sushcli",
                "1.0.0",
                "common-client-win"
        );
        ClassClocker clocker = new ClassClocker();
        ClassStdRollEcho echo = new ClassStdRollEcho();
        ClassMsger msger = new ClassMsger(hostaddr,hostport);
        ClassANSIcolors ansiColors = new ClassANSIcolors();

        //START
        while(true) {
            echo.echo("INFO", "程序初始化中 ... Done.");
            echo.echo("INFO", "正在尝试连接到主机(syewiki.top:1618) ... ");

            try {
                msger.sendMsg("测试封头",true);
            } catch (Exception e) {
                System.out.println(ansiColors.RED+"【"+clocker.getTimeNow()+"】ERROR: \t⚠无法连接至主机"+ansiColors.RESET);
                echo.echo("DEBUG","尝试重新连接 ...");
                continue;
            }

            echo.echo("INFO", "成功连接至主机");

            while (true) {
                Scanner sc = new Scanner(System.in);
                echo.echo("输入命令", "\t> $ ", false);
                System.out.print(ansiColors.GREEN);
                String str = sc.nextLine();
                System.out.print(ansiColors.RESET);
                try {
                    //echo.echo("DEBUG","开始发信");
                    msger.sendMsg(str, false);
                    //echo.echo("DEBUG","完成发信");

                    String msgRcv = msger.rcvMsg(false);

                    echo.echo("主机反馈:", "\t> # ", false);
                    System.out.print(ansiColors.YELLOW);
                    System.out.print(msgRcv+"\n");
                    System.out.print(ansiColors.RESET);
                }
                catch (ConnectException e) {
                    System.out.println(ansiColors.RED+"【"+clocker.getTimeNow()+"】ERROR: \t⚠与服务器的连接断开"+ansiColors.RESET);
                    echo.echo("DEBUG","重置连接中 ...");
                    break;
                }
                catch (RuntimeException e) {
                    System.out.println(ansiColors.RED+"【"+clocker.getTimeNow()+"】ERROR: \t⚠运行时错误"+ansiColors.RESET);
                    System.out.println(ansiColors.RED+"【"+clocker.getTimeNow()+"】ERROR: \t⚠请重新启动程序"+ansiColors.RESET);
                    System.exit(0);
                }
                catch (Exception e) {
                    System.out.println(ansiColors.RED+"【"+clocker.getTimeNow()+"】ERROR: \t⚠发生了不明错误"+ansiColors.RESET);
                    e.printStackTrace();
                    echo.echo("输入命令", "\t> $ ", false);
                }
            }
        }
    }
}