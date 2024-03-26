/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author aimar
 */
public class Apuntes {




public class UDPServer {
    public static void main(String[] args) {
        final int port = 12345;

        try {
            DatagramSocket socket = new DatagramSocket(port);
            System.out.println("Server is listening on port " + port);

            byte[] buffer = new byte[1024];

            while (true) {
                DatagramPacket receivedPacket = new DatagramPacket(buffer, buffer.length);
                socket.receive(receivedPacket);

                String receivedMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                System.out.println("Received from client: " + receivedMessage);

                // Process the received data, if needed

                // Respond to the client
                String responseMessage = "Hello, client!";
                byte[] responseData = responseMessage.getBytes();
                DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                        receivedPacket.getAddress(), receivedPacket.getPort());
                socket.send(responsePacket);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


public class UDPClient { 
    public static void main(String[] args) { 
        final int serverPort = 12345;    
        try {
            DatagramSocket socket = new DatagramSocket();
    
            InetAddress serverAddress = InetAddress.getByName("localhost");//Server on Localhost
            String message = "Hello, server!";
            byte[] data = message.getBytes();
    
            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
            socket.send(packet);
    
            // Receive the response from the server
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
    
            String serverResponse = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server says: " + serverResponse);
    
            // Close the socket when done
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


}
