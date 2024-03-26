/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tcp;

import java.net.InetAddress;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author aimar
 */
public class Server {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        final int port = 12345;
        Scanner in = new Scanner(System.in);
        ServerSocket server = new ServerSocket(port);
        //Zerbitzaria bezeroen zain jarri eta bezeroen konexioak onartu. Konexio bakoitzeko, hari bat sortu
        while (true) {
            Socket client = server.accept();
             System.out.println("Client connected from: " 
            + client.getInetAddress());
      
        // Create input and output streams for the client
        InputStream inputStream = client.getInputStream();
       // OutputStream outputStream = client.getOutputStream();
      
       BufferedReader reader = new BufferedReader(
           new InputStreamReader(inputStream));
       // PrintWriter writer = new PrintWriter(outputStream, true); 
        // Auto-flushing enabled
      
        String izena = reader.readLine();
        System.out.println("Received from client: " + izena);
            ClientHandler thread = new ClientHandler(client,izena);
            thread.start();
          
        }
    }

}
