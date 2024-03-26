/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise1;
import java.net.*;
import java.io.*;
/**
 *
 * @author aimar
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException {
        // TODO code application logic here
         final int port = 12345;
        InetAddress serverAddress = InetAddress.getLocalHost();
        try (Socket socket = new Socket(serverAddress, port)) {
            // Create input and output streams for the server
            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true); 
            // Auto-flushing enabled

            // Send a message to the server
            writer.println("Hello, server!");

            // Receive and print the response from the server
            String serverResponse = reader.readLine();
            System.out.println("Server says: " + serverResponse);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
}
