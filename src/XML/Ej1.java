package XML;


import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Text;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class Ej1 {
    public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

        factory.setIgnoringElementContentWhitespace(true);
        factory.setIgnoringComments(true);

        DocumentBuilder builder = factory.newDocumentBuilder();

        File archivo = new File("alumnos.xml");
        Document docXML = null;
        docXML = builder.parse(archivo);
        docXML.getDocumentElement().normalize();
        Node nodoRaiz = docXML.getFirstChild();//Coge el nodo raiz

        System.out.println(nodoRaiz.getNodeName());//Muestra el nodo raiz

        nodoRaiz = limpiarNodos(nodoRaiz);

        NodeList nodosHijos = nodoRaiz.getChildNodes();//Coge los nodos hijos del nodo raiz


        Node nodoHijo = null;
        //Recorrer la lista de nodos
        for (int i = 0; i < nodosHijos.getLength(); i++) {
            //indicar el tipo de nodo
            nodoHijo = nodosHijos.item(i);
            nodoHijo = limpiarNodos(nodoHijo);
            if (nodosHijos.item(i).getNodeType() != 3)
                //Mostrar los nodos hijos
            System.out.println(nodosHijos.item(i).getNodeName());

            //Coge los nodos hijos de cada nodo hijo
            NodeList nodosNietos = nodosHijos.item(i).getChildNodes();
            for (int j = 0; j < nodosNietos.getLength(); j++) {
                System.out.println("\t"+nodosNietos.item(j).getNodeName() +": "+nodosNietos.item(j).getTextContent());
            }
        }
    }
        public static Node limpiarNodos(Node nodoAux){

        if (nodoAux.hasChildNodes()){
            NodeList nodosHijos = nodoAux.getChildNodes();
            Node aux = null;
            for (int i = 0; i < nodosHijos.getLength(); i++) {
                aux = nodosHijos.item(i);
                if(aux.getNodeType()==3)
                    aux.setTextContent(aux.getTextContent().trim());
                if(aux.getTextContent().equals(""))
                    aux.getParentNode().removeChild(aux);
            }
        }return nodoAux;
    }
}
