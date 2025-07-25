package study.optional;

import java.util.HashMap;
import java.util.Map;

public class OptionalStartMain1 {

    private static final Map<Long, String> map = new HashMap<>();

    static {
        map.put(1L, "kim");
        map.put(2L, "Seo");
    }

    public static void main(String[] args) {
        System.out.println(map.get(1L));
        findAndPrint(1L);
        findAndPrint(3L);
    }

    static void findAndPrint(Long id) {
        String find = findNameById(id);
        if(find == null) {
            System.out.println(id + " : UNKNOWN");
        }else{
            System.out.println(id + " : name = " + find.toUpperCase());
        }
    }

    static String findNameById(Long id) {
        return map.get(id);
    }
}