package project.java;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Remote remote1=new BasicRemote(new TV());
        remote1.turnOn();
        remote1.channelNext();
        remote1.turnOff();

        Remote remote2=new BasicRemote(new Radio());
        remote2.turnOn();
        remote2.channelNext();
        remote2.turnOff();
    }
}

interface DeviceManager {
    void setState(boolean state);

    boolean getState();

    void setVolume(int volume);

    int getVolume();

    void setChannel(int channel);

    int getChannel();
}

abstract class Device {
    boolean state;
    int volume;
    int channel;
}

class TV extends Device implements DeviceManager {

    @Override
    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    @Override
    public void setVolume(int volume) {
        this.volume = volume;
        if (this.volume > 100) {
            this.volume = 100;
        } else if (this.volume < 0) {
            this.volume = 0;
        }
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setChannel(int channel) {
        if (channel > 0 && channel < 30) {
            this.channel = channel;
        }
    }

    @Override
    public int getChannel() {
        return this.channel;
    }
}

class Radio extends Device implements DeviceManager {

    @Override
    public void setState(boolean state) {
        this.state = state;
    }

    @Override
    public boolean getState() {
        return this.state;
    }

    @Override
    public void setVolume(int volume) {
        if (this.volume > 100) {
            this.volume = 100;
        } else if (this.volume < 0) {
            this.volume = 0;
        }
    }

    @Override
    public int getVolume() {
        return this.volume;
    }

    @Override
    public void setChannel(int channel) {
        this.channel = channel;
    }

    @Override
    public int getChannel() {
        return this.channel;
    }
}

interface Remote {
    void turnOn();

    void turnOff();

    void volumeUp();

    void volumeDown();

    void channelNext();

    void channelBack();
}

class BasicRemote implements Remote {
    private final DeviceManager deviceManager;

    public BasicRemote(DeviceManager deviceManager) {
        System.out.println(deviceManager);
        this.deviceManager = deviceManager;
    }

    @Override
    public void turnOn() {
        System.out.println("turn on");
        deviceManager.setState(true);
    }

    @Override
    public void turnOff() {
        System.out.println("turn off");
        deviceManager.setState(false);
    }

    @Override
    public void volumeUp() {
        System.out.println("volume up");
        deviceManager.setVolume(deviceManager.getVolume() + 10);
    }

    @Override
    public void volumeDown() {
        System.out.println("volume down");
        deviceManager.setVolume(deviceManager.getVolume() - 10);
    }

    @Override
    public void channelNext() {
        System.out.println("channel next");
        deviceManager.setChannel(deviceManager.getChannel() + 1);
    }

    @Override
    public void channelBack() {
        System.out.println("channel back");
        deviceManager.setChannel(deviceManager.getChannel() - 1);
    }
}

