package study.lambda.lambda1;

public class SamMain {
    public static void main(String[] args) {
        SamInterface sam = () -> {
            System.out.println("sam");
        };
        sam.run();

        NoSamInterface noSamInterface = () -> {
            System.out.println("noSamInterface");
        };
        noSamInterface.go();
    }
}
