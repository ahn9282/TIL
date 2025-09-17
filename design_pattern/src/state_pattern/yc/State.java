package state_pattern.yc;

public interface State {

    void open(Door door);

    void close(Door door);

}
