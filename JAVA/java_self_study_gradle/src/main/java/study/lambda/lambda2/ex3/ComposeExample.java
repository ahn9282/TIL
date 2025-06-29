package study.lambda.lambda2.ex3;

public class ComposeExample {
// 고차 함수, f1, f2라는 두 함수를 인자로 받아, "f1을 먼저, f2를 나중"에 적용하는 새 함수  반환
    public static MyTransformer compose(MyTransformer f1, MyTransformer f2) {

        return s ->{
            String transform = f1.transform(s);
            String result = f2.transform(transform);
            return result;
        };
    }
    public static void main(String[] args) {
        MyTransformer toUpper = s -> s.toUpperCase();
        MyTransformer addDeco = s -> "**" + s + "**";
        MyTransformer composeFunc = compose(toUpper, addDeco);
        String result = composeFunc.transform("hello");
        System.out.println(result); // "**HELLO**"
    }
}