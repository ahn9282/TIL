package adapter_pattern.yc;

public class HDMIAdapter implements DisplayAdapter {

    private HDMI hdmi;
    private String resolution;
    public HDMIAdapter(HDMI hdmi, String resolution) {
        this.hdmi = hdmi;
        this.resolution = resolution;
    }

    @Override
    public void display() {
        hdmi.connectWithHDMICable(resolution);
    }
}
