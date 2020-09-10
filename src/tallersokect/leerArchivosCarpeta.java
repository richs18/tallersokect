/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersokect;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author RICHD18
 */
public class leerArchivosCarpeta {
    ArrayList<String> resultadocadena = new ArrayList<>();
    FileInputStream fileinput = null;
    BufferedInputStream mybuffer = null;
    DataInputStream DataInput = null;
    String cadena;
   public  leerArchivosCarpeta(){ }
   
  
    
   
    public ArrayList<String>leerHtml(String nombre_archivo){
         String temp="";
         String ruta ="C:\\Users\\RICHD18\\Documents\\NetBeansProjects\\tallersokect\\templates/";
       String complemento = "";
       File archivos = new File(ruta); 
        long tamañoaArchivo= archivos.length();
        // System.out.println("este es el tamaño del archivo  "+tamañoaArchivo);
       archivos.getAbsolutePath();
       
       //tener en cuenta que toca separa cadena por el llega una cadena
       // y necesitamos solo el dato  final de esa cadena que es el archivo
       //consultado toca hacer un split
       
      System.out.println("este es el dato antes de concatenar a ruta  "+nombre_archivo.substring(5, nombre_archivo.length()-9));
      String rutafinal= ruta+nombre_archivo.substring(5, nombre_archivo.length()-9);
      
        try {
            int m =0;
            fileinput = new FileInputStream (rutafinal);
            mybuffer = new BufferedInputStream (fileinput);
            DataInput = new DataInputStream (mybuffer);
            while(DataInput.available()!=0) {
               temp = DataInput.readLine();
                 resultadocadena.add(temp);
                System.out.println("estos son los datos del html "+resultadocadena.get(m));
                m=m+1;
            }
            
          
            
//            fileinput.close();
//            mybuffer.close();
//            DataInput.close();

            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(leerArchivosCarpeta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(leerArchivosCarpeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultadocadena;
        

    }
   
   
    public void leerImagenes(String  nombre_archivo,PrintStream output){
     int BLOCK_SIZE =500;
        try {
            String ruta ="C:\\Users\\RICHD18\\Documents\\NetBeansProjects\\tallersokect\\templates/";
            String rutafinal= ruta+nombre_archivo.substring(5, nombre_archivo.length()-9);
            
            System.out.println("ruta final  :"+rutafinal);
//            File archivos = new File(rutafinal); 
//            imagen = ImageIO.read(archivos);
//           
//            ImageIO.write(imagen, "jpg", baos);
//          
//            baos.flush();
            
       FileInputStream fIn = new FileInputStream(rutafinal);
       
    byte[] bloque = new byte[BLOCK_SIZE];
    int bytesRead = 0;
    while((bytesRead = fIn.read(bloque))==BLOCK_SIZE){
      output.write(bloque, 0, bytesRead);
    }
    fIn.close();

           
        } catch (IOException ex) {
            Logger.getLogger(leerArchivosCarpeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void leerIdefault(String  nombre_archivo,PrintStream output){
     int BLOCK_SIZE =10;
        try {
            String ruta ="C:\\Users\\RICHD18\\Documents\\NetBeansProjects\\tallersokect\\templates/";
            String rutafinal= ruta+nombre_archivo.substring(5, nombre_archivo.length()-17);
            
            System.out.println("ruta final  :"+rutafinal);
//            File archivos = new File(rutafinal); 
//            imagen = ImageIO.read(archivos);
//           
//            ImageIO.write(imagen, "jpg", baos);
//          
//            baos.flush();
            
       FileInputStream fIn = new FileInputStream(rutafinal);
    byte[] bloque = new byte[BLOCK_SIZE];
    int bytesRead = 0;
    while((bytesRead = fIn.read(bloque))==BLOCK_SIZE){
      output.write(bloque, 0, bytesRead);
    }
    fIn.close();

           
        } catch (IOException ex) {
            Logger.getLogger(leerArchivosCarpeta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    long tamaño;
   public long tamañoArchivo(String archivo){
       String ruta ="C:\\Users\\RICHD18\\Documents\\NetBeansProjects\\tallersokect\\templates/";
            String rutafinal= ruta+archivo.substring(5, archivo.length()-9);
       File f = new File(rutafinal);
       tamaño = f.length();
        return tamaño;
   }
   
    
}
