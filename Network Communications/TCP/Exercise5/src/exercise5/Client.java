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

public class Client {
    public static void main(String[] args) {
        try {
            // Create a Student object with client-supplied data
            Student studentToSend = new Student("John Doe", 20, 10.5f);

            // Open a socket connection to the server
            Socket socket = new Socket("localhost", 5555);

            // Set up object streams for communication
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream objectInputStream = new ObjectInputStream(socket.getInputStream());

            // Send the Student object to the server
            objectOutputStream.writeObject(studentToSend);

            // Receive the Student object with assigned id from the server
            Student receivedStudent = (Student) objectInputStream.readObject();

            // Display the received Student data on the client console
            System.out.println("Received from server: " + receivedStudent);

            // Close the connection
            socket.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
