package state_pattern.yc;

public class ClosedState implements State {

    @Override
    public void open(Door door) {
        System.out.println("Door is now Open");
        door.setState(new OpenState());
    }

    @Override
    public void close(Door door) {
        System.out.println("Door is already Closed");
    }
}
