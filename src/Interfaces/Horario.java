/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

/**
 *
 * @author oscar
 */
public class Horario {    
    public Horario(){}
    
    public boolean esHoraValida(String hora){
        boolean res =true;
        if(hora.length()==5){
            int h1=hora.charAt(0);
            int h2=hora.charAt(1);
            int m1=hora.charAt(3);
            int m2 =hora.charAt(4);
            if((h1<58&&h1>47)&&(h2<58&&h2>47)&&(m1<58&&m1>47)&&(m2<58&&m2>47)&&(hora.charAt(2)==':')){
                res=true;
                String h = ""+hora.charAt(0)+hora.charAt(1);
                String m = ""+hora.charAt(3)+hora.charAt(4);
                int hh=Integer.parseInt(h);
                int mm = Integer.parseInt(m);
                if(!(hh<24&&hh>-1&&mm<60&&mm>-1)){
                    res = false;
                }
            }
            else{
                res =false;
            }
        }else{
            res=false;
        }
        return res;
    }
}
