package restudy.spring_basic.bean.service;

import restudy.spring_basic.bean.ob.TestMember;
import restudy.spring_basic.bean.repository.MemberRepository;

import java.util.Map;

public interface MemberService {

    TestMember getFindMember(Long id);

    Map<Long, TestMember> getAllMember();
}
