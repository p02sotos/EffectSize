/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadorasimplecohen;

import calculadoraGUI.Muestras;

/**
 *
 * @author p02sotos
 * Clase Abstracta  para calcular la d de cohen siguiendo la fórmula (4) de
 * http://clbe.wordpress.com/2011/10/26/la-d-de-cohen-como-tamano-del-efecto/
 */
public abstract class CalcularCohen {
    /** Método estático calcular(Muestras a, Muestras b) que hace el calculo de 
     * la d de Cohen y devuelve un double con su valor
        * @params Dos Objetos Muestras
        * @return Un double con el valor de la d de Cohen calculada
        * @exception exceptions Ningún error (Excepción) definida
        */ 
    public static double calcular(Muestras a, Muestras b){
        double cohen;
        double s;
        s = ((a.getN() -1)*Math.pow(a.getD(), 2)+(b.getN()-1)*Math.pow(b.getD(), 2))/(a.getN()+b.getN());
        cohen = (a.getM() - b.getM())/s;
        
        return cohen;
      /**/    
    }
    public static String compruebaTamano (double cohen) {
        
        if ((Math.abs(cohen)>0.2d)&(Math.abs(cohen)<0.2d)) {
            return "<html><p style = \"padding: 5px;\">El tamaño del efecto es bajo </p></html>";
        }
        else if ((Math.abs(cohen)>=0.5d)&(Math.abs(cohen)<0.8d)) {
            return "<html><p style = \"padding: 5px;\">El tamaño del efecto es medio </p></html>";
        }
        else if ((Math.abs(cohen)>=0.8d)) {
            return "<html><p style = \"padding: 5px;\">El tamaño del efecto es alto </p></html>";
        }
         else if ((Math.abs(cohen)>=0)&(Math.abs(cohen)<=0.2d)) {
            return "<html><p style = \"padding: 5px;\">El tamaño del efecto es medio </p></html>";
        }
        
        else 
            return"<html><p style = \"padding: 5px;\">Ha ocurrido algún error </p></html>";
    }          
        
       
    
    
}
