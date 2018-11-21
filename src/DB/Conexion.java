/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author LUIS
 */
public class Conexion {
    
    private Connection conexion;
    public Conexion(){
    conexion=null;
        //********************************************** 
// Se definen datos para la conexion a la base de datos* 
//********************************************** 
String driver = "org.postgresql.Driver"; 
String connectString = "jdbc:postgresql://localhost:5432/BD_Xp"; 
// ACA PONE DONDE ESTA TU BASE DE DATOS 
String user = "postgres"; 
String password = "herbas"; 

try { 
//************************************************************************* 
// Se realiza la conexión a la Base de Datos tomando los datos anteriormente definidos* 
//************************************************************************* 
Class.forName(driver); 
 conexion = DriverManager.getConnection(connectString, user, password); 
    
    
}       catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, ex);
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
            return valid;
    }
 public Connection getConexion(){
        return conexion;
}
}
