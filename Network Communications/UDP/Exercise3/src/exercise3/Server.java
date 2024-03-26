/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise3;

/**
 *
 * @author aimar
 */
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
                String[] mensaje = receivedMessage.split(",");
                if (mensaje.length == 2) {
                    String nombre = mensaje[0];
                    int age = Integer.parseInt(mensaje[1]);
                    String response;
                    if (age < 18) {
                        response = nombre + " that is " + age + " years old, you are not of legal age";
                    } else {
                        response = nombre + " that is " + age + " years old, you are of legal age";
                    }

                    System.out.println(response);
                    byte[] responseData = response.getBytes();
                    DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                            receivedPacket.getAddress(), receivedPacket.getPort());
                    socket.send(responsePacket);

                    // Rest of your code here
                } else {
                    // Handle the case where the message does not have the expected format
                    System.out.println("Invalid message format received");
                    System.out.println(mensaje[0]);
                    System.out.println(mensaje[1]);
                }
                //int received=Integer.parseInt(receivedMessage);

                // Process the received data, if needed
                // Respond to the client
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
