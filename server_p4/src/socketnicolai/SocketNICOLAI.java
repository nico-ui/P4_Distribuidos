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
            for(;;){
                System.out.println("Esperando cliente...");
                Socket cl=s.accept();//aceptando conexiones
                System.out.println("\tConexion estbalecida desde "+cl.getInetAddress()+" : "+cl.getPort());
                BufferedReader br2=new BufferedReader(new InputStreamReader(cl.getInputStream()));
                String mensaje=br2.readLine();//leemos
                System.out.println("\tRecibimos el mensaje del cliente");
                System.out.println("\tMensaje: "+mensaje);//imprimimos
                    Calendar calendario = Calendar.getInstance();
                    int hora, minutos, segundos;
                    hora =calendario.get(Calendar.HOUR_OF_DAY);
                    minutos = calendario.get(Calendar.MINUTE);
                    segundos = calendario.get(Calendar.SECOND);
                    String tiempo="";
                    tiempo=hora + ":" + minutos + ":" + segundos;
                    System.out.println("\tHora en que se recibio: " +tiempo);
                String tipo = "";
                if(mensaje.length() > 1){
                    tipo = "cadena";
                    System.out.println("\tEl mensaje es una: cadena");
                }else{
                    tipo = "caracter";
                    System.out.println("\tEl mensaje en un: caracter");
                }
                    
                String driver = "org.gjt.mm.mysql.Driver";
                String sql = "INSERT INTO tabla"
                        + "(idtabla, datoenviado, horarecibido, ip, tipodato)"
                        + "VALUES(?,?,?,?,?)";
                String msj, ip, tipodato;
                int n;
                msj = mensaje;
                //tiempo = "";//hora, minutos, segundos
                ip = cl.getInetAddress().toString();
                tipodato = tipo;

                Connection c = null;
                try{
                    Class.forName(driver);
                    c = DriverManager.getConnection("jdbc:mysql://localhost/mydb", "root", "");
                    PreparedStatement pst = c.prepareStatement(sql);
                    pst.setInt(1, id);
                    pst.setString(2, msj);
                    pst.setString(3, tiempo);
                    pst.setString(4, ip);
                    pst.setString(5, tipodato);
                    n = pst.executeUpdate();

                    if(n > 0){
                        System.out.println("\"Datos Guardados Correctamente\"");
                        //JOptionPane.showMessageDialog(null, "Datos Guardados Correctamente");
                       //deshabilitar();
                    }else
                        System.out.println("\"Falló al guardar los datos\"");
                        //JOptionPane.showMessageDialog(null, "Falló al guardar los datos");
                }catch (ClassNotFoundException ex){
                    System.out.println(ex);
                    //JOptionPane.showMessageDialog(null, ex);
                }catch(SQLException ex){
                    System.out.println(ex);
                    //JOptionPane.showMessageDialog(null, ex);
                }
                br2.close();//cerramos buffer                
                cl.close();//matamos socket
                id++;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
