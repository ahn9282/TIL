package study.proxy.bean_factory;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import study.proxy.invoke_handler.TransactionHandler;

import java.lang.reflect.Proxy;

public class TxFactoryBean implements FactoryBean<Object> {
    Object target;
    PlatformTransactionManager transactionManager;
    String pattern;
    Class<?> serviceInterface;

    public void setTransactionManager(PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
    }

    public void setTarget(Object target) {

        this.target = target;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public void setServiceInterface(Class<?> serviceInterface) {
        this.serviceInterface = serviceInterface;
    }

    public Object getObject() throws Exception{
        TransactionHandler txHandler = new TransactionHandler();
        txHandler.setTarget(target);
        txHandler.setTransactionManager(transactionManager);
        txHandler.setPattern(pattern);
        return Proxy.newProxyInstance(
                getClass().getClassLoader(), new Class[]{serviceInterface}, txHandler
        );

    }

    @Override
    public Class<?> getObjectType() {
        return serviceInterface;
    }

    public boolean isSingleton(){
        return false;
    }

}

