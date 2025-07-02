package study.lambda.lambda6;

public class OuterMain {
    private String message = "외부 클래스";

    public static void main(String[] args) {
        OuterMain outer = new OuterMain();
        System.out.println("[외부 클래스] : " + outer);
        outer.execute();
    }

    public void execute() {
        Runnable anonymous = new Runnable() {

            private String message = "익명 클래스";

            @Override
            public void run() {
                System.out.println("[익명 클래스] this : " + this);
                System.out.println("[익명 클래스] this : " + this.getClass());
                System.out.println("[익명 클래스] this : " + this.message);
            }
        };
        Runnable lambda = () -> {
            System.out.println("[람다] this : " + this);
            System.out.println("[람다] this : " + this.getClass());
            System.out.println("[람다] this : " + this.message);
        };
        anonymous.run();
        System.out.println("------------------------------------");
        lambda.run();
    }
}
