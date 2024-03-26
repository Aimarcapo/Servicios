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
            Scanner in=new Scanner(System.in);
            InetAddress serverAddress = InetAddress.getByName("localhost");//Server on Localhost
              System.out.println("Enter your name and age in this format(name,age):");
             String message=in.next();
            byte[] data = message.getBytes();
    
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