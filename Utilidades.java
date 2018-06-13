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
              
                String  tipo,nombre, calorias, piezasPorPorcion;
                try {
                    tipo = platillo.getTagHijoByName("tipo").getContenido();        // obtengo el tipo de platillo listo como un string
            
                    if (ptipo.equals(tipo)){
                        System.out.println("entro");
                        String listaInformacion[] = new String[3];              //crea la lista con la informacion del platillo(nombre,calorias,piezas por porcion)
                        nombre = platillo.getTagHijoByName("nombre").getContenido();
                        calorias = platillo.getTagHijoByName("caloriasPorPorcion").getContenido();
                        piezasPorPorcion = platillo.getTagHijoByName("piezasPorPorcion").getContenido();
                        listaInformacion[0] = nombre;
                        listaInformacion[1] = calorias;
                        listaInformacion[2] = piezasPorPorcion; 
                        System.out.println(tipo);
                        System.out.println(nombre);
                        System.out.println(calorias);
                        System.out.println(piezasPorPorcion);
                        
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
        ArrayList<String[]> matriz = xml.crearMatriz("postre");
        
        System.out.println(matriz.get(0)[0]); // 0 = nombre
        System.out.println(matriz.get(0)[1]); // 0 = calorias
        System.out.println(matriz.get(0)[2]); // 0 = calorias
        
        
    }
}


