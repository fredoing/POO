package iiiprogra;
import java.io.StringReader;
import java.io.StringWriter;
import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.xml.sax.InputSource;
/**
 *
 * @author josca
 */
public class Utilidades {
    
    private static String xml;
    private static Document doc;

    public static String xml2string(Document doc) {
        TransformerFactory tf = TransformerFactory.newInstance();
        Transformer transformer;
        try {
            transformer = tf.newTransformer();
            // below code to remove XML declaration
            // transformer.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
            StringWriter writer = new StringWriter();
            transformer.transform(new DOMSource(doc), new StreamResult(writer));
            String output = writer.getBuffer().toString();
            return output;
        } catch (TransformerException e) {
            e.printStackTrace();
        }
        
        return null;
    }

    public static Document string2xml(String xmlStr) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();  
        DocumentBuilder builder;  
        try  
        {  
            builder = factory.newDocumentBuilder();  
            Document doc = builder.parse( new InputSource( new StringReader( xmlStr ) ) ); 
            return doc;
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
        return null;
    }
    
    public static void generaArchivo(Document doc){
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        try{
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("menu.xml"));
        transformer.transform(source, result);
        }
        catch (Exception e) {
         e.printStackTrace();
      }
    }
    
    public static void main(String[] args) {
        xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
            "<menu>\n" +
            "   <platillo>\n" +
            "      <nombre> coca cola </nombre>\n" +
            "      <codigo> BEB001 </codigo>\n" +
            "      <tamPorcion>600 ml</tamPorcion>\n" +
            "      <piezasPorPorcion>1 </piezasPorPorcion>\n" +
            "      <caloriasPorPorcion> 520 kcal </caloriasPorPorcion>\n" +
            "      <caloriasPorPieza> 520 kcal </caloriasPorPieza>\n" +
            "      <precio> 3100 Colones </precio>\n" +
            "      <DetalleDescripcion> Bebida carbonatada que mata lentamente </DetalleDescripcion>\n" +
            "   </platillo>\n" +
            "   <platillo>\n" +
            "      <nombre> Ceviche </nombre>\n" +
            "      <codigo> ENT001 </codigo>\n" +
            "      <tamPorcion>400</tamPorcion>\n" +
            "      <piezasPorPorcion> 2 </piezasPorPorcion>\n" +
            "      <caloriasPorPorcion> 410 kcal </caloriasPorPorcion>\n" +
            "      <caloriasPorPieza> 205 kcal </caloriasPorPieza>\n" +
            "      <precio> 4000 Colones </precio>\n" +
            "      <DetalleDescripcion>Cevichito de la casa, preparado con mariscos frescos y nuestra salsa especial</DetalleDescripcion>\n" +
            "   </platillo>\n" +
            "</menu>";
        
        doc = string2xml(xml);
        xml = xml2string(doc);
		generaArchivo(doc);
        
        System.out.println(xml);
    }

}

