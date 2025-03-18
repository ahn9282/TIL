package study.config;

import org.springframework.aop.framework.autoproxy.AbstractAutoProxyCreator;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import study.proxy.advice.TransactionAdvice;
import study.proxy.pointcut.NameMatchClassMethodPointcut;

@Configuration
public class ProxyBeanConfig {
    @Bean
    public TransactionAdvice transactionAdvice(){
        return new TransactionAdvice();
    }
    @Bean
    @Qualifier("transactionPointcut")
    public NameMatchMethodPointcut transactionPointcut(){
//        NameMatchMethodPointcut pointcut = new NameMatchMethodPointcut();
//        pointcut.setMappedNames("upgrade*");
//        return pointcut;
        return new NameMatchClassMethodPointcut();
    }
    @Bean
    @Qualifier("transactionAdvisor")
    public DefaultPointcutAdvisor transactionAdvisor(){
        return new DefaultPointcutAdvisor(transactionPointcut(), transactionAdvice());
    }

    @Bean
    public AbstractAutoProxyCreator defaultAdvisorAutoProxyCreator(){
        return new DefaultAdvisorAutoProxyCreator();
    }


}
