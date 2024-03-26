/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tcpexample;

/**
 *
 * @author aimar
 */
    import java.io.*;
import java.net.*;

public class Server {


  public static void main(String[] args) throws IOException {
    final int port = 12345;
        
  
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
        try {
                // Convert received string to integer
                int receivedNumber = Integer.parseInt(clientMessage);

                // Decide by which number to add
                int additionNumber = 10; // Change this value as needed

                // Calculate the result
                int result = receivedNumber + additionNumber;

                // Send the result back to the client
                writer.println(result);
            } catch (NumberFormatException e) {
                // Handle invalid input from the client
                writer.println("Invalid input. Please send a valid number.");
            }

            // Close the client connection
            clientSocket.close();
    }
    
  }
}
