package study.optional.logger;

public class LogMain2 {
    public static void main(String[] args) {
        LoggerOptional logger = new LoggerOptional();
        logger.setDebug(true);
        logger.debug(() -> value100() + value200());

        System.out.println("=== debug mode off ===");
        logger.setDebug(false);
        logger.debug(() -> value100() + value200());

        System.out.println("=== 디버그 모드 체크 ====");
        if(logger.isDebug()){
            logger.debug(value100() + value200());
        }
    }

    static int value100(){
        System.out.println("value100 호출");
        return 100;
    }
    static int value200(){
        System.out.println("value100 호출");
        return 200;
    }

}