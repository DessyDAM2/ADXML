package XML;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class PerrosHandler extends DefaultHandler {
    private ArrayList<Perro> listaPerros = new ArrayList<Perro>();
    private Perro p;
    private StringBuilder buffer = new StringBuilder();
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        switch(qName){
            case"CrearPerros":
                new Perro();
                break;
            case"nombre":
                buffer.delete(0,buffer.length());
                break;
            case"raza":
                buffer.delete(0,buffer.length());
                break;
            case"color":
                buffer.delete(0,buffer.length());
                break;
            case"sexo":
                buffer.delete(0,buffer.length());
                break;
            case"edad":
                buffer.delete(0,buffer.length());
                break;
            case"peso":
                buffer.delete(0,buffer.length());
                break;
        }


    }

    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        switch (qName){
            case"CrearPerros":
                break;
            case"nombre":
                
                break;
            case"raza":
                p.getRaza(buffer.toString());
                break;
            case"color":
                p.getPelaje(buffer.toString());
                break;
            case"sexo":
                p.getSexo(buffer.toString());
                break;
            case"edad":
                p.getEdad(Integer.parseInt(buffer.toString()));
                break;
            case"peso":
                p.getEdad(Integer.parseInt(buffer.toString()));
                break;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);
        buffer.append(ch,start,length);
    }
}
