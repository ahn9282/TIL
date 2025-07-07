package study.default_method;

import java.time.LocalDateTime;

public interface Notifier {
    //알림을 보내는 기능
    void notify(String message);

    void scheduleNotification(String message, LocalDateTime scheduleTime);

    default void defaultMethod(String message){
        System.out.println("[DEFAULT METHOD] message : " + message);
    }
}
