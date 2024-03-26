/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package triangle;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 *
 * @author aimar
 */
public class ClientHandler extends Thread{

    /**
     * @param args the command line arguments
     */
    
  private double cathetus1;
    private double cathetus2;
    private DatagramSocket socket;
    private InetAddress clientAddress;
    private int clientPort;

    public ClientHandler(DatagramSocket socket, InetAddress clientAddress, int clientPort, double cathetus1, double cathetus2) {
        this.socket = socket;
        this.clientAddress = clientAddress;
        this.clientPort = clientPort;
        this.cathetus1 = cathetus1;
        this.cathetus2 = cathetus2;
    }

    public void run() {
        try {
            // Process data (calculate hypotenuse)
            double hypotenuse = Math.sqrt(cathetus1 * cathetus1 + cathetus2 * cathetus2);

            // Respond to the client
            String responseMessage = "Hypotenuse: " + hypotenuse;
            byte[] responseData = responseMessage.getBytes();
            DatagramPacket responsePacket = new DatagramPacket(responseData, responseData.length, clientAddress, clientPort);
            socket.send(responsePacket);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
