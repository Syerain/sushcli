package top.syewiki.sushcli.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class ClassMsger {

    public Socket clientSocket;
    public InputStream instrm;
    public OutputStream outstrm;
    public String hostAddr;
    public int hostPort;
    public String TempMsgRcv;
    public String TempMsgSend;

    //构造方法 初始化主机地址、主机端口的参数
    public ClassMsger(String hostAddr,int hostPort){
        this.hostAddr = hostAddr;
        this.hostPort = hostPort;
    }

    //初始化方法，初始化连接和io流
    //可以改形参来实现外部自定义初始化，但不建议这么做
    public void init (/*String hostAddr,int hostPort*/boolean ifClose) throws Exception {
            // 创建TCP客户端并连接到服务器
            //System.out.println("正在尝试连接到服务端 ...");
            //System.out.println("(目标主机:"+hostAddr+":"+hostAddr+")");
            this.clientSocket = new Socket(hostAddr, hostPort);

            //反馈
            //System.out.println("服务端连接成功.");

            // 初始化io流
            this.instrm = this.clientSocket.getInputStream();
            this.outstrm = this.clientSocket.getOutputStream();

            if(ifClose){
                this.clientSocket.close();
            }
    }

    //向服务端发信
    //发信前初始化io
    public void sendMsg(String msgContent, boolean ifCloseSocket) throws Exception{
        try {
            this.init(false);
            this.outstrm.write(msgContent.getBytes());
            if (ifCloseSocket) {
                this.clientSocket.close();
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    //从服务端收信
    //发信前初始化io
    public String rcvMsg(boolean ifInit) throws Exception{

        if (ifInit) {
            this.init(false);
        }else {
            // byte[] iBuffer 作为缓冲区使用
            byte[] iBuffer = new byte[1024];

            //读取来自服务端的输入流并赋予 String msgRcv
            int bytesRead = this.instrm.read(iBuffer);
            String msgRcv = new String(iBuffer, 0, bytesRead);
            this.clientSocket.close();

            //将来信结果返回
            this.TempMsgRcv = msgRcv;
            return msgRcv;
        }
        return this.TempMsgRcv;
    }

    //获取历史发信
    private String getTempMsgSend(){
        return this.TempMsgSend;
    }

    //获取历史收信
    public String getTempMsgRcv(){
        return this.TempMsgRcv;
    }

}
