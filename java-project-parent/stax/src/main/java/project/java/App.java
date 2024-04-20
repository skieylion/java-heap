package project.java;

import lombok.SneakyThrows;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileInputStream;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamWriter;
import java.io.FileOutputStream;
import java.util.Set;

public class App {
    public static void main(String[] args) {
        writer();
    }

    @SneakyThrows
    static void reader() {
        XMLInputFactory factory = XMLInputFactory.newDefaultFactory();
        File file = new File(App.class.getClassLoader().getResource("books.xml").toURI());
        XMLStreamReader reader = factory.createXMLStreamReader(new FileInputStream(file));
        Set<String> elements = Set.of("title", "author", "price");
        while (reader.hasNext()) {
            int event = reader.next();
            if (event == XMLEvent.START_ELEMENT && elements.contains(reader.getLocalName())) {
                if (reader.next() == XMLEvent.CHARACTERS) {
                    System.out.print(reader.getText() + "   ");
                }
            } else if (event == XMLEvent.START_ELEMENT && "book".equals(reader.getLocalName())) {
                System.out.println();
            }
        }
    }

    @SneakyThrows
    static void writer() {
        XMLOutputFactory factory = XMLOutputFactory.newDefaultFactory();
        XMLStreamWriter writer = factory.createXMLStreamWriter(new FileOutputStream("output.xml"));
        writer.writeStartDocument("UTF-8", "1.0");
        writer.writeStartElement("books");
        writer.writeStartElement("book");
        writer.writeStartElement("title");
        writer.writeCharacters("Tom Soyer");
        writer.writeEndElement();
        writer.writeStartElement("author");
        writer.writeCharacters("Mark Twen");
        writer.writeEndElement();
        writer.writeStartElement("price");
        writer.writeCharacters("12.11");
        writer.writeEndElement();
        writer.writeEndElement();
        writer.writeEndDocument();
        writer.flush();
        writer.close();
    }

}
