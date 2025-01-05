package restudy.spring_basic.singleton;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import restudy.spring_basic.bean.SpringAutoApplicationConfig;
import restudy.spring_basic.bean.repository.MemberRepository;
import restudy.spring_basic.bean.service.MemberService;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {


    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너")
    void pureContainer() {
        SpringAutoApplicationConfig autoConfig = new SpringAutoApplicationConfig();
        MemberService memberService1 = autoConfig.memberService();
        MemberService memberService2= autoConfig.memberService();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);
    }
}
