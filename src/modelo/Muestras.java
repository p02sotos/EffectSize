/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import utils.JTextValidator;

/**
 *
 * @author p02sotos
 * Esta clase es un panel de Muestra completo en el que se 
 * definen la media, desviación y tamaño de la muestra en un panel
 * Las cajas de texto requiren que se introduzca un número.
 */
public class Muestras extends JPanel {
    /*Configuramos el panel*/
    private JTextValidator muestraMedia;
    private JTextValidator muestraDesviacion;
    private JTextValidator muestraN;
    static int contadorMuestras = 0;
    
    /*Contructor*/
    public Muestras(){
        super();
        /*Creamos las cajas de texto validadas*/
        muestraMedia = new JTextValidator("[[0-9]|.]*");
        muestraDesviacion = new JTextValidator("[[0-9]|.]*");
        muestraN = new JTextValidator("[[0-9]|.]*");
        contarMuestras();
        Border BorderBlack = BorderFactory.createLineBorder(Color.black);
        Border border = BorderFactory.createTitledBorder(BorderBlack, "Muestra " + contadorMuestras);
        Border Borderspam = BorderFactory.createEmptyBorder(4, 2, 4, 3);
        GridLayout dis = new GridLayout(3, 1,1,1);
        muestraMedia.setText("0");
        muestraDesviacion.setText("0");
        muestraN.setText("0");

        setLayout(dis);
        add(new JLabel(" Media"));
        add(muestraMedia);
        add(new JLabel(" Desviación"));
        add(muestraDesviacion);
        add(new JLabel(" Tamaño Muestral"));
        add(muestraN);
        setBorder(BorderFactory.createCompoundBorder(Borderspam,border));
        /**/
                
        
    }
    
    /** Getter and Setters*/
     /** Métodos getM() 
        * @return Devuelve un double con la media
        */ 
     public double getM() {
        return Double.parseDouble(this.muestraMedia.getText());
    }
     /** Métodos getD() 
        * @return Devuelve un double con la desviación
        */ 
     
    public double getD() {
        
        return Double.parseDouble(this.muestraDesviacion.getText());
    }
    /** Métodos getN() 
        * @return Devuelve un double con el tamaño de la muestra
        */ 
    public double getN() {
        return Double.parseDouble(this.muestraN.getText());
    }
     /** Método setM(String val) Introduce la media en la muestra
        * @params Un String  con la media
        * @return Sin valor de retorno 
        * @exception exceptions Ningún error (Excepción) definida
        */ 
    public void setM(String val) {
        muestraMedia.setText(val);
    }
    /** Método setD(String val) Introduce la desviacion en la muestra
        * @params Un String  con la Desviación
        * @return Sin valor de retorno 
        * @exception exceptions Ningún error (Excepción) definida
        */ 
    public void setD(String val) {
        muestraDesviacion.setText(val);
    }
    /** Método setN(String val) Introduce el tamaño de la muestra
        * @params Un String  con la tamaño de la muestra
        * @return Sin valor de retorno 
        * @exception exceptions Ningún error (Excepción) definida
        */ 
    public  void setN(String val) {
        muestraN.setText(val);
    }
    /** Métodos getMuestraCompleta()
        * @return Devuelve un Array de Doubles con la media, desviacion
        * y tamañno de la muestra
        */ 
    public double[] getMuestraCompleta(){
        double[] temporal = new double[3];
        temporal[0] = Double.parseDouble(this.muestraMedia.getText());
        temporal[1] = Double.parseDouble(this.muestraDesviacion.getText());
        temporal[2] = Double.parseDouble(this.muestraN.getText());
        return temporal;
        
    }
     /** MétodosetMuestraCompleta(String valM, String valD, String valN)
      * Introduce todos los parámetros completos en la muestra
        * @params Tres Strings
        *   valM como Media
        *   valD como Desviación
        *   valN como tamaño de la muestra
        * @return Sin valor de retorno 
        * @exception exceptions Ningún error (Excepción) definida
        */ 
    public void setMuestraCompleta(String valM, String valD, String valN) {
         muestraMedia.setText(valM);
         muestraDesviacion.setText(valD);
         muestraN.setText(valN);
        
    }
    public static void contarMuestras() {
        contadorMuestras++;
    }
    
    
}
