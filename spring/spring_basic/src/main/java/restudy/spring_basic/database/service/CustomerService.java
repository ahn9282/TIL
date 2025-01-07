package restudy.spring_basic.database.service;

import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.DefaultTransactionDefinition;
import restudy.spring_basic.bean.repository.MemberRepository;
import restudy.spring_basic.database.repository.CustomerRepository;

import java.sql.SQLException;

//transaction 매니저를 사용한 트랜잭션 동기화
public class CustomerService {
    private CustomerRepository customerRepository;
    private PlatformTransactionManager transactionManager;

    public void accountTransfer(String formId, String toId, int money)throws SQLException{
        TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());

        try{
            //비즈니스 로직
            transactionManager.commit(status);
        }catch(Exception e){
            transactionManager.rollback(status);
            throw new IllegalStateException();
        }
    }
}
