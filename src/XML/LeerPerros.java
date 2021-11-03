package XML;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class LeerPerros {
    public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
        File archivo = new File("perros.xml");
        SAXParserFactory saxPF = SAXParserFactory.newInstance();
        SAXParser saxParser = saxPF.newSAXParser();
        PerrosHandler pHandler = new PerrosHandler();
        saxParser.parse(archivo,pHandler);

        ArrayList<Perro> perros = new ArrayList<Perro>();
    }
}
