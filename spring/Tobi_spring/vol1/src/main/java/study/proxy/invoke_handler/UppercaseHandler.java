package study.proxy.invoke_handler;

import study.proxy.Hello;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class UppercaseHandler implements InvocationHandler {
    Hello target;

    public UppercaseHandler(Hello target) {
        this.target = target;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        Object ret = method.invoke(target, args);
        if(ret instanceof String && method.getName().startsWith("say")){
            return ((String) ret).toUpperCase();
        }else{
            return ret;
        }
    }
}
