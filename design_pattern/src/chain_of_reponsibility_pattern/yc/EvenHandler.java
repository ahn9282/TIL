package chain_of_reponsibility_pattern.yc;

public class EvenHandler extends Handler {
    @Override
    protected void process(int number) {
        if (number % 2 == 0) {
            System.out.println(number + " is even number");
        }
    }
}
