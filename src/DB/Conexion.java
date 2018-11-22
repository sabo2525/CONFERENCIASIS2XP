
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class Conexion {
    private Connection conexion;
    public Conexion(){
        conexion=null;
        try {
            //conexion=DriverManager.getConnection("jdbc:mysql://localhost/conferencia?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC","root","");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/conferencia","root","");
            
        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
            conexion=null;
        }
        
    }
    public boolean isConectado(){
 boolean valid = false;
        try {
            valid = conexion.isValid(50000);
           System.out.println(valid ? "TEST OK" : "TEST FAIL");  

        } catch (SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
        }
            return valid;    }
    public Connection getConexion(){
        return conexion;
    }
}