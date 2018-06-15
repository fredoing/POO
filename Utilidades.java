/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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
    
    
    /**Método encargado de generar una matriz, ya sea con toda la información del platillo si la variable flg es true o con solo 4 elemenentos predefinido si es false
     * @param tag:String del xml ej:tipo
     * @param contenido:String que es la información que se encuentra dentro de la etiqueta seleccionada.
     * @param flag:boolean para escoger cuales valores son los que se van a obtener.
     * @return retorna una matriz con los elementos seleccionados
     */
    public ArrayList <String[]> crearMatrizUnitipo (String tag, String contenido, boolean flag ){//tag viene siendo "Tipo", "nombre","Precio"
        ArrayList <String[]> matriz= new ArrayList <>();                   //Contenido viene siendo "bebida" "Coca Cola" "1500"
        
        try{
            JespXML ArchivoXML= new JespXML(new File("menu.xml"));
            Tag raiz = ArchivoXML.leerXML();
            System.out.println(raiz.getNombre());
            for(Tag platillo: raiz.getTagsHijos()){//Ciclo para acceder a todos los tag "platillos"
               // System.out.println(platillo);
                String nombre, tipo, codigo, tamPorcion, piezasPorPorcion,caloriasPorcion, caloriasPorPieza, precio, disponible;//Bebida/Coca cola/       
                try{
                    tipo = platillo.getTagHijoByName("tipo").getContenido();                  
                    String infoList[];
                    if(contenido.equals(tipo) && tag.equals("tipo")&& flag==true){// buscar if que solucione este dilema, ambas tiene 
                        infoList= new String[8];                    //el mismo cÃ³digo, identficar diferencia entre Yosua y mia
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
                    else if(contenido.equals(tipo)&& tag.equals("tipo") && flag==false){
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
    
    /**Método encargado de llenar tablas a partir de una matriz
     * @param matriz necesaria para cargar los datos en la tabla
     * @param table que es parte de la biblioteca Swing; esta es la tabla específica en donde queremos cargar los datos.
     * @param cantColumnas: esto nos dice cuantas columnas vamos a llenar, por cuestiones del tamaño del ArrayList
     */
    public void llenarTabla(ArrayList <String[]> matriz, javax.swing.JTable table, int cantColumnas ){
        DefaultTableModel model = (DefaultTableModel) table.getModel();
        model.setRowCount(matriz.size());
        model.setColumnCount(cantColumnas);
        for(int i=0; i<matriz.size();i++){
            for(int j=0; j<cantColumnas;j++){
                if("true".equals(matriz.get(i)[j])){
                    table.setValueAt(true, i, j);
                }else{
                    table.setValueAt(matriz.get(i)[j], i, j);//.get(j)get(i)[j]
                }                
            }
       }
    }
    
    /**Método encargado de extraer un dato específico de un platillo determinado
     * @param tag La etiqueta de cada uno de los hijos platillo en el xml
     * @param dish El nombre del platillo del cual queremos buscar un dato.
     * @return Un String del dato específico que se pidió del tag.
     */
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
     
    /**FREDO
     *
     * @param nombre
     * @param cel
     * @param dir
     * @param platillos
     * @param cantidad
     * @param precio
     * @param tipo
     * @param fecha
     */
    public void agregaPedido(String nombre, String cel, String dir, ArrayList<String> platillos, ArrayList<String> cantidad, ArrayList<String> precio, String tipo, String fecha){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            Document doc = docBuilder.parse("pedidos.xml");
            
            Element root = doc.getDocumentElement();
            Element ped = doc.createElement("ped");
            root.appendChild(ped);
            
            Element date = doc.createElement("fecha");
            date.setTextContent(fecha);
            Element ordennum = doc.createElement("ordenGlobal");
            ordennum.setTextContent(Integer.toString(calcularGlobal()));
            Element tip = doc.createElement("tipo");
            tip.setTextContent(tipo);
            Element nom = doc.createElement("nombre");
            nom.setTextContent(nombre);
            Element tel = doc.createElement("tel");
            tel.setTextContent(cel);
            Element dire = doc.createElement("dir");
            dire.setTextContent(dir);
            
            ped.appendChild(date);
            ped.appendChild(ordennum);
            ped.appendChild(tip);
            ped.appendChild(nom);
            ped.appendChild(tel);
            ped.appendChild(dire);
            
            for(int i=0; i<cantidad.size(); i++){
                Element plat = doc.createElement("platillo");
                ped.appendChild(plat);
                
                Element nomplat = doc.createElement("nombrePlatillo");
                nomplat.setTextContent(platillos.get(i));
                plat.appendChild(nomplat);
                
                Element cant = doc.createElement("cantidad");
                cant.setTextContent(cantidad.get(i));
                plat.appendChild(cant);
            }           
            
            Element total = doc.createElement("total");
            total.setTextContent(calcularPrecio(precio,tipo));
            ped.appendChild(total);
            
            DOMSource source = new DOMSource(doc);

            Transformer tf = TransformerFactory.newInstance().newTransformer();
            tf.setOutputProperty(OutputKeys.INDENT, "yes");
            tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            StreamResult result = new StreamResult("pedidos.xml");
            tf.transform(source, result);
            
        } catch (ParserConfigurationException | SAXException | IOException | TransformerException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    /**
     *
     * @param precio
     * @param tipo
     * @return
     */
    public String calcularPrecio(ArrayList<String> precio , String tipo){
        String result = "";
        int total = 0;
        for(int i=0; i<precio.size(); i++){
            int costo = Integer.parseInt(precio.get(i));
            total += costo;
        }
        int costoAdicional = Integer.parseInt(consultarPrecio(tipo));
        total += costoAdicional;
        result = Integer.toString(total);
        return result;
    }
    
    /**
     *
     * @param tipo
     * @return
     */
    public String consultarPrecio(String tipo){
        String result = "";
        try {
            JespXML ArchivoXML= new JespXML(new File("pedidos.xml"));
            Tag raiz = ArchivoXML.leerXML();
            if(tipo=="Llevar"){
                result = raiz.getTagHijoByName("precioPorRecoger").getContenido();
            }
            else if(tipo=="Express"){
                result = raiz.getTagHijoByName("precioPorExpress").getContenido();
            }
            else{
                result = "0";
            }
        } catch (ParserConfigurationException | SAXException | IOException | TagHijoNotFoundException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return result;
    }
    
    /**
     *
     * @return
     */
    public int calcularGlobal(){
        NodeList nodes = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            
            // Defines a factory API that enables applications to obtain a parser that produces DOM object trees from XML documents.
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            
            // The Document interface represents the entire HTML or XML document. Conceptually, it is the root of the document tree, and provides the primary access to the document's data.
            Document doc = factory.newDocumentBuilder().parse("pedidos.xml");
            
            // Returns a NodeList of all the Elements in document order with a given tag name and are contained in the document.
            nodes = doc.getElementsByTagName("ped");
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nodes.getLength();
    }
    
    /**
     *
     * @param platillos
     * @param cantidad
     */
    public void vecesP(ArrayList<String> platillos, ArrayList<String> cantidad){
        for(int i=0; i<platillos.size(); i++){
            vecesPAux(platillos.get(i), cantidad.get(i));
        }
    }
    
    public void vecesPAux(String platillo, String cantidad){
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = factory.newDocumentBuilder();
            try {
                Document doc = docBuilder.parse("menu.xml");
                Node menu = doc.getFirstChild();
                
                NodeList listPlat = menu.getChildNodes();
                
                for(int i=0; i<listPlat.getLength(); i++){
                    Node nodoPlatillo = listPlat.item(i);
                    NodeList listaElementos = nodoPlatillo.getChildNodes();
                    for(int e=0; e<listaElementos.getLength(); e++){
                        Node nodoEle = listaElementos.item(e);
                        if("nombre".equals(nodoEle.getNodeName())){
                            if(!nodoEle.getTextContent().equals(platillo)){
                                break;
                            }
                        }
                        else if("vecesp".equals(nodoEle.getNodeName())){
                            int cantAnterior = Integer.parseInt(extraerDato("vecesp", platillo));
                            int cantAsumar = Integer.parseInt(cantidad);
                            int nuevo = cantAsumar+cantAnterior;
                            nodoEle.setTextContent(Integer.toString(nuevo));
                        }
                    }
                }
                
                DOMSource source = new DOMSource(doc);

                Transformer tf = TransformerFactory.newInstance().newTransformer();
                tf.setOutputProperty(OutputKeys.INDENT, "yes");
                tf.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
                StreamResult result = new StreamResult("menu.xml");
                tf.transform(source, result);
                
            } catch (SAXException | IOException | TransformerException ex) {
                Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(Utilidades.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    /** Encargado de inicializar la clase.
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception{
        Utilidades xml = new Utilidades();
        ArrayList<String[]> matriz = xml.crearMatrizUnitipo("tipo","entradas",false);
        Utilidades xml2 = new Utilidades();
        ArrayList<String[]> matriz2 = xml.crearMatrizUnitipo("tipo","entradas",true);
    }
}


