/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiiprogra;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author josca
 */
public class Client_socket {
    
    public void descargarArchivo() throws Exception{
        Socket cliente = new Socket("127.0.0.1", 8080);
        InputStream input = cliente.getInputStream();
        FileOutputStream output = new FileOutputStream("menu-cliente.xml");
        int fileSize = 2048;
        byte b[] = new byte[fileSize];
        input.read(b, 0 ,b.length);
        byte ar[]=new String(b).replaceAll("\0", "").getBytes();
        output.write(ar, 0 ,ar.length);
    }
    
    public static void main(String[] args){       
        Client_socket cliente = new Client_socket();
        try{
            cliente.descargarArchivo();
        }
        catch(Exception e){
            System.out.println("No se pudo descargar el archivo");
        }
        
        
    }
    
    
}
