package study.string_utils;

import org.apache.commons.lang3.StringUtils;

import static org.assertj.core.api.Assertions.*;

public class abbreviate {
    public static void main(String[] args) {
        //긴 문자열을 정해진 문자열의 길이까지만 보여주고 ...으로 치환한다. 생략 같은 부분에서 사용되면 된다 본다.
        // " ..." 으로 치환되기 떄문에 maxWidth는 4보다 커야한다.
        String abbreviate = StringUtils.abbreviate("Merry Christmass!", 9);
        System.out.println(abbreviate);
        assertThat(abbreviate).isEqualTo("Merry ...");
        //max width < 4
        try{

       StringUtils.abbreviate("Merry Christmass!", 3);
        }catch(IllegalArgumentException e){
            System.out.println("에러발생");
        }

        String abbreviatedNull = StringUtils.abbreviate(null, 10);
       assertThat(abbreviatedNull).isNull();

    }
}
