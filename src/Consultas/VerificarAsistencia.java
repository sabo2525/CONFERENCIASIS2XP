/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Consultas;

import java.util.Iterator;

/**
 *
 * @author Edgar Ruben B
 */
public class VerificarAsistencia {
    
    String siglaConferencia = "";
    String caracter = "";
    int a = 0;
    public void verificar(String cadena){
        for(a = 0; a<cadena.length();a++){
            caracter = Character.toString(cadena.charAt(a));
            if(cadena.charAt(a) == a){
                //devolverSiglaAlMetodo
                System.out.println(siglaConferencia);
                siglaConferencia = "";
            }
            else{
                siglaConferencia.concat(caracter);
            }
        }
    }
    
    public static void main(String[] args) {
        VerificarAsistencia verificador = new VerificarAsistencia();
        verificador.verificar("HaOLA-aMUNaDO");
    }
}
