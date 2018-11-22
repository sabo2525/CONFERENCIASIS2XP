/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import historia3oscarmiguel.Horario;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oscar
 */
public class TestHorario {
    
    public TestHorario() {
    }
    @Test
    public void formatoHoraSimbolos(){
        Horario h = new Horario();
        String simbolos = "?*-=.";
        Assert.assertEquals(false,h.esHoraValida(simbolos));        
    }
    @Test
    public void formatoHoraLongitudMayor(){
        Horario h = new Horario();
        String simbolos = "?*-=kquio";
        Assert.assertEquals(false,h.esHoraValida(simbolos));        
    }
    @Test
    public void formatoHoraLongitudMenor(){
        Horario h = new Horario();
        String simbolos = "?*-";
        Assert.assertEquals(false,h.esHoraValida(simbolos));        
    }
    @Test
    public void HoraNoMayora24(){
        Horario h = new Horario();
        String simbolos = "25:05";
        Assert.assertEquals(false,h.esHoraValida(simbolos));        
    }
    @Test
    public void MinNoMayora59(){
        Horario h = new Horario();
        String simbolos = "23:60";
        Assert.assertEquals(false,h.esHoraValida(simbolos));        
    }
    
    @Test
    public void DosPuntos(){
        Horario h = new Horario();
        String simbolos = "23;09";
        Assert.assertEquals(false,h.esHoraValida(simbolos));        
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
