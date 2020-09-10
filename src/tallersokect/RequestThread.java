/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersokect;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author RICHD18
 */
public class RequestThread implements Runnable{
    
     private Socket connection;
     
     public RequestThread(Socket connection) {
        this.connection = connection;
     }

    @Override
    public void run() {
       try {

      PrintStream salida = new PrintStream(connection.getOutputStream());
      BufferedReader entrada = new BufferedReader(new InputStreamReader(connection.getInputStream()));

      String comando = entrada.readLine().toLowerCase();

      System.out.println("esta es como llega el dato de la web "+comando);
      
      
           
      leerArchivosCarpeta le = new leerArchivosCarpeta();
       ArrayList<String> cadenarecibida=null;
     
     
    
/**
      switch (comando) {
        case "fecha":  salida.println(new Date().toString()); break;
        case "suma":
          int n1 = Integer.valueOf(entrada.readLine());
          int n2 = Integer.valueOf(entrada.readLine());

          salida.println(n1 + n2);
      }
**/
            String cadenacomando = comando.substring(5, comando.length()-9);
            String parte[] = cadenacomando.split("\\.");
           for (int i = 0; i < parte.length; i++) {
               
              // System.out.println("esta es la parte   "+parte[i]+"  esta es el numero de iteraciones :"+i +"  "+parte.length);
           }
           
           
String cadena="";
long tamaño;
        switch(parte[parte.length-1]){
            
            case "html":
                cadenarecibida = le.leerHtml(comando);
              tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type:text/html");
                salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
                for (int i = 0; i < cadenarecibida.size(); i++) {
                    cadena = cadenarecibida.get(i);
                    salida.write(cadena.getBytes());
                }
            
            case "jpg":
                tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type: image/jpeg");
                salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
                le.leerImagenes(comando,salida);
//                byte[] imagen = le.leerImagenes(comando,salida);
//                for (int i = 0; i < imagen.length; i++) {
//                byte datos = imagen[i];
//                     salida.write(datos);
//                }
            case "jpeg":
                tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type: image/jpeg");
                salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
               le.leerImagenes(comando,salida);    
                
            case "png":
                tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type: image/png");
                salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
               le.leerImagenes(comando,salida);
               
                    
               
            case "css":
                tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type: text/css");
                salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
                le.leerImagenes(comando,salida);
                
                
            case "js":
                tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type: application/javascript");
                 salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
                le.leerImagenes(comando,salida);
            
            case "svg":
                tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type: image/svg+xml");
                  salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
                le.leerImagenes(comando,salida);
                
            case "woff":
                 tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type: font/woff");
                  salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
                 le.leerImagenes(comando,salida);
            case "ico":
                 tamaño = le.tamañoArchivo(comando);
                salida.println("HTTP/1.0 200 OK");
                salida.println("Content-type: image/x-icon");
                  salida.println("Content-length:"+"'"+tamaño+"'");
                salida.println();
                 le.leerImagenes(comando,salida);
                
        }
        
        
        
//salida.println("HTTP/1.0 200 OK");
//salida.println("Content-type: text/html");
//salida.println();
//           for (int i = 0; i < cadenarecibida.size(); i++) {
//               cadena = cadenarecibida.get(i);
//               salida.write(cadena.getBytes());
//           }
//String cadena = "<html><body>hola que <b>mas</b>" +
//        "<img class=\"hero-nav__logo\" src=\"assets/imgs/logo.svg\">" +
//        "" +
//        "</body></html>";

//salida.println("Content-length:"+cadena.length());

// salida.write(cadena.getBytes());


      connection.close();

    } catch (Exception exception){
      exception.printStackTrace();
    }finally {
      try {
        connection.close();
      } catch (IOException e) {
        e.printStackTrace();
      }
    }
    }
     
     
}
