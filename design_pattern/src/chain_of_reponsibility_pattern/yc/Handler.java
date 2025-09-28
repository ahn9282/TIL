package chain_of_reponsibility_pattern.yc;

public abstract class Handler {
    protected Handler next;

    public void handle(int number) {
        process(number);
        if (next != null) {
            next.handle(number);
        }
    }

    public void setNext(Handler next) {
        this.next = next;
    }

    protected abstract void process(int number);
}

