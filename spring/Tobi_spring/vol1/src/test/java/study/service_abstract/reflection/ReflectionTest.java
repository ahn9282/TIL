package study.service_abstract.reflection;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.PlatformTransactionManager;
import study.config.BeanConfig;
import study.proxy.Hello;
import study.proxy.impl.HelloTarget;
import study.proxy.impl.HelloUpperCase;
import study.proxy.invoke_handler.TransactionHandler;
import study.proxy.invoke_handler.UppercaseHandler;
import study.service_abstract.service.UserService;
import study.service_abstract.service.impl.UserServiceImpl;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = BeanConfig.class)
public class ReflectionTest {
    @Autowired
    @Qualifier("userServiceImpl")
    UserServiceImpl userServiceImpl;
    @Autowired
    PlatformTransactionManager tm;

    @Test
    public void invokeMethod() throws Exception {
        String name = "Spring";

        assertThat(name.length()).isEqualTo(6);

        Method lengthMethod = String.class.getMethod("length");
        assertThat((Integer) lengthMethod.invoke(name)).isEqualTo(6);

        assertThat(name.charAt(0)).isEqualTo('S');
    }

    @Test
    public void simpleProxy() {
        Hello hello = new HelloTarget();
        assertThat(hello.sayHello("Toby")).isEqualTo("Hello Toby");
        assertThat(hello.sayThankYou("Toby")).isEqualTo("Thank You Toby");
        assertThat(hello.sayHi("Toby")).isEqualTo("Hi Toby");

    }

    @Test
    public void simpleUpperProxy() {
        Hello hello = new HelloTarget();
        Hello helloUpperCase = new HelloUpperCase(hello);
        assertThat(helloUpperCase.sayHello("Toby")).isEqualTo(("HELLO TOBY"));
        assertThat(helloUpperCase.sayThankYou("Toby")).isEqualTo(("THANK YOU TOBY"));
        assertThat(helloUpperCase.sayHi("Toby")).isEqualTo(("HI TOBY"));

    }

    @Test
    public void proxyHelloCustomInvocationHandlerTest() {
        Hello proxieHello = (Hello) Proxy.newProxyInstance(
                getClass().getClassLoader(),
                new Class[]{Hello.class},
                new UppercaseHandler(new HelloTarget())
        );

    }

    @Test
    public void upgradeAllOrNothing() throws Exception {
        TransactionHandler txHandler = new TransactionHandler();
        txHandler.setTarget(userServiceImpl);
        txHandler.setTransactionManager(tm);
        txHandler.setPattern("upgradeLevels");
        UserServiceImpl txUserService = (UserServiceImpl) Proxy.newProxyInstance(getClass().getClassLoader(),
                new Class[]{UserService.class},
                txHandler);
    }


}
