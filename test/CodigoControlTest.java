/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.File;
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
public class CodigoControlTest {
    
    public CodigoControlTest() {
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
    public void testGenerarQr(){
        CodigoControl cod=new CodigoControl();
        boolean respuesta=cod.generarQr("Juan",12345678,0);
        assertEquals(false, respuesta);
        respuesta=cod.generarQr("Juan",12345678,10);
        assertEquals(true,respuesta);
        respuesta=cod.generarQr("Juan",1234567890,10);
        assertEquals(false,respuesta);
        respuesta=cod.generarQr("Juan ",1234567890,10);
        assertEquals(false,respuesta);
        respuesta=cod.generarQr("Juan",12340567,10);
        assertEquals(false,respuesta);
        respuesta=cod.generarQr("Pedro",87654321,20);
        assertEquals(true,respuesta);
        respuesta=cod.generarQr("Pedro",87654321,20);
        assertEquals(true,respuesta);
        respuesta=cod.generarQr(" Pedro",87654321,20);
        assertEquals(false,respuesta);
        File img = new File("");
        assertEquals(true,img.exists());
        File img2 = new File("");
        assertEquals(false,img2.exists());
        
    }
    
}
