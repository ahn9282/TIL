package state_pattern.yc;

public class StoppedState implements State2 {
    @Override
    public void play(VideoPlayer player) {
        System.out.println("Starting the video.");
        player.setState(new PlayingState());
    }

    @Override
    public void stop(VideoPlayer player) {
        System.out.println("Video is already stopped.");
    }
}
