package project.java.facade.facade2;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        GPSPower power = new GPSPower();
        GPSNotifier notifier = new GPSNotifier();
        RoadAdvisor advisor = new RoadAdvisor();

        FacadeGPS facadeGPS=new FacadeGPS(power,notifier,advisor);
        facadeGPS.activate();
        //Водитель выключает навигационную систему
        power.powerOff();
    }
}

class GPSPower {

    public void powerOn() {
        System.out.println("Power ON");
    }

    public void powerOff() {
        System.out.println("Power OFF");
    }
}

class GPSNotifier {

    public void downloadRoadInfo() {
        System.out.println("Downloading road information...");
        System.out.println("Download complete!");
    }
}

class RoadAdvisor {
    public void route() {
        System.out.println("Create a route");
    }
}

class FacadeGPS {
    private GPSPower gpsPower;
    private GPSNotifier gpsNotifier;
    private RoadAdvisor roadAdvisor;

    public FacadeGPS(GPSPower gpsPower, GPSNotifier gpsNotifier, RoadAdvisor roadAdvisor) {
        this.gpsPower = gpsPower;
        this.gpsNotifier = gpsNotifier;
        this.roadAdvisor = roadAdvisor;
    }

    public void activate(){
        gpsPower.powerOn();
        gpsNotifier.downloadRoadInfo();
        roadAdvisor.route();
    }
}