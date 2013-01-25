/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 *
 * @author biblioteca
 */
public class ReadFileTXT {
      File archivo = null;
      FileReader fr = null;
      BufferedReader br = null;
      String separador = " ";
      /**
       * Contructor:
       * Le pasamos el archivo y el caracter de separación al construir
       * @param archivo
       * @param separador 
       */

    public ReadFileTXT(File archivo, String separador) {
        
        this.archivo = archivo;
        this.separador = separador;
        
    }

    public String getSeparador() {
        return separador;
    }

    public void setSeparador(String separador) {
        this.separador = separador;
    }

    public File getArchivo() {
        return archivo;
    }

    public void setArchivo(File archivo) {
        this.archivo = archivo;
    }

/**
 * 
 * Lee un fichero que se pasa como argumento y devuelve una lista de Arrays con el contenido
 * separado por el parametro indicado según se lo pasemos por parámetro
 * @param archivo Nombre del Archivo que quiere leerse
 * @param separador Delimitador para separar las partes
 * @return ArrayList con el contenido
 */      
    
      
  public ArrayList readFromFile() {
      int contadorlineas = 0; 
      ArrayList resultado = new ArrayList();
       
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
          fr = new FileReader (archivo);
          br = new BufferedReader(fr);
          
          // Lectura del fichero
          String linea;
          //Esto puede mejorarse usando la clase Collections de java
          while((linea=br.readLine())!=null) {
              StringTokenizer tokens = new StringTokenizer(linea,separador);
              while (tokens.hasMoreTokens()){
                  
                  /***********************************************
                   * Aquí metemos como queremos devolverlos datos
                   *********************************************/   
                  resultado.add(tokens.nextToken());
              }
              contadorlineas++;
          }
          
      }
      catch(Exception e){
      }
      finally {
          // En el finally cerramos el fichero, para asegurarnos
          // que se cierra tanto si todo va bien como si salta 
          // una excepcion.
         try {                    
             if( null != fr ){   
                 fr.close();     
             }
         }
         catch (Exception e2){ 
         }
      }
      return resultado;
  }
  
   
}
