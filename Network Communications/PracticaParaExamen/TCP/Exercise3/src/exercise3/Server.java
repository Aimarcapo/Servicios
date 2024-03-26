/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author aimar
 */
import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) {
        int port = 12345; // Puedes elegir cualquier puerto disponible
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Servidor escuchando en el puerto " + port + "...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Cliente conectado: " + clientSocket.getInetAddress());

                // Configura flujos de entrada y salida para el socket del cliente
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);

                // Recibe nombre y edad del cliente
                String name = in.readLine();
                int age = Integer.parseInt(in.readLine());

                // Verifica la edad legal y envía la respuesta al cliente desde el main
                if (age >= 18) {
                    String response = name + ", eres mayor de edad con " + age;
                    out.println(response);
                } else {
                    String response = name + " que tiene " + age + " años, no eres mayor de edad.";
                    out.println(response);
                }

                // Cierra la conexión con el cliente
                clientSocket.close();
                System.out.println("Conexión con el cliente cerrada.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
