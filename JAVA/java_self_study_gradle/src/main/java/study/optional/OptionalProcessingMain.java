package study.optional;

import java.util.Optional;

public class OptionalProcessingMain {

    public static void main(String[] args) {
        Optional<String> optValue = Optional.of("Hello");
        Optional<String> optEmpty = Optional.empty();

        System.out.println("=== 1. ifPresent() ===");
        optValue.ifPresent(v -> System.out.println("opt value 값 =  " + v));
        optEmpty.ifPresent(v -> System.out.println("opt empty 값 =  " + v));
        System.out.println("==== 2. ifPresentOfElse ===");
        optValue.ifPresentOrElse(v -> System.out.println("opptValue 값 : " +  v), () -> System.out.println("optValue는 비어있음"));
        optEmpty.ifPresentOrElse(v -> System.out.println("optEmpty 값 : " +  v), () -> System.out.println("optValue는 비어있음"));

        System.out.println("==== 3. ma=p ===");
        Optional<Integer> lengthOpt1 = optValue.map(String::length);
        System.out.println("lengthOpt1 = " + lengthOpt1);
        Optional<Object> lengthOpt2 = optEmpty.map(Object::toString);
        System.out.println("lengthOpt2 = " + lengthOpt2);

        System.out.println("==== 4. flatMap ===");
        Optional<Optional<String>> nestedOpt = optValue.map(e -> Optional.of(e));
        System.out.println("optValue = " + optValue);
        System.out.println("nestedOpt = " + nestedOpt);
        Optional<String> flattenedOpt = optValue.flatMap(o -> Optional.of(o));
        System.out.println("flattenedOpt = " + flattenedOpt);

        System.out.println("==== 5. filter ===");
        Optional<String> filtered1 = optValue.filter(s -> s.startsWith("H"));
        Optional<String> filtered2 = optEmpty.filter(s -> s.startsWith("X"));
        System.out.println("filtered1 = " + filtered1);
        System.out.println("filtered2 = " + filtered2);
    }
}
