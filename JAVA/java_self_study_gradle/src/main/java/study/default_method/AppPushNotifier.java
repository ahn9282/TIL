package study.default_method;

import java.time.LocalDateTime;

public class AppPushNotifier implements Notifier{
    @Override
    public void notify(String message) {
        System.out.println("[APP] notify : " + message);
    }
    @Override
    public void scheduleNotification(String message, LocalDateTime scheduleTime) {
        System.out.println("[APP 전용 스케쥴링] message : " + message + ", scheduleTime : " + scheduleTime);
    }
}
