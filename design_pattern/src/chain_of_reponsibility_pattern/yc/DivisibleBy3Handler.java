package chain_of_reponsibility_pattern.yc;

public class DivisibleBy3Handler extends Handler {
    @Override
    protected void process(int number) {
        if(number % 3 == 0) {
            System.out.println(number + " is divible by 3");

        }
    }
}
