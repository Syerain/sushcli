package top.syewiki.sushcli.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ClassClocker {

    public String timenow;

    public String getTimeNow() {
        LocalDateTime clock = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        this.timenow = clock.format(formatter);
        return timenow;
    }
}
