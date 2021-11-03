package XML;


//Realizado por Alvaro Dessy

import org.xml.sax.SAXException;

import javax.xml.parsers.*;
import java.io.File;
import java.io.IOException;

public class CrearPerros {
    public static void main(String[] args)  {

        File archivo = new File("perros.xml");

            //Se crean varios obejtos
            Perro scooby = new Perro("Gran Danés", "Marron", "macho", 31, 17);
            Perro rex = new Perro("Pastor Alemán", "Marrón, naranja y negro", "macho", 27, 19);

        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            factory.setIgnoringComments(true);
            DocumentBuilder builder = factory.newDocumentBuilder();


        }catch (ParserConfigurationException e){

        }

    }
    //Realizado por Alvaro Dessy
}



