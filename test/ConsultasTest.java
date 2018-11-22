/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import DB.Conexion;
import DB.Consultas;
import java.sql.Connection;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author pc
 */
public class ConsultasTest {
     Conexion con;
     Consultas co;
     Connection c;
    public ConsultasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void before(){
       
       con = new Conexion();
       c=con.getConexion();
       co= new Consultas(c);
    
    }
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
//    public void after(){
//    co.eliminarInscrito("12345");
//    System.out.println("eliminarInscrito");
//    }

   
    @Test
    public void testValidarAsistente() {
        System.out.println("validarAsistente");
        String ciAsistente = "123";
        
        boolean result = co.validarAsistente(ciAsistente);
        assertFalse(result);
       
    }

    @Test
    public void testInsertarAsistente() {
        System.out.println("insertarAsistente");
        String ci_asistente = "12345";
        String nombre_asis = "luis";
        String ocupacion_asis = "ingeniero";
        String correo_asis = "correo@gmail.com";
        boolean result =co.insertarAsistente(ci_asistente, nombre_asis, 
                  correo_asis,ocupacion_asis);
        assertTrue( result);
       
    }
     @Test
    public void testEliminarAsistente() {
        System.out.println("eliminarAsistente");
        String ciAsistente = "12345";
        
        boolean result = co.eliminarInscrito(ciAsistente);
        assertTrue(result);
       
    }

    
}
