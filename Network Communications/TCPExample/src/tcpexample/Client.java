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

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        //final String serverAddress = "localhost";
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

        // Send a message to the server
        writer.println(3);

        // Receive and print the response from the server
        String serverResponse = reader.readLine();
        System.out.println("Server says: " + serverResponse);

    }

}
