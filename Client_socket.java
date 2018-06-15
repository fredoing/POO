/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.*;
import java.net.*;
import java.util.*;

/**
 *
 * @author josca
 */
public class Client_socket {
    
    private Socket cliente = null;
    private DataInputStream input = null;
    private DataOutputStream output = null;
    
    public Client_socket(String direccion, int puerto){
        try{
            cliente = new Socket(direccion, puerto);
            System.out.println("conectado");
            input = new DataInputStream(cliente.getInputStream());
            output = new DataOutputStream(cliente.getOutputStream());            
        }
        catch(UnknownHostException e){
            System.out.println(e);
        }
        catch(IOException i){
            System.out.println(i);
        }
    }
    
    public void descargarArchivo() throws Exception{
        InputStream in = cliente.getInputStream();
        FileOutputStream out = new FileOutputStream("menu-cliente.xml");
        int fileSize = 2048;
        byte b[] = new byte[fileSize];
        in.read(b, 0 ,b.length);
        byte ar[]=new String(b).replaceAll("\0", "").getBytes();
        out.write(ar, 0 ,ar.length);
        cliente.close();
    }
    public void enviarArchivo() throws Exception{
        FileInputStream file = new FileInputStream("menu-cliente.xml");
        byte b[] = new byte[2048];
        file.read(b, 0, b.length);
        //DataOutputStream output = new DataOutputStream(cliente.getOutputStream());
        output.writeInt(b.length);
        output.write(b, 0, b.length);
        cliente.close();
    }
    
    public static void main(String[] args){       
        Client_socket cliente = new Client_socket("127.0.0.1",8080);
        try{
            //cliente.descargarArchivo();
            cliente.enviarArchivo();
        }
        catch(Exception e){
            System.out.println("No se pudo descargar el archivo");
        }
        
        
    }
    
    
}
