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
    public ArrayList <String[]> crearMatrizUnitipo(String ptipo){
        System.out.println("entro");
        JespXML xml = new JespXML(new File("menu.xml"));// Parámetro por recibir//
        ArrayList <String[]> matriz = new ArrayList<String[]>();                // definir la matriz con los platillos
        try {
            Tag raiz = xml.leerXML();
            System.out.println(raiz.getNombre());
            
            for (Tag platillo : raiz.getTagsHijos()){
                System.out.println(platillo);
              
                String  tipo,nombre, calorias, piezasPorPorcion,precio;//enviar como parámetros?
                try {
                    tipo = platillo.getTagHijoByName("tipo").getContenido();        // obtengo el tipo de platillo listo como un string
            
                    if (ptipo.equals(tipo)){
                        String listaInformacion[] = new String[4];              //crea la lista con la informacion del platillo(nombre,calorias,piezas por porcion)
                        nombre = platillo.getTagHijoByName("nombre").getContenido();
                        calorias = platillo.getTagHijoByName("caloriasPorPorcion").getContenido();
                        piezasPorPorcion = platillo.getTagHijoByName("piezasPorPorcion").getContenido();
                        precio = platillo.getTagHijoByName("precio").getContenido();
                        listaInformacion[0] = nombre;
                        listaInformacion[1] = calorias;
                        listaInformacion[2] = piezasPorPorcion;
                        listaInformacion[3] = precio;
                        matriz.add(listaInformacion);
                    }
                    
                    
                    
                    
                } catch (TagHijoNotFoundException ex) {
                    Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
    return matriz;
    }
    public void llenarTabla(ArrayList<String[]> matriz, javax.swing.JTable table, int cantColumnas ){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(cantColumnas);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<cantColumnas;j++){
                table.setValueAt(matriz.get(i)[j], i, j);
            }
       }
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
        ArrayList<String[]> matriz = xml.crearMatrizUnitipo("entradas");
        
        
        
    }
}


