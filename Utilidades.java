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
import javax.xml.parsers.ParserConfigurationException;
import org.jespxml.JespXML;
import org.jespxml.excepciones.TagHijoNotFoundException;
import org.jespxml.modelo.Tag;
import org.xml.sax.SAXException;

/**
 *
 * @author yosua
 */
public class Utilidades {
    public ArrayList <String[]> crearMatriz(String ptipo){
        JespXML xml = new JespXML(new File("menu.xml"));
        ArrayList <String[]> matriz = new ArrayList<String[]>();                // definir la matriz con los platillos
        
        try {
            Tag raiz = xml.leerXML();
            System.out.println(raiz.getNombre());
            
            for (Tag platillo : raiz.getTagsHijos()){
                System.out.println(platillo);
              
                String  tipo,nombre, calorias, piezasPorPorcion,precio;
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
    
     
    
    public static void main(String[] args) throws Exception{
        Utilidades xml = new Utilidades();
        ArrayList<String[]> matriz = xml.crearMatriz("entradas");
        
        
        
    }
}


