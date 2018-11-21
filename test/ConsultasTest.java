/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
    
    public ConsultasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

   
    @Test
    public void testValidarAsistente() {
        System.out.println("validarAsistente");
        int ciAsistente = 0;
        Consultas instance = null;
        boolean result = instance.validarAsistente(ciAsistente);
        assertTrue( result);
       
    }

    @Test
    public void testInsertarAsistente() {
        System.out.println("insertarAsistente");
        int ci_asistente = 0;
        String nombre_asis = "";
        String apellido_asis = "";
        String ocupacion_asis = "";
        String correo_asis = "";
        int idGrupo = 0;
        Consultas instance = null;
        boolean result = instance.insertarAsistente(ci_asistente, nombre_asis, apellido_asis, ocupacion_asis, correo_asis, idGrupo);
        assertTrue( result);
       
    }
    
}
