/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iiiprogra;

import java.io.*;
import java.net.*;

/**
 *
 * @author josca
 */
public class Server_socket {
    public static void main(String[] args) throws Exception{
        ServerSocket server = new ServerSocket(8080);
        Socket cliente = server.accept();
        FileInputStream file = new FileInputStream("menu.xml");
        byte b[] = new byte[2048];
        file.read(b, 0, b.length);
        OutputStream output = cliente.getOutputStream();
        output.write(b, 0, b.length);
    }
}
