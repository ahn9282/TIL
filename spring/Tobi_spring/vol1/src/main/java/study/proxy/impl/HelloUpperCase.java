package study.proxy.impl;

import study.proxy.Hello;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class HelloUpperCase implements Hello {

    Hello hello;

    public HelloUpperCase(Hello hello) {
        this.hello = hello;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Exception {
        String ret = (String) method.invoke(hello, args);
        return ret.toUpperCase();
    }

    @Override
    public String sayHello(String name) {
        return hello.sayHello(name).toUpperCase();
    }

    @Override
    public String sayHi(String name) {
        return hello.sayHi(name).toUpperCase();
    }

    @Override
    public String sayThankYou(String name) {
        return hello.sayThankYou(name).toUpperCase();
    }
}
