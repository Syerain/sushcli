package top.syewiki.sushcli.utils;

import java.io.IOException;
import java.net.ServerSocket;

public class ClassNewServerSocket extends ServerSocket{

    ServerSocket iSrvSkt;

    public ClassNewServerSocket(int port) throws IOException{
        try {
            this.iSrvSkt = new ServerSocket(port);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //返回在构造方法中new出来的ServerSocket对象
    public ServerSocket getServerSocket(){
        return this.iSrvSkt;
    }
}
