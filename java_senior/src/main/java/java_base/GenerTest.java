package java_base;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class GenerTest {
    public static void main(String[] args) {
        System.out.println(String.format("[%s]Create proxy topic successfully. topic request: %s", getCurrentTime(), "2"));
    }

    public static String getCurrentTime() {
        String timeStr = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        return timeStr;
    }
}
