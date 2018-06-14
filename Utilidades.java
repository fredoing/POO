/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.stream.*;
import javax.xml.transform.dom.*;
import org.w3c.dom.*;
import javax.xml.parsers.*;
/**
 *
 * @author yosua
 */
public class Utilidades extends javax.swing.JFrame{
    
    public ArrayList <String[]> crearMatrizUnitipo (String tag, String contenido){//tag viene siendo "Tipo", "nombre","Precio"
        ArrayList <String[]> matriz= new ArrayList <>();                   //Contenido viene siendo "bebida" "Coca Cola" "1500"
        try{
            JespXML ArchivoXML= new JespXML(new File("menu.xml"));
            Tag raiz = ArchivoXML.leerXML();
            System.out.println(raiz.getNombre());
            for(Tag platillo: raiz.getTagsHijos()){//Ciclo para acceder a todos los tag "platillos"
                System.out.println(platillo);
                String nombre, tipo, codigo, tamPorcion, piezasPorPorcion,caloriasPorcion, caloriasPorPieza, precio, disponible;//Bebida/Coca cola/       
                try{
                    tipo = platillo.getTagHijoByName(tag).getContenido();                  
                    String infoList[];
                    if(contenido.equals(tipo) && tag.equals("nombre")){
                        infoList= new String[8];
                        nombre = platillo.getTagHijoByName("nombre").getContenido();                
                        codigo=platillo.getTagHijoByName("codigo").getContenido();
                        tamPorcion=platillo.getTagHijoByName("tamPorcion").getContenido();
                        piezasPorPorcion = platillo.getTagHijoByName("piezasPorPorcion").getContenido();
                        caloriasPorcion = platillo.getTagHijoByName("caloriasPorPorcion").getContenido();
                        caloriasPorPieza= platillo.getTagHijoByName("caloriasPorPieza").getContenido();
                        precio = platillo.getTagHijoByName("precio").getContenido(); 
                        disponible=platillo.getTagHijoByName("disponible").getContenido();
                        infoList[0]=(nombre);
                        infoList[1]=(codigo);
                        infoList[2]=(tamPorcion);
                        infoList[3]=(piezasPorPorcion);
                        infoList[4]=(caloriasPorcion);
                        infoList[5]=(caloriasPorPieza);
                        infoList[6]=(precio);  
                        infoList[7]=(disponible);
                        matriz.add(infoList);
                    }
                    else if(contenido.equals(tipo)&& tag.equals("tipo")){
                        infoList= new String[4];
                        nombre = platillo.getTagHijoByName("nombre").getContenido();
                        caloriasPorcion = platillo.getTagHijoByName("caloriasPorPorcion").getContenido();
                        piezasPorPorcion = platillo.getTagHijoByName("piezasPorPorcion").getContenido();
                        precio = platillo.getTagHijoByName("precio").getContenido();
                        infoList[0]=(nombre);
                        infoList[1]=(caloriasPorcion);
                        infoList[2]=(piezasPorPorcion);
                        infoList[3]=(precio);
                        matriz.add(infoList);
                    }
                }catch (TagHijoNotFoundException ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return matriz;        
    }
    
    public void llenarTabla(ArrayList <String[]> matriz, javax.swing.JTable table, int cantColumnas ){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(cantColumnas);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<cantColumnas;j++){
                table.setValueAt(matriz.get(i)[j], i, j);//.get(j)get(i)[j]
            }
       }
    }                        //"DetalleDescripcion", "coca cola"
    public String extraerDato(String tag, String dish){
        try{
            JespXML ArchivoXML= new JespXML(new File("menu.xml"));
            Tag raiz = ArchivoXML.leerXML();
            for(Tag platillo: raiz.getTagsHijos()){//Ciclo para acceder a todos los tag "platillos"      
                String nombrePlato,contenido;
                try{
                    nombrePlato= platillo.getTagHijoByName("nombre").getContenido();//Coca cola//1500/Bebidas
                    if(nombrePlato.equals(dish)){
                    contenido = platillo.getTagHijoByName(tag).getContenido();
                    return contenido;
                    }
                }catch (TagHijoNotFoundException ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }                                       
            }
        }catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "Contenido no disponible";
    }
     
    public void agregaPedido(String nombre, String cel, String dir, ArrayList<String> platillos, ArrayList<String> cantidad, String tipo){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse("pedidos.xml");
            
            Element root = doc.getDocumentElement();
            Element ped = doc.createElement("ped");
            root.appendChild(ped);
            
            Element tip = doc.createElement("tipo");
            tip.setTextContent(tipo);
            Element nom = doc.createElement("nombre");
            nom.setTextContent(nombre);
            Element tel = doc.createElement("tel");
            tel.setTextContent(cel);
            Element dire = doc.createElement("dir");
            dire.setTextContent(dir);
            
            ped.appendChild(tip);
            ped.appendChild(nom);
            ped.appendChild(tel);
            ped.appendChild(dire);
            
            for(int i=0; i<cantidad.size(); i++){
                Element plat = doc.createElement("paltillo");
                plat.setTextContent(platillos.get(i));
                ped.appendChild(plat);
                
                Element cant = doc.createElement("cantidad");
                cant.setTextContent(cantidad.get(i));
                plat.appendChild(cant);
            }           
            
            DOMSource source = new DOMSource(doc);

            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StreamResult result = new StreamResult("pedidos.xml");
            tf.transform(source, result);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerConfigurationException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        } catch (TransformerException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void main(String[] args) throws Exception{
        Utilidades xml = new Utilidades();
        ArrayList<String[]> matriz = xml.crearMatrizUnitipo("tipo","entradas");   
    }
}


