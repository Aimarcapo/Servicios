/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

/**
 *
 * @author aimar
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
         final int serverPort = 12345;
        try {
            
            DatagramSocket socket = new DatagramSocket();
       
            Scanner in = new Scanner(System.in);
            InetAddress serverAddress = InetAddress.getByName("localhost");//Server on Localhost
                 byte[] buffera = new byte[1024];
             DatagramPacket receivedPacket = new DatagramPacket(buffera, buffera.length);
             String receivedMessage = new String(receivedPacket.getData(), 0, receivedPacket.getLength());
             String [] separado =receivedMessage.split(",");
            
             for(String sep:separado){
                 System.out.println(sep);
             }
             System.out.println(receivedMessage);
            System.out.println("Enter your option:");
            int option = in.nextInt();
            String opcion=String.valueOf(option);
            byte[] data = opcion.getBytes();
            

            DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
            socket.send(packet);

            // Receive the response from the server
            byte[] buffer = new byte[1024];
            DatagramPacket responsePacket = new DatagramPacket(buffer, buffer.length);
            socket.receive(responsePacket);
            String serverResponse = new String(responsePacket.getData(), 0, responsePacket.getLength());
            System.out.println("Server says this: " + serverResponse);

            // Close the socket when done
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}
