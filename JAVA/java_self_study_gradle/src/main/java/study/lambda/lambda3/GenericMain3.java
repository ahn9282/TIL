package study.lambda.lambda3;

public class GenericMain3 {
    public static void main(String[] args) {

        GenericFunction<String, String> upperCase = new GenericFunction() {
            @Override
            public String apply(Object s) {
                return ((String) s).toUpperCase();
            }
        };
        String result1 = (String) upperCase.apply("hello");
        System.out.println("result1 = " + result1);

        GenericFunction<Integer, Integer> square = n -> n *  n;
        Integer result2 = square.apply(4);
        System.out.println("result2 = " + result2);
    }


    @FunctionalInterface
    interface GenericFunction<T, R>{
        R apply(T t);
    }

}
