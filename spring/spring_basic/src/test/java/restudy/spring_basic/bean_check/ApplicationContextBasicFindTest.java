package restudy.spring_basic.bean_check;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import restudy.spring_basic.bean.SpringAutoApplicationConfig;
import restudy.spring_basic.bean.service.MemberService;
import restudy.spring_basic.bean.service.MemberServiceImpl;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class ApplicationContextBasicFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SpringAutoApplicationConfig.class);


    @Test
    @DisplayName("빈이름으로 조회")
    void findBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        System.out.println("memberService = " + memberService);
        System.out.println("memberService.getClass() = " + memberService.getClass());
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
    }


}

