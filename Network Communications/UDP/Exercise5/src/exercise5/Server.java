/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package exercise5;

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
                int id = 2;
                String receivedMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
                String[] mensaje = receivedMessage.split(",");
                if (mensaje.length == 4) {
                    String nombre = mensaje[1];
                    int age = Integer.parseInt(mensaje[2]);
                    float distance = Float.valueOf(mensaje[3]);

                    Student student = new Student(id, nombre, age, distance);
                    System.out.println(student.toString());
                    String response = student.toString();
                    byte[] responseData = response.getBytes();
                    DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length,
                            receivedPacket.getAddress(), receivedPacket.getPort());
                    socket.send(responsePacket);

                    // Rest of your code here
                } else {
                    // Handle the case where the message does not have the expected format
                    System.out.println("Invalid message");
                    System.out.println(mensaje[0]);
                    System.out.println(mensaje[1]);
                    System.out.println(mensaje[2]);
                    System.out.println(mensaje[3]);
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
