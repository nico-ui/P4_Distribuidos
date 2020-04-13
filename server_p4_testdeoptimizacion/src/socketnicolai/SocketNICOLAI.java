/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package socketnicolai;
import java.net.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;
import javax.swing.JOptionPane;
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
            int id = 0;
            server_frame sf = new server_frame();
            sf.setVisible(true);
            //sf.tiempo();
            for(;;){
                System.out.println("Esperando cliente...");
                Socket cl=s.accept();//aceptando conexiones
                System.out.println("\tConexion estbalecida desde "+cl.getInetAddress()+" : "+cl.getPort());
                BufferedReader br2=new BufferedReader(new InputStreamReader(cl.getInputStream()));
                String mensaje=br2.readLine();//leemos
                System.out.println("\tRecibimos el mensaje del cliente");
                System.out.println("\tMensaje: "+mensaje);//imprimimos
                    /**
                    Calendar calendario = Calendar.getInstance();//Obtener de la interfaz
                    int hora = (int) (Math.random()*24+0);
                    int minutos = (int) (Math.random()*60+0);
                    int segundos = (int) (Math.random()*60+0);
                    hora =calendario.get(Calendar.HOUR_OF_DAY);//1-24
                    minutos = calendario.get(Calendar.MINUTE);//1-60
                    segundos = calendario.get(Calendar.SECOND);//1-60
                    tiempo = hora + ":" + minutos + ":" + segundos;
                    */
                String tiempo = sf.clase();
                System.out.println("\tHora en que se recibio: " +tiempo);//hora del sistema
                    
                String tipo = "";
                if(mensaje.length() > 1){
                    tipo = "cadena";
                    System.out.println("\tEl mensaje es una: cadena");
                }else{
                    tipo = "caracter";
                    System.out.println("\tEl mensaje en un: caracter");
                }
                String ip = cl.getInetAddress().toString();
                DB.conexion con = new DB.conexion();
                con.Conectar(id, mensaje, tiempo, ip, tipo);
                br2.close();//cerramos buffer                
                cl.close();//matamos socket
                id++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
