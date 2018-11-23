/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import Codigo.CodigoControl;
import Codigo.Decodificador;
import java.io.File;
import java.io.IOException;
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
    public void testGenerarQr() throws IOException{
        CodigoControl cod=new CodigoControl();
        Decodificador deco=new Decodificador();
        boolean respuesta=cod.generarQr("Juan","12345678","0");
        String prueba="Juan-12345678-10";
        cod.generarQr("Juan","12345678","10");
        File file = new File((new File("."))+"/src/ImagenesInterfaces/qr.png");
        assertTrue(prueba.equals(deco.decodificarQr(file)));
        assertEquals(true,respuesta);
        respuesta=cod.generarQr("Juan","1234567890","10");
        assertEquals(true,respuesta);
        respuesta=cod.generarQr("Pedro","87654321","20");
        assertEquals(true,respuesta);
        String prueba2="Pedro-87654321-20";
        cod.generarQr("Pedro","87654321","20");
        File file2 = new File((new File("."))+"/src/ImagenesInterfaces/qr.png");
        assertTrue(prueba2.equals(deco.decodificarQr(file2)));
    }
    
}
