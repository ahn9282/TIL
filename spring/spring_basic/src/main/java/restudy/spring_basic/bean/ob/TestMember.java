package restudy.spring_basic.bean.ob;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class TestMember {
    private Long id;
    private String name;
    private String username;

    public static TestMember createMemberByNumber(Long num){

        String value = "member" + num;
        return new TestMember(num, value, value);
    }

}
