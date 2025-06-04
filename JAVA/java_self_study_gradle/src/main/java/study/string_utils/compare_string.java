package study.string_utils;


import static org.assertj.core.api.Assertions.*;

import org.apache.commons.lang3.StringUtils;
import org.assertj.core.api.Assertions;

public class compare_string {
    public static void main(String[] args) {

        boolean contains = StringUtils.contains("abc", "c");
        Assertions.assertThat(contains);

        //문자열 중 만자가 하나라도 포함되어 있다면 true
        boolean containsAny = StringUtils.containsAny("abcde", "cgv");
        assertThat(containsAny);

        //비교할 문자열이 포함되어 있으면 true반환 대소문자 구분 X
        StringUtils.containsIgnoreCase("XXX", "xxx");
        assertThat(containsAny);

        //문자가 하나라도 포함되어 잇으면 false반환
        boolean containsNone = StringUtils.containsNone("apple", "banana");
        assertThat(containsNone);

        //문자열 안에 공백이 포함되어 있으면 true 반환
        boolean containsWhitespace = StringUtils.containsWhitespace("q w e");
        assertThat(containsWhitespace);

        //문자열 내 비교할 문자열이 존재하는 만큼의 수를 반환한다.
        int countMatches = StringUtils.countMatches("AABBCCDDAA", "AA");
        assertThat(countMatches).isEqualTo(2);

        //문자열이 isEmpty(공백, null)에서 true를 반환할 문자열일 경우 뒤 문자열을 반환
        String defaultIfEmpty1 = StringUtils.defaultIfEmpty("", "defaultIfEmpty");
        String defaultIfEmpty2 = StringUtils.defaultIfEmpty(null, "defaultIfEmpty");
        assertThat(defaultIfEmpty1).isEqualTo("defaultIfEmpty");
        assertThat(defaultIfEmpty1).isEqualTo("defaultIfEmpty");

        //문자열이; null일 경우 뒤 문자열로 반환
        String defaultString = StringUtils.defaultString(null, "This is NULL");
        assertThat(defaultString).isEqualTo("This is NULL");

        ///문자열에 공백이 존재할 경우 삭제
        String deleteWhiteSpace = StringUtils.deleteWhitespace("a b c d e f");
        assertThat(deleteWhiteSpace).isEqualTo("abcdef");

        //문자열의 마지막 문자열과 비교하여 같은지에 대한 boolean 반환 대소문자 구분 O
        boolean endsWithAny1 = StringUtils.endsWithAny("plan a", "a");
        boolean endsWithAny2 = StringUtils.endsWithAny("plan a", "A");
        assertThat(endsWithAny1).isTrue();
        assertThat(endsWithAny2).isFalse();


    }

}