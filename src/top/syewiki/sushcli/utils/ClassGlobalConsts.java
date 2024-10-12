package top.syewiki.sushcli.utils;

public class ClassGlobalConsts {
    public static String fullTitle = "SuiShell.Console - Client - 1.0.0";
    public static String semiTitle = "SuiShell";
    public static String minititle = "sushcli";
    public static String cliver = "1.0.0";
    public static String edition = "common-client-win";

    public String getFullTitle(){
        return this.fullTitle;
    }
    public String getSemiTitle(){
        return this.semiTitle;
    }
    public String getCliver(){
        return this.cliver;
    }
    public String getEdition(){
        return this.edition;
    }

    public ClassGlobalConsts(String fullTitle,
                             String semiTitle,
                             String minititle,
                             String cliver,
                             String edition )
    {
        this.fullTitle = fullTitle;
        this.semiTitle = semiTitle;
        this.cliver = cliver;
        this.edition = edition;
    }
}
