/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise5;

/**
 *
 * @author aimar
 */
import java.io.*;
import java.net.*;

public class Server {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(5555);
            System.out.println("Server is running and waiting for connections...");

            while (true) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress());

                // Handle client communication in a separate thread
                Thread clientThread = new Thread(new ClientHandler(clientSocket));
                clientThread.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class ClientHandler implements Runnable {
    private Socket clientSocket;

    public ClientHandler(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    @Override
    public void run() {
        try {
            // Set up object streams for communication
            ObjectInputStream objectInputStream = new ObjectInputStream(clientSocket.getInputStream());
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream());

            // Receive the Student object from the client
            Student receivedStudent = (Student) objectInputStream.readObject();

            // Assign an id to the Student object (you can implement your own logic here)
            receivedStudent.setId(generateUniqueId());

            // Send the Student object back to the client
            objectOutputStream.writeObject(receivedStudent);

            // Display the received Student data on the server console
            System.out.println("Received from client: " + receivedStudent);

            // Close the connection
            clientSocket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private static int uniqueIdCounter = 0;

    private synchronized int generateUniqueId() {
        return ++uniqueIdCounter;
    }
}
