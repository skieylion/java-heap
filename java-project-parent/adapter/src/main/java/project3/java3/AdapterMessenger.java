package project3.java3;

public class AdapterMessenger implements Messenger {

    private final MessengerXml messengerXml;

    public AdapterMessenger() {
        this.messengerXml = new MessengerXml();
    }

    private String jsonToXml(String jsonData) {
        return "<a>1</a>";
    }

    @Override
    public void send(String jsonData) {
        String xmlData=jsonToXml(jsonData);
        messengerXml.sendXMLData(xmlData);
        //sendXMLData(xmlData);
    }
}
