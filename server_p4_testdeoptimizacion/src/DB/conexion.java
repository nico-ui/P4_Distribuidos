package DB;
import java.sql.*;
import javax.swing.JOptionPane;

public class conexion {
    public String db = "mydb";
    public String url = "jdbc:mysql://localhost/"+db;
    public String user = "root";
    public String pass = "";
    
    public Connection Conectar(int id, String msj, String tiempo, String ip, String tipodato){
        String sql = "INSERT INTO tabla"
                        + "(idtabla, datoenviado, horarecibido, ip, tipodato)"
                        + "VALUES(?,?,?,?,?)";
        int n;
        Connection link = null;
        try{
            Class.forName("org.gjt.mm.mysql.Driver");
            link = DriverManager.getConnection(this.url, this.user, this.pass);
            PreparedStatement pst = link.prepareStatement(sql);
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
        }catch(ClassNotFoundException ex){
            JOptionPane.showMessageDialog(null, ex);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        return link;
    }
    
}
