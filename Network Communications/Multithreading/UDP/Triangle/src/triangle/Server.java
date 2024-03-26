/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangle;

import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
 *
 * @author aimar
 */
import java.net.*;

public class Server
{
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
                String[] separated = receivedMessage.split(",");
                double cathetus1 = Double.parseDouble(separated[0]);
                double cathetus2 = Double.parseDouble(separated[1]);

                // Create a new thread to handle the client
                ClientHandler clientHandler = new ClientHandler(socket, receivedPacket.getAddress(),
                        receivedPacket.getPort(), cathetus1, cathetus2);
                clientHandler.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
