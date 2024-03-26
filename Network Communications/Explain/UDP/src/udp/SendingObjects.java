package udp;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aimar
 */
public class SendingObjects {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

MyObject myObject = new MyObject(); // Assume you have a class MyObject

ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
ObjectOutputStream objectOutput = new ObjectOutputStream(byteStream);

// Write the object to the stream
objectOutput.writeObject(myObject);

byte[] data = byteStream.toByteArray();

InetAddress serverAddress = InetAddress.getByName("localhost");//Server in localhost
int serverPort = 12345;

DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
socket.send(packet);
    }
}
class MyObject  {

    private String message;

    public MyObject() {
    }

    public MyObject(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}