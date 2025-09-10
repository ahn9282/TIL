package solid_ex.dip.wrong;

// High-level class
public class Switch {
    private Fan fan;

    public Switch(Fan fan) {
        this.fan = fan;
    }

    public void turnOn() {
        fan.spin();
    }

    public void turnOff() {
        fan.stop();
    }
}
