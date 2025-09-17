package state_pattern.yc;

public class PlayingState implements State2{
    @Override
    public void play(VideoPlayer player) {
        System.out.println("Video is already playing");
    }

    @Override
    public void stop(VideoPlayer player) {
        System.out.println("Pausing the video.");
        player.setState(new PausedState());
    }
}
