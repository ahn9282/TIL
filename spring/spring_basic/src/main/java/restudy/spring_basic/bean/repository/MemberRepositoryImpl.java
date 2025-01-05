package restudy.spring_basic.bean.repository;

import restudy.spring_basic.bean.ob.TestMember;

import java.util.HashMap;
import java.util.Map;

public class MemberRepositoryImpl implements MemberRepository {

    private Map<Long, TestMember> members = new HashMap<>();

    public MemberRepositoryImpl(){
        for (Long i = 1L; i <=5; i++) {
            members.put(i, TestMember.createMemberByNumber(i));
        }
    }

    @Override
    public Map<Long, TestMember> findAll() {
        return members;
    }

    @Override
    public TestMember findByIn(Long id) {
        return members.get(id);
    }
}
