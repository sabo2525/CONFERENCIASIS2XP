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
 * @author sabo
 */
public class CorreoTest {
    
    public CorreoTest() {
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
    public void testValidarCorreo(){
        Correo c= new Correo();
        assertTrue(c.validarCorreo("algo@gmail.com"));
        assertFalse(c.validarCorreo(""));
        assertFalse(c.validarCorreo("algo@"));
        assertFalse(c.validarCorreo("algo@gmail"));
        assertFalse(c.validarCorreo("algo@gmail.dcdads"));
        assertFalse(c.validarCorreo("@gmail.dcdads"));
        assertFalse(c.validarCorreo("gmail.dcdads"));
        assertFalse(c.validarCorreo("gmail.dcdads"));
        assertFalse(c.validarCorreo("asdfasd"));
        assertFalse(c.validarCorreo("2435243"));
        assertFalse(c.validarCorreo("......."));
        assertFalse(c.validarCorreo("//*/++"));
        assertTrue(c.validarCorreo("sdcsa-23@hotmail.com"));
        assertTrue(c.validarCorreo("sdcsa-23@sdasd.asdfsad"));
        
    
    }
    @Test 
    public void testEnviar(){
        Correo c= new Correo();
        if(c.tieneConexionInternet()){
            assertTrue(c.enviar("cbrt113@gmail.com"));
        }else{
            assertFalse(c.enviar("cbrt113@gmail.com"));
        }
    }

}
