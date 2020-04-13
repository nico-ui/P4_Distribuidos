/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketnicolai;
import java.net.*;
import java.io.*;
/**
 *
 * @author Alumno
 */
public class SocketNICOLAI {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try{
            //BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
            ServerSocket s = new ServerSocket(1234);//creacion de un socket puerto 1234
            for(;;){
                System.out.println("Esperando cliente...");
                Socket cl=s.accept();//aceptando conexiones
                System.out.println("Conexion estbalecida desde "+cl.getInetAddress()+" : "+cl.getPort());
                BufferedReader br2=new BufferedReader(new InputStreamReader(cl.getInputStream()));
                String mensaje=br2.readLine();//leemos
                System.out.println("Recibimos el mensaje del cliente");
                System.out.println("Mensaje: "+mensaje);//imprimimos
                br2.close();//cerramos buffer                
                cl.close();//matamos socket
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
