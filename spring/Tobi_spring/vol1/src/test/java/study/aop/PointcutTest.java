package study.aop;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.aop.ClassFilter;
import org.springframework.aop.Pointcut;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.framework.ProxyFactoryBean;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import study.aop.target.impl.Target;
import study.config.BeanConfig;
import study.proxy.Hello;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BeanConfig.class)
public class PointcutTest {


    @Test
    public void methodSignaturePointcut() throws Exception{
        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
        pointcut.setExpression("execution(public int study.aop.target.impl.Target.minus(int,int))");

        //Target.minus()
        assertThat(pointcut.getClassFilter().matches(Target.class)
                && pointcut.getMethodMatcher().matches(Target.class.getMethod("minus", int.class, int.class), null)).isTrue();

        //Target.plus()
        assertThat(pointcut.getClassFilter().matches(Target.class)
                && pointcut.getMethodMatcher().matches(Target.class.getMethod("plus", int.class, int.class), null)).isFalse();

        //Bean.method()
        assertThat(pointcut.getClassFilter().matches(Target.class)
                && pointcut.getMethodMatcher().matches(Target.class.getMethod("method", int.class, int.class), null)).isFalse();
    }
    @Test
    public void pointcutExecutionTest() throws NoSuchMethodException {
        Method minus = Target.class.getMethod("minus", int.class, int.class);
        System.out.println(minus);
        assertThat(minus).isEqualTo(Target.class.getMethod("minus", int.class, int.class));
    }

    @Test
    public void classNumPontCutAdvisor() {
        NameMatchMethodPointcut classMethodPointcut = new NameMatchMethodPointcut() {
            public ClassFilter getClassFilter(){
                return new ClassFilter() {
                    public boolean matches(Class<?> clazz) {
                        return clazz.getSimpleName().startsWith("HelloT");
                    }
                };
            }
        };

        classMethodPointcut.setMappedNames("sayH*");

        checkAdviced(new HelloTarget(), classMethodPointcut, true);

        class HelloWorld extends HelloTarget{};
        checkAdviced(new HelloWorld(), classMethodPointcut, false);
        class HelloTest extends HelloTarget{};

        checkAdviced(new HelloTest(), classMethodPointcut, true);
    }

    public void checkAdviced(Object target, Pointcut pointcut, boolean adviced) {
        ProxyFactoryBean pfBean = new ProxyFactoryBean();
        pfBean.setTarget(target);
        pfBean.addAdvisor(new DefaultPointcutAdvisor(pointcut, new UppercaseAdvice()));

        Hello proxiedHello = (Hello) pfBean.getObject();
        if (adviced) {
            assertThat(proxiedHello.sayHello("An")).isEqualTo("HELLO AN");
            assertThat(proxiedHello.sayHi("An")).isEqualTo("HI AN");
            assertThat(proxiedHello.sayThankYou("An")).isEqualTo("Thank You " +"An");
        }else{
            assertThat(proxiedHello.sayHello("An")).isEqualTo("Hello An");
            assertThat(proxiedHello.sayHi("An")).isEqualTo("Hi An");
            assertThat(proxiedHello.sayThankYou("An")).isEqualTo("Thank You An");
        }

    }

    static  class UppercaseAdvice implements MethodInterceptor {


        @Override
        public Object invoke(MethodInvocation invocation) throws Throwable {
            String ret = (String) invocation.proceed();
            return ret.toUpperCase();
        }
    }

    static class HelloTarget implements Hello {
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
