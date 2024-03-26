package udp;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
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
public class SendingPrimitiveData {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket();

int intValue = 42;
float floatValue = 3.14f;
char charValue = 'A';

ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
DataOutputStream dataOutput = new DataOutputStream(byteStream);//Encapsulate
// Write to the stream
dataOutput.writeInt(intValue);
dataOutput.writeFloat(floatValue);
dataOutput.writeChar(charValue);

byte[] data = byteStream.toByteArray();

InetAddress serverAddress = InetAddress.getByName("localhost");//Server in localhost
int serverPort = 12345;

DatagramPacket packet = new DatagramPacket(data, data.length, serverAddress, serverPort);
socket.send(packet);
    }
}
