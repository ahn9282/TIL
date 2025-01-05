package restudy.spring_basic.bean.repository;

import restudy.spring_basic.bean.ob.TestMember;

import java.util.Map;

public interface MemberRepository {
    Map<Long, TestMember> findAll();

    TestMember findByIn(Long id);
}
