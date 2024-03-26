/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise2;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author aimar
 */
public class Server {
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
                int received=Integer.parseInt(receivedMessage);
                System.out.println("Received from client: " + received);

                // Process the received data, if needed

                // Respond to the client
                int respone=received+10;
                String responseMessage = String.valueOf(respone);
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
