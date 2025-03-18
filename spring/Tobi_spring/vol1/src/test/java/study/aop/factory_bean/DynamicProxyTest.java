package study.aop.factory_bean;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.config.BeanConfig;
import study.proxy.Hello;
import study.proxy.invoke_handler.UppercaseHandler;

import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BeanConfig.class)
public class DynamicProxyTest {

    @Test
    public void simpleProxy(){
        Hello proxyHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{Hello.class},
                new UppercaseHandler( new HelloTarget())
        );
    }

    @Test
    public void proxyFactoryBean(){
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget());
        pfBean.addAdvice(new UppercaseAdvice());

        Hello proxiedHello = (Hello) pfBean.getObject();

        assertThat(proxiedHello.sayHello("JS")).isEqualTo("HELLO JS");
        assertThat(proxiedHello.sayHi("JS")).isEqualTo("HI JS");
        assertThat(proxiedHello.sayThankYou("JS")).isEqualTo("THANK YOU JS");
    }
    @Test
    public void pointCutAdvisor(){
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(new HelloTarget());
        NameMatchMethodPointcut pointCut = new NameMatchMethodPointcut();
        pointCut.setMappedNames("sayH*");

        pfBean.addAdvisor(new DefaultPointcutAdvisor(pointCut, new UppercaseAdvice()));

        Hello proxieHello = (Hello) pfBean.getObject();

        assertThat(proxieHello.sayHello("JS")).isEqualTo("HELLO JS");
        assertThat(proxieHello.sayHi("JS")).isEqualTo("HI JS");
        assertThat(proxieHello.sayThankYou("JS")).isEqualTo("Thank You JS");
    }

    static  class UppercaseAdvice implements MethodInterceptor {


        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            String ret = (String) invocation.proceed();
            return ret.toUpperCase();
        }
    }

    static class HelloTarget implements Hello{
        @Override
        public String sayHello(String name) { return "Hello " + name; }
        @Override
        public String sayHi(String name) { return "Hi " + name; }
        @Override
        public String sayThankYou(String name) {  return "Thank You " + name;}

        public HelloTarget() {
        }
    }

}
