package restudy.spring_basic.bean_check;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import restudy.spring_basic.bean.SpringAutoApplicationConfig;
import restudy.spring_basic.bean.repository.MemberRepository;
import restudy.spring_basic.bean.repository.MemberRepositoryImpl;
import restudy.spring_basic.bean.service.MemberService;
import restudy.spring_basic.bean.service.MemberServiceImpl;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ApplicationContextSameBeanFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SameMemberRepositoryConfig.class);


    @Test
    @DisplayName("타입으로 조회 시 동일 탑이이 둘 이상이면,  중복 오류 발생")
    void findBeanTypeDuplicate(){

        assertThrows( NoUniqueBeanDefinitionException.class ,
                () -> ac.getBean( MemberRepository.class));
    }

    @Test
    @DisplayName("타입으로 조회 시 동일 탑이이 둘 이상이면, 빈 이름 지정으로 예외 해결")
    void findBeanByName(){

        MemberRepository memberRepository1 = ac.getBean("memberRepository1", MemberRepository.class);
        assertThat(memberRepository1).isInstanceOf(MemberRepository.class);
    }

    @Test
    @DisplayName("특정 타입을 모두 조회하기")
    void findBeanAllTypeByName(){

        Map<String, MemberRepository> beansOfType = ac.getBeansOfType(MemberRepository.class);
        for (String beanName : beansOfType.keySet()) {
            System.out.println("key : " + beanName + ", value = " + beansOfType.get(beanName));
        }
        System.out.println("beansOfType = " + beansOfType);
        assertThat(beansOfType.size()).isEqualTo(2);
    }

    @Configuration
    static class SameMemberRepositoryConfig{

        @Bean
        public MemberRepository memberRepository1(){
            return new MemberRepositoryImpl();
        }

        @Bean
        public MemberRepository memberRepository2(){
            return new MemberRepositoryImpl();
        }
    }


}

