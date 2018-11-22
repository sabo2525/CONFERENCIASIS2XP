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
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pc
 */
public class Consultas {
  Connection conect;
    Statement sentencia;
    private DefaultTableModel model_Asistentes;
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
    
    public void llenarTablaAsistentes(javax.swing.JTable tabla){
    
     try {
            String[]titulos = {"Carnet", "Nombre","Apellido", "Correo","Ocupacion","Conferencia"}; 
            String sql = "SELECT * FROM  asistente";
            model_Asistentes = new DefaultTableModel(null, titulos);
            sentencia= conect.createStatement();
            ResultSet rs=sentencia.executeQuery(sql);
            
            String[]fila = new String[6];
            while(rs.next()){
                fila[0]=rs.getString("carnet_c");
                fila[1]=rs.getString("nombre");
                fila[2]=rs.getString("apellido");
                fila[3]=rs.getString("correo");
                fila[4]=rs.getString("ocupacion");
                fila[5]=rs.getString("conferencia");


                
                
                
                
                model_Asistentes.addRow(fila);
            }
            tabla.setModel(model_Asistentes);
        }
        catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error" + e);

        }
    
    }
    
}