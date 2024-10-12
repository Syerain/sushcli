package top.syewiki.sushcli.utils;

public class ClassStdRollEcho {

    ClassClocker clocker;

    public ClassStdRollEcho(){
        this.clocker = new ClassClocker() ;
    }

    public void echo(String speaker, String content){
        System.out.println("【"+clocker.getTimeNow()+"】"+speaker+"：\t"+content);
    }

    public void echo(String speaker, String content, boolean ifEnter){
        if (ifEnter) System.out.println("【"+clocker.getTimeNow()+"】"+speaker+"：\t"+content);
        if (!ifEnter) System.out.print("【"+clocker.getTimeNow()+"】"+speaker+"：\t"+content);
    }

    public void echo(String speaker, String content, boolean ifEnter, boolean ifEnlog){
        System.out.println("【"+clocker.getTimeNow()+"】"+speaker+"：\t"+content);
        //enlog here
    }

}
