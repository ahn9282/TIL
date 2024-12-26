package study.string_utils;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;

import static org.assertj.core.api.Assertions.*;

public class refactor_string {
    public static void main(String[] args) {

        //stringUtils.appendIfMissing() : 마지막 문자열 부분이 마지막 파라미터와 다를 경우 가운데 파라미터로 추가된다.(대소문자구분)
        String appendNonMissing = StringUtils.appendIfMissing("Happy New Year", "-from Ahn", "Year");
        assertThat(appendNonMissing).isEqualTo("Happy New Year");
        String appendMissed = StringUtils.appendIfMissing("Happy New Year", "-from Ahn", "year");
        assertThat(appendMissed).isEqualTo("Happy New Year-from Ahn");

        //StringUtils.appendIfMissingIgnoreCase()  : appendIfMissing() 과 동일하다고 볼 수 있지만 대소문자 구분을 하지 않는다.
        String appendMissedIgnoreCase = StringUtils.appendIfMissingIgnoreCase("Happy New Year", "-from Ahn", "year");
        assertThat(appendMissedIgnoreCase).isEqualTo("Happy New Year");

        //StringUtils.capitalize(String str) : 문자열의 첫글자를 대문자로 변환
        String capitalize = StringUtils.capitalize("first word");
        assertThat(capitalize).isEqualTo("First word");

        //StringUtils.chomp(String str, String deleteStr) : 문자열 마지막에 해당하는 문자가 있을 경우 제거
        String chomp = StringUtils.chomp("1234567890", "0");
        assertThat(chomp).isEqualTo("123456789");


        //StringUtils.chop(String str) : 마지막 문자하나제거 str.subString(str.length() -1)과 같은 결과
        String chop = StringUtils.chop("1234");
        assertThat(chop).isEqualTo("123");

        //StringUtils.center() : 설정한 길이 값에서 공백을 추가 오른쪽 - 왼쪽으로 채워져나감
        //StringUtils.center(String str, int space, String spaceStr) : 공백에 spaceStr로 채움
        String centerWhitSpace = StringUtils.center("center",15);
        String centerWhitStar = StringUtils.center("center",15,"*");

        assertThat(centerWhitSpace).isEqualTo("    center     ");
        assertThat(centerWhitStar).isEqualTo("****center*****");
    }
}
