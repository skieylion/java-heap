package project.java;

import project.java.xsd.TripRec;
import project.java.xsd.TripStr;

import javax.xml.bind.JAXB;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public class App {

    private static List<String> getMarkerList(String messageCode) {
        return null;
    }

    public static void main(String[] args) {
        for (String marker : getMarkerList("")) {
            System.out.println("marker");
        }


//        TripRec tripRec = new TripRec();
//        tripRec.getStr().add(new TripStr());
//        List tripList = new List();
//        tripList.getRec().add(tripRec);
//        StringWriter sw = new StringWriter();
//        JAXB.marshal(tripList, sw);
//        System.out.println(sw.toString());
    }
}
