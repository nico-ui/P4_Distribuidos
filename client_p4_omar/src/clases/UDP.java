/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package clases;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author omar_
 */
public class UDP {
    public void conexionudp(int puerto) throws IOException{
    
      byte[] buffer=new byte[1024];// asignamos un buffer con una carga de 1024 bits
        try {
             InetAddress direccion=InetAddress.getByName("localhost");//direccion del servidor
            DatagramSocket socket= new DatagramSocket();//se crea el socket  
             String mensaje="enviado";

            DatagramPacket respuesta= new DatagramPacket (buffer,buffer.length,direccion, puerto);//se manda informacion 
            socket.send(respuesta);//se envia al servidor
            DatagramPacket peticion= new DatagramPacket (buffer,buffer.length);//se manda informacion 
            socket.receive(peticion);
            mensaje=new String(peticion.getData());
           System.out.println(mensaje);
           socket.close();

        } catch (SocketException ex) {
            Logger.getLogger(UDP.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnknownHostException ex) {
            Logger.getLogger(UDP.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    
    }
}
