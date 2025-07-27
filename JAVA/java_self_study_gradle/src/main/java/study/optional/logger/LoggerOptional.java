package study.optional.logger;

import java.util.function.Supplier;

public class LoggerOptional {

    private boolean isDebug = false;

    public boolean isDebug(){
        return isDebug;
    }

    public void setDebug(boolean isDebug){
        this.isDebug = isDebug;

    }

    public void debug(Object message){
        if(isDebug){
            System.out.println("[DEBUG] " + message.toString());
        }
    }

    public void debug(Supplier<?> supplier) {
        if(isDebug){
            System.out.println("[DEBUG] " + supplier.get());
        }
    }
}
