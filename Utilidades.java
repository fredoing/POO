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

/**
 *
 * @author yosua
 */
public class Utilidades extends javax.swing.JFrame{
    public ArrayList <String[]> crearMatrizUnitipo(String ptipo){
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
     
    
    public static void main(String[] args) throws Exception{
        Utilidades xml = new Utilidades();
        ArrayList<String[]> matriz = xml.crearMatrizUnitipo("entradas");
        
        
        
    }
}


