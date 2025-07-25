package study.optional;

import java.util.Optional;

public class OptionalRetrievalMain {

    public static void main(String[] args) {

        Optional<String> optValue = Optional.ofNullable("Hello");
        Optional<String> optEmpty = Optional.empty();

        System.out.println("====== 1. isPresent() / 2. isEmpty()  ========");
        System.out.println("optValue.isPresent() = " + optValue.isPresent());
        System.out.println("optEmpty.isPresent() = " + optEmpty.isPresent());
        System.out.println("optEmpty.isEmtpy() = " + optEmpty.isEmpty());

        System.out.println("====== 2. get ======");
        String getValue = optValue.get();
        System.out.println("getValue = " + getValue);
        // 예외 발생 String getValue2 = optEmpty.get();
        // System.out.println("getValue2 = " + getValue2);

        System.out.println("---- 3. orElse() =====");
        String value1 = optValue.orElse("기본 값");
        String empty1 = optEmpty.orElse("기본 값");
        System.out.println("value1 = " + value1);
        System.out.println("empty1 = " + empty1);

        System.out.println("======= 4. orElseGet() =====");
        String value2 = optValue.orElseGet(() -> {
            System.out.println("람다 호출 - optValue");
            return "New value";
        });

        String empty2 = optEmpty.orElseGet(() -> {
            System.out.println("람다 호출 - optEmpty");
            return "New Value";
        });
        System.out.println("value2 = " + value2);
        System.out.println("empty2 = " + empty2);

        System.out.println("======= 5. orElseThrow() =====");
        String value3 = optValue.orElseThrow(() -> new RuntimeException("값이 없습니다!!!"));
        System.out.println("value3 = " + value3);
        try {
            String empty3 = optEmpty.orElseThrow(() -> new RuntimeException("값이 없습니다!!"));
        } catch (Exception e) {
            System.out.println("예외 발생 + " + e);
        }

        System.out.println("======= 6. or() =====");
        Optional<String> result1 = optValue.or(() -> Optional.of("Fallback!!"));
        System.out.println("result1 = " + result1);
        Optional<String> result2 = optEmpty.or(() -> Optional.of("Fallback!!"));
        System.out.println("result2 = " + result2);
    }
}
