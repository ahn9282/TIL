package restudy.spring_basic.bean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import restudy.spring_basic.bean.repository.MemberRepository;
import restudy.spring_basic.bean.repository.MemberRepositoryImpl;
import restudy.spring_basic.bean.service.MemberService;
import restudy.spring_basic.bean.service.MemberServiceImpl;

@Configuration
public class SpringAutoApplicationConfig {

    @Bean
    public MemberRepository memberRepository(){
        return new MemberRepositoryImpl();
    }
    @Bean
    public MemberService memberService(){
        return new MemberServiceImpl(memberRepository());
    }
}
