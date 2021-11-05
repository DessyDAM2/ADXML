package XML;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
public class clientes {
    public static void main(String[] args) throws IOException, SAXException, ParserConfigurationException {

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setIgnoringElementContentWhitespace(true);
        factory.setIgnoringComments(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        File archivo = new File("clientes.xml");
        Document docXML = null;
        docXML = builder.parse(archivo);
        docXML.getDocumentElement().normalize();
        Node nodoRaiz = docXML.getFirstChild();

        System.out.println(nodoRaiz.getNodeName());

        nodoRaiz = Ej1.limpiarNodos(nodoRaiz);

        NodeList nodosHijos = nodoRaiz.getChildNodes();
        NamedNodeMap atrNietos = null;
        Node nodoHijo = null;
        NamedNodeMap atrHijo = null;
        Node nodoNieto = null;

        //Recorrer la lista de nodos
        for (int i = 0; i < nodosHijos.getLength(); i++) {
            //indicar el tipo de nodo
            nodoHijo = nodosHijos.item(i);
            nodoHijo = Ej1.limpiarNodos(nodoHijo);
            atrHijo = nodoHijo.getAttributes();
            if (nodosHijos.item(i).getNodeType() != 3)
                //Mostrar los nodos hijos
                System.out.println(nodosHijos.item(i).getNodeName());
            for (int k = 0; k < atrHijo.getLength(); k++) {
                System.out.println("\t"+atrHijo.item(k).getNodeName()+": "+ atrHijo.item(k).getTextContent() );
            }
            //Coge los nodos hijos de cada nodo hijo
            NodeList nodosNietos = nodosHijos.item(i).getChildNodes();

            for (int j = 0; j < nodosNietos.getLength(); j++) {
                System.out.println("\t"+nodosNietos.item(j).getNodeName() +": "+nodosNietos.item(j).getTextContent());
            }
        }
    }
}
