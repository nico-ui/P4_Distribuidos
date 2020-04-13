/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketnicolaicliente;
import java.net.*;
import java.io.*;
/**
 *
 * @author Alumno
 */
public class SocketNICOLAIcliente {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try{
            BufferedReader br1=new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Escriba la direccion del servidor:");
            String host = br1.readLine();
            System.out.println("\nEscriba el puerto:");
            int pto=Integer.parseInt(br1.readLine());
            Socket cl = new Socket(host, pto);//creamos socket
            BufferedReader br2=new BufferedReader(new InputStreamReader(cl.getInputStream()));
            String mensaje=br2.readLine();//leemos
            System.out.println("Recibimos el mensaje del servidor");
            System.out.println("Mensaje:"+mensaje);
            br1.close();
            br2.close();
            cl.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }    
}
