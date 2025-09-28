package command_pattern.yc;

import bridge_pattern.yc.Remote;

public class Client {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();

        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(lightOn);
        remote.pressButton();

        remote.setCommand(lightOff);
        remote.pressButton();
    }
}
