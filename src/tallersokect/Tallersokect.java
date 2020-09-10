/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tallersokect;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 *
 * @author RICHD18
 */
public class Tallersokect {

    /**
     * @param args the command line arguments
     */
    static Executor poolHilos;
    public static void main(String[] args) throws IOException {
        
//       String archivo="2106_soft_landing";
//      leerArchivosCarpeta le = new leerArchivosCarpeta();
//     ArrayList<String> cadenarecibida = le.leerHtml(archivo);
//        for (int i = 0; i < cadenarecibida.size(); i++) {
//            System.out.println("estos son los dato retornados "+cadenarecibida.get(i));
//        }
        
        //aqui coomienza el sokect
        ServerSocket server = new ServerSocket(45000);
    poolHilos = Executors.newFixedThreadPool(50);

    //esperando una conexion...
    while(true) {
      System.out.println("Esperando conexion.........");

      Socket connection = server.accept();
      System.out.println("Conexion establecida.........");

      RequestThread hilo = new RequestThread(connection);
      poolHilos.execute(hilo);

    }
        
        
        
    }
    
}
