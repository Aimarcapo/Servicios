package exercise1;

import java.io.*;
import java.net.*;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author aimar
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         final int port = 12345;
        
    try {
      InetAddress localHost = InetAddress.getLocalHost();
      System.out.println("Server is waiting for a connection on " 
        + localHost.getHostAddress() + ":" + port);
      ServerSocket serverSocket = new ServerSocket(port);
      while (true) {
        Socket clientSocket = serverSocket.accept();
        System.out.println("Client connected from: " 
            + clientSocket.getInetAddress());
      
        // Create input and output streams for the client
        InputStream inputStream = clientSocket.getInputStream();
        OutputStream outputStream = clientSocket.getOutputStream();
      
        BufferedReader reader = new BufferedReader(
            new InputStreamReader(inputStream));
        PrintWriter writer = new PrintWriter(outputStream, true); 
        // Auto-flushing enabled
      
        String clientMessage = reader.readLine();
        System.out.println("Received from client: " + clientMessage);
      
        // Send a response to the client
        writer.println("Hello, client!");
      
        // Close the client connection
        clientSocket.close();
    }
    }catch (IOException e) {
        e.printStackTrace();
    }
    }
    
}
