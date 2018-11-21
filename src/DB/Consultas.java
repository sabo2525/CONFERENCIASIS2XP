/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import static com.sun.jmx.remote.internal.IIOPHelper.connect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import static javax.management.remote.JMXConnectorFactory.connect;
import javax.swing.JOptionPane;

/**
 *
 * @author pc
 */
public class Consultas {
  Connection conect;
    Statement sentencia;
    public Consultas(Connection connect){
     conect=connect;
        try {
            sentencia= conect.createStatement();
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public boolean validarAsistente(String ciAsistente){
        boolean res=false;
        String query= "SELECT * FROM asistentes WHERE ci_asis='"+ciAsistente+"'";
        ResultSet r;
        
        
        try {
            
            r = sentencia.executeQuery(query);
            if(r.next()){
                res=true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return res;
        
    }
    
     // Inserta una tupla a la tabla de asistentes
    public boolean insertarAsistente(String ci_asistente, String nombre_asis, String apellido_asis, String ocupacion_asis, String correo_asis){
        boolean res=false;
        String values = "('"+ci_asistente +"','"+nombre_asis+"','"+apellido_asis+"','"+ocupacion_asis+"','"+correo_asis+"')";
        String query = "INSERT INTO asistentes (ci_asis,nombre_asis,apellido_asis,ocupacion_asis,correo_asis) VALUES" + values;
        try{
            PreparedStatement ps = conect.prepareCall(query);

            int n = ps.executeUpdate();
            if(n>0){
                res=true;
                //JOptionPane.showMessageDialog(null,"Datos modificados");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
            res=false;
        }
        return res;
    }
    
}
