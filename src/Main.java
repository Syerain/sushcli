import top.syewiki.sushcli.utils.*;

import javax.management.InstanceNotFoundException;
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
            echo.echo("INFO", "程序初始化完毕.");
            echo.echo("INFO", "正在尝试连接到主机 ... (syewiki.top:1618)");

            try {
                msger.init(false);
            } catch (Exception e) {
                System.out.println(ansiColors.RED+"【"+clocker.getTimeNow()+"】ERROR: \t⚠无法连接至主机"+ansiColors.RESET);
                echo.echo("DEBUG","尝试重新连接 ...");
                continue;
            }

            echo.echo("INFO", "成功连接至主机");

            while (true) {
                Scanner sc = new Scanner(System.in);
                echo.echo("", "请输入命令：$ ", false);
                String str = sc.nextLine();
                try {
                    msger.sendMsg(str, false);
                } catch (Exception e) {
                    System.out.println(ansiColors.RED+"【"+clocker.getTimeNow()+"】ERROR: \t⚠在尝试发出指令时出错"+ansiColors.RESET);
                    echo.echo("DEBUG","尝试重新初始化 ...");
                    break;
                }
            }
        }
    }
}