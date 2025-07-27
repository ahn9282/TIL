package study.optional;

import java.util.Optional;
import java.util.Random;

public class OrElseGetMain {
    public static void main(String[] args) {
        Optional<Integer> optValue = Optional.of(100);
        Optional<Integer> optEmpty = Optional.empty();

        System.out.println("단순 계산");
        Integer i1 = optValue.orElse(10 + 20);
        Integer i2 = optEmpty.orElse(10 + 20);
        System.out.println("i1 = " + i1);
        System.out.println("i2 = " + i2);

        System.out.println("=== orElse");
        System.out.println("값이 있는 경우");
        Integer value1 = optValue.orElseGet(() -> createData());
        System.out.println("value1 = " + value1);


        System.out.println("=== 값이 없는 경우 ===");
        Integer value2 = optEmpty.orElseGet(() -> createData());
        System.out.println("value2 = " + value2);
    }

    static int createData() {
        System.out.println("데이터를 생성합니다.");
        try {
            Thread.sleep(3000);

        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        int createValue = new Random().nextInt(100);
        System.out.println("데이터 생성이 완료되었습니다. 생성 값 : " + createValue);
        return createValue;
    }
}
