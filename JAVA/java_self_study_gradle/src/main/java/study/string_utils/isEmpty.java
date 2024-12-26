package study.string_utils;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.Validate;

import static org.assertj.core.api.Assertions.*;

public class isEmpty {
    public static void main(String[] args) {
        String emptyStr = "";
        String existStr = "I'm here";
        assertThat(emptyStr).isEmpty();
        Validate.isTrue(StringUtils.isEmpty(emptyStr));
        Validate.isTrue(! StringUtils.isEmpty(existStr));
    }
}
