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
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author aimar
 */
public class Client {

    public static void main(String[] args) {
        final int serverPort = 12345;
        try {
            DatagramSocket socket = new DatagramSocket();
            Scanner in = new Scanner(System.in);
            InetAddress serverAddress = InetAddress.getByName("localhost");//Server on Localhost
            System.out.println("Enter your name:");
            String name = in.next();
            System.out.println("Enter your age:");
            int age = in.nextInt();
            System.out.println("Enter the distance to college:");
            float distance = in.nextFloat();
            Student student = new Student();
            student.setName(name);
            student.setAge(age);
            student.setDistanceToCollege(distance);
            String estudiante = student.toString();
            byte[] data = estudiante.getBytes();

            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
            socket.send(packet);

            // Receive the response from the server
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String serverResponse = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server says the sum is: " + serverResponse);

            // Close the socket when done
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
