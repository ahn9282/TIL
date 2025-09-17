package state_pattern.yc;

public class VideoPlayer {

    private State2 state;

    public VideoPlayer() {
        this.state = new StoppedState();
    }
    public void setState(State2 state) {
        this.state = state;
    }
}
