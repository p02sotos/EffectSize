/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.StringTokenizer;

/**
 *
 * @author biblioteca
 */
public class ReadFileTXT {
         File archivo = null;
      FileReader fr = null;
      BufferedReader br = null; 
      public Muestra [] matrizmuestras;
      
  public Muestra [] leerDesdeFichero(int numeroMuestras, File fichero) {
        Muestra [] matrizmuestras = new Muestra [numeroMuestras];
        int contadorlineas = 0; 
    System.out.println("hola");
      try {
         // Apertura del fichero y creacion de BufferedReader para poder
         // hacer una lectura comoda (disponer del metodo readLine()).
         //archivo = new File ("/home/p02sotos/Dropbox/Desarrollo/Java/Cohen/src/cohen/datos.cvs");
         archivo = fichero;
         fr = new FileReader (archivo);
         br = new BufferedReader(fr);

         // Lectura del fichero
         String linea;
         
         
         //Esto puede mejorarse usando la clase Collections de java
         while((linea=br.readLine())!=null) {
            StringTokenizer tokens = new StringTokenizer(linea,",");
           if (tokens.hasMoreTokens()){
                contadorlineas++;
                Double valordesviacion = Double.parseDouble(tokens.nextToken());
                Double valormedia = Double.parseDouble(tokens.nextToken());
                Double valorn = Double.parseDouble(tokens.nextToken());
                int tempn = (int)Math.floor(valorn);
                Muestra temporal = new Muestra (valordesviacion,valormedia, tempn);
                matrizmuestras [contadorlineas-1]= temporal;
            }
         }         
      }
      catch(Exception e){
      }finally{
          // En el finally cerramos el fichero, para asegurarnos
          // que se cierra tanto si todo va bien como si salta 
          // una excepcion.
         try{                    
            if( null != fr ){   
               fr.close();     
            }                  
         }catch (Exception e2){ 
         }
      }
      return matrizmuestras;
  }
  public  void matrizCal(Muestra [] matrizresultado) {
      
      
  }

    public ReadFileTXT() {
    }
    
    
}
