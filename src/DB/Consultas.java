/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
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
        String query= "SELECT * FROM inscritos WHERE ci='"+ciAsistente+"'";
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
        
//boolean res=false;
//
//String sql = "SELECT * FROM inscritos WHERE ci=" + ciAsistente ;
//        try {
//    sentencia = conect.createStatement();
//    ResultSet rs = sentencia.executeQuery(sql);
//    rs.next();
//    
//    rs.getString("nombre");
//    rs.getString("valor");
//    //javax.swing.JOptionPane.showMessageDialog(this,"YA EXISTEN ESOS DATOS","AVISO!",javax.swing.JOptionPane.INFORMATION_MESSAGE);
//    
//    
//    
//} catch (SQLException e) {
//        res=true;
//
//    System.out.println("error " +e);
//    
//}
//
//return res;

    }
    
     // Inserta una tupla a la tabla de inscritos
    public boolean insertarAsistente(String ci_asistente, String nombre_asis,
            String ocupacion_asis, String correo_asis){
        boolean res=false;
        String values = "("+ci_asistente +",'"+nombre_asis+"','"+correo_asis+"','"+ocupacion_asis+"')";
        String query = "INSERT INTO inscritos(ci,nombre,correo,ocupacion) VALUES" + values;
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
            JOptionPane.showMessageDialog(null,"eror"+ ex);

        }
        return res;
    }
    
    public void llenarTablaAsistentes(javax.swing.JTable tabla){
    
     try {
            String[]titulos = {"Carnet", "Nombre","Apellido", "Correo","Ocupacion","Conferencia"}; 
            String sql = "SELECT asistentes.ci,id_grupo, asistio,nombre,correo,ocupacion"
                    + " FROM asistentes, inscritos WHERE asistentes.ci=inscritos.ci";
            model_Asistentes = new DefaultTableModel(null, titulos);
            sentencia= conect.createStatement();
            ResultSet rs=sentencia.executeQuery(sql);
            
            String[]fila = new String[6];
            while(rs.next()){
                fila[0]=rs.getString("ci");
                fila[1]=rs.getString("id_grupo");
                fila[2]=rs.getString("asistio");
                fila[3]=rs.getString("nombre");
                fila[4]=rs.getString("correo");
                fila[5]=rs.getString("ocupacion");


                
                
                
                
                model_Asistentes.addRow(fila);
            }
            tabla.setModel(model_Asistentes);
        }
        catch (SQLException e) {
    JOptionPane.showMessageDialog(null, "Error" + e);

        }
    
    }
    
    public boolean eliminarInscrito(String ci){
    boolean res=false;
        try {
            String sql = "delete from inscritos where ci="+ci;
            sentencia=conect.createStatement();
            int n = sentencia.executeUpdate(sql);
            if(n>0){
               // JOptionPane.showMessageDialog(null, "Tutor Retirado");
                System.out.println("borrado");
                res=true;
            } 
        } catch (HeadlessException | SQLException e) {
            JOptionPane.showMessageDialog(null,"Error"+ e.getMessage());
        }
        return res;
    }
    
    
    public void inscribirGrupo(String cadena,String carnet){
    String aux="";
    char letra;
    for(int i=0;cadena.length()>i;i++){
    letra=cadena.charAt(i);
        if (letra!=45) {
            aux+=letra;
        } else {
            registrarAsis(aux,carnet);
            System.out.println(aux);
            aux="";
        }
    
    }
            registrarAsis(aux, carnet);


}

    public void registrarAsis(String aux, String carnet) {
 //boolean res=false;
        String values = "("+carnet +","+aux+",'no')";
        String query = "INSERT INTO asistentes(ci,id_grupo,asistio) VALUES" + values;
        try{
            PreparedStatement ps = conect.prepareCall(query);

            int n = ps.executeUpdate();
            if(n>0){
                //res=true;
                //JOptionPane.showMessageDialog(null,"Datos modificados");
            }
        }
        catch(SQLException ex){
            Logger.getLogger(Consultas.class.getName()).log(Level.SEVERE, null, ex);
           // res=false;
            JOptionPane.showMessageDialog(null,"eror"+ ex);

        }
        //return res;

    }
    
}
