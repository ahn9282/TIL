package study.default_method;

import java.time.LocalDateTime;

public class SMSNotifier implements Notifier{
    @Override
    public void notify(String message) {
        System.out.println("[SMS] notify : " + message);
    }
    @Override
    public void scheduleNotification(String message, LocalDateTime scheduleTime) {
        System.out.println("[SMS 전용 스케쥴링] message : " + message + ", scheduleTime : " + scheduleTime);
    }
}
