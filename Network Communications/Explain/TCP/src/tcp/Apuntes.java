package tcp;

import java.io.*;
import java.net.*;
import java.util.Scanner;

/**
 * TCP Communication in Java
 */
public class Apuntes {



public class TCPServer {

    public static void main(String[] args) {
        try {
            // Server Socket
            ServerSocket serverSocket = new ServerSocket(12345);
            
            // Wait for client to connect
            Socket clientSocket = serverSocket.accept();
            
            // Input and Output Streams
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            
            // Use BufferedReader for reading from the client
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String clientMessage = reader.readLine();
            System.out.println("Message from client: " + clientMessage);
            
            // Use PrintWriter for sending a response to the client
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, client!");
            
            // Close the connections
            clientSocket.close();
            serverSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

public class TCPClient {

    public static void main(String[] args) {
        try {
            // Client Socket
            Socket clientSocket = new Socket("localhost", 12345);
            
            // Input and Output Streams
            InputStream in = clientSocket.getInputStream();
            OutputStream out = clientSocket.getOutputStream();
            
            // Use PrintWriter for sending a message to the server
            PrintWriter writer = new PrintWriter(out, true);
            writer.println("Hello, server!");
            
            // Use BufferedReader for reading the server's response
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String serverResponse = reader.readLine();
            System.out.println("Response from server: " + serverResponse);
            
            // Close the connection
            clientSocket.close();
            
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


}
