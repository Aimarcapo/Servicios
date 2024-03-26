/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangle;

/**
 *
 * @author aimar
 */



import java.net.*;
import java.util.Scanner;





public class Client { 
    public static void main(String[] args) { 
        final int serverPort = 12345;    
        try {
            Scanner in=new Scanner(System.in);
            DatagramSocket socket = new DatagramSocket();
    
            InetAddress serverAddress = InetAddress.getByName("localhost");//Server on Localhost
         
            System.out.println("First cathetus");
            int cathetus1=in.nextInt();
            System.out.println("Second cathetus");
            int cathetus2=in.nextInt();
            String message=cathetus1+","+cathetus2;
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
