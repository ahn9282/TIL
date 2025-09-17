package bridge_pattern.yc;

public class Radio implements Device {
    private boolean on = false;
    private int volume = 0;

    @Override
    public void turnOn() {
        on = true;
        System.out.println("RADIO is on");
    }

    @Override
    public void turnOff() {
        on = false;
        System.out.println("RADIO is off");
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        System.out.println("RADIO volume set to " + volume);
    }

    @Override
    public boolean isEnabled() {
        return on;
    }
}
