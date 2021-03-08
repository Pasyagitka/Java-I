package parse;

import by.zinovich.three.tv.programs.TVProgram;

import javax.xml.XMLConstants;
import javax.xml.namespace.QName;
import javax.xml.parsers.SAXParser;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import javax.xml.transform.stax.StAXSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class XMLStAXParser {
    public static void main(String[] args) throws Exception {
        String xmlFileName = "H:/4 семестр/Java I/03/files/info.xml";
        String xsdFileName = "H:/4 семестр/Java I/03/files/info.xsd";
        List<TVProgram> programList = parseXMLfile(xmlFileName);

        try {
            XMLStreamReader reader = XMLInputFactory.newInstance().createXMLStreamReader(new FileInputStream(xmlFileName));
            SchemaFactory factory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
            Schema schema = factory.newSchema(new File(xsdFileName));
            Validator validator = schema.newValidator();
            validator.validate(new StAXSource(reader));

            //no exception thrown, so valid
            System.out.println("Document is valid");

            // печатаем в консоль информацию по каждой программе
            for (TVProgram program : programList) {
                System.out.println(
                        program.toString());
            }
        }
        catch (Exception e) {
            System.out.println("Document is not valid!\n" + e.getMessage());
        }

    }

    private static List<TVProgram> parseXMLfile(String fileName) {
        List<TVProgram> programList = new ArrayList<>();
        TVProgram program = null;
        XMLInputFactory xmlInputFactory = XMLInputFactory.newInstance();
        try {
            // инициализируем reader и скармливаем ему xml файл
            XMLEventReader reader = xmlInputFactory.createXMLEventReader(new FileInputStream(fileName));
            // проходим по всем элементам xml файла
            while (reader.hasNext()) {
                // получаем событие (элемент) и разбираем его по атрибутам
                XMLEvent xmlEvent = reader.nextEvent();
                if (xmlEvent.isStartElement()) {
                    StartElement startElement = xmlEvent.asStartElement();
                    switch (startElement.getName().getLocalPart()) {
                        case "TVProgram" -> {
                            program = new TVProgram();
                            Attribute idAttr = startElement.getAttributeByName(new QName("ProgramType"));
                            if (idAttr != null) {
                                program.setProgramType(idAttr.getValue());
                            }
                        }
                        case "LengthIMinutes" -> {
                            xmlEvent = reader.nextEvent();
                            program.setLengthIMinutes(Integer.parseInt(xmlEvent.asCharacters().getData()));
                        }
                        case "Name" -> {
                            xmlEvent = reader.nextEvent();
                            program.setName(xmlEvent.asCharacters().getData());
                        }
                    }
                }
                // если цикл дошел до закрывающего элемента,
                // то добавляем считанного из файла в список
                if (xmlEvent.isEndElement()) {
                    EndElement endElement = xmlEvent.asEndElement();
                    if (endElement.getName().getLocalPart().equals("TVProgram")) {
                        programList.add(program);
                    }
                }
            }

        } catch (FileNotFoundException | XMLStreamException exc) {
            System.out.println("Parse error..." + exc.getMessage());
        }
        return programList;
    }
}
