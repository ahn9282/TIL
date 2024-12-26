package study.string_utils;

import org.apache.commons.lang3.StringUtils;

import static org.assertj.core.api.Assertions.*;
public class contains {
    public static void main(String[] args) {

        String nullStr = null;
        String lenZeroStr = "";
        String hasTextStr = "watch";

        boolean hasW = StringUtils.contains(hasTextStr, "w");
        boolean hasQ = StringUtils.contains(hasTextStr, "q");
        assertThat(hasW).isTrue();
        assertThat(hasQ).isFalse();
        boolean resultNullStr = hasText(nullStr);
        boolean resultZeroLengthStr = hasText(lenZeroStr);
        boolean resultHasContentStr = hasText(hasTextStr);
        assertThat(resultHasContentStr).isTrue();
        assertThat(resultZeroLengthStr).isFalse();
        assertThat(resultNullStr).isFalse();
    }

    private static boolean hasText(String str) {
        return StringUtils.isNotBlank(str);
    }
}
