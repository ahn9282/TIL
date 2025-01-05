package restudy.spring_basic.bean.service;

import restudy.spring_basic.bean.ob.TestMember;
import restudy.spring_basic.bean.repository.MemberRepository;

import java.util.Map;

public class MemberServiceImpl implements MemberService {
    private  MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public TestMember getFindMember(Long id) {
        return memberRepository.findByIn(id);
    }

    @Override
    public Map<Long, TestMember> getAllMember() {
        return memberRepository.findAll();
    }
}
