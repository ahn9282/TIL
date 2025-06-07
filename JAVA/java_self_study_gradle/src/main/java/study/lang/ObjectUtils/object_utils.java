package study.lang.ObjectUtils;

import org.apache.commons.lang3.ObjectUtils;

public class object_utils {
    public static void main(String[] args) {
        Integer nullInteger = null;

        Integer result = ObjectUtils.defaultIfNull(nullInteger, 1);
        System.out.println(result);
    }
}
