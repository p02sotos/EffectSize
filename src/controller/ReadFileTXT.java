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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import modelo.Muestras;
/**
 *
 * @author p02sotos
 */
public class ReadFileTXT {
      private File archivo = null;
      private FileReader fr = null;
      private BufferedReader br = null;
      private String separador;
      private ArrayList <Muestras> listadoMuestras;      
      /**
       * Contructor:
       * Le pasamos el archivo y el caracter de separación al construir
       * @param archivo
       * 
       */    
     public ReadFileTXT(File archivo) {        
        this.archivo = archivo;
        /*separador = " ";*/        
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
    
      
  public ArrayList readFromFile(String separador) {
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
  /**
   * 
   * @param muestra
   * @return ArrayList <Muestras> Devuelve un ArrayList con las muestras
   */
  public ArrayList<Muestras> convertir(ArrayList muestra) {
      
      listadoMuestras = new ArrayList<>();    
      try {
      for (int i = 0 ; i<muestra.size() ; i= i+3 ) {
          Muestras aux = new Muestras(); 
          /*Si no se crea la variable auxiliar dentro del loop
           * se irá guardando una referencia a la variable todo el rato
           * y quedará en cada elemento del ArrayList resultado una copia 
           * del ultimo valor. Esto es debido a que los objetos siempre
           * se hacen asignaciones por referencia y no por valor
           * IMPORTANTE
           */   
          aux.setM(muestra.get(i).toString());          
          aux.setD(muestra.get(i+1).toString());          
          aux.setN(muestra.get(i+2).toString());            
          listadoMuestras.add(aux);  
      }      
      return listadoMuestras;
      }
      catch (IndexOutOfBoundsException e) {
          JOptionPane.showMessageDialog(new JFrame("Error de Fichero"),
                "El fichero introducido no es válido con ese delimitador");
          return null;
          
      }
  }
  private void debugMostrarresultado (ArrayList<Muestras> resultado) {
       System.out.println("Número de Muestras " + resultado.size());
      for (int i = 0 ; i<resultado.size() ; i++ ){
          Muestras aux = new Muestras();               
          aux = resultado.get(i);
          System.out.println(i);          
          System.out.println(String.valueOf(aux.getM()));
          System.out.println(String.valueOf(aux.getD()));
          System.out.println(String.valueOf(aux.getN()));          
      
      }
      
  }
  
   
}
