/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 *
 * @author aimar
 */
public class Client {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws UnknownHostException, IOException {
        final int serverPort = 12345;
        InetAddress serverAddress = InetAddress.getLocalHost();
        try {
            Socket socket = new Socket(serverAddress, serverPort);

            // Configura flujos de entrada y salida para el socket
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);

            // Utiliza Scanner para recibir nombre y edad del usuario
            Scanner scanner = new Scanner(System.in);

            System.out.print("Ingrese su nombre: ");
            String name = scanner.next();

            System.out.print("Ingrese su edad: ");
            int age = scanner.nextInt();

            // Envía nombre y edad al servidor
            out.println(name);
            out.println(age);

            // Recibe e imprime la respuesta del servidor
            String response = in.readLine();
            System.out.println("Respuesta del servidor: " + response);

            // Cierra la conexión con el servidor
            socket.close();
            System.out.println("Conexión con el servidor cerrada.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
