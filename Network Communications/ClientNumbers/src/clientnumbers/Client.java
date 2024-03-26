/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package clientnumbers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author aimar
 */
public class Client {

    /**
     * @param args the command line arguments
     */

        public static void main(String[] args) throws UnknownHostException, IOException {
         final int port = 12345;
        InetAddress serverAddress = InetAddress.getLocalHost();
        Socket socket = new Socket(serverAddress, port);
        
        // Create input and output streams for the server
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(
                new InputStreamReader(inputStream));
        PrintWriter writer = new PrintWriter(outputStream, true);
        // Auto-flushing enabled

        // Receive and print the client number from the server
        String clientNumber = reader.readLine();
        System.out.println("Server says: " + clientNumber);

        // Send a message to the server
        writer.println("Hello, server!");

        // Close the connection
        socket.close();

    }
    
    
}
