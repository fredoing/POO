/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cliente;

import java.io.*;
import java.net.*;

/**
 *
 * @author josca
 */
public class Server_socket {

    
    private ServerSocket server = null;
    private Socket cliente = null;
    
    public Server_socket(int puerto){
        try{
            server = new ServerSocket(puerto);
            cliente = server.accept(); 
            FileInputStream file = new FileInputStream("menu.xml");
            byte b[] = new byte[2048];
            file.read(b, 0, b.length);
            OutputStream output = cliente.getOutputStream();
            output.write(b, 0, b.length);  
            file.close();
        }
        catch(IOException e){
            System.out.println(e);
        }
        
    }
    
    public void recibirArchivo() throws Exception{
        DataInputStream input = new DataInputStream(new BufferedInputStream(cliente.getInputStream()));
        FileOutputStream output1 = new FileOutputStream("menu.xml");
        int length = input.readInt(); 
        byte[] message = new byte[length];// read length of incoming message
        if(length>0) {
            input.readFully(message, 0, message.length); // read the message
        }
        byte ar[]=new String(message).replaceAll("\0", "").getBytes();
        output1.write(ar, 0 ,ar.length);
        output1.close();
    }
    
    public static void main(String[] args) throws Exception{
        Server_socket server = new Server_socket(8080);
        server.recibirArchivo();
    }
}
