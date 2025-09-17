package adapter_pattern.yc;

import java.util.ArrayList;
import java.util.List;

public class Main2 {
    public static void main(String[] args) {
        USB usb = new USB();
        HDMI hdmi = new HDMI();
        VGA vga = new VGA();

        List<DisplayAdapter> adapters = new ArrayList<>();
        adapters.add(new HDMIAdapter(hdmi, "HDMI 2K"));
        adapters.add(new USBAdapter(usb, "Video data"));
        adapters.add(new VGAAdapter(vga, false));

        for (DisplayAdapter adapter : adapters) {
            adapter.display();
        }
    }
}
