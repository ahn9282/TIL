package chain_of_reponsibility_pattern.yc;

public class PositiveHandler extends Handler {
    @Override
    protected void process(int number) {
        if (number > 0) {
            System.out.println();
            System.out.println(number + " is positive number");
        }
    }
}
