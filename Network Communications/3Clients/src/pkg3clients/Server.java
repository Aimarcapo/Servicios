package pkg3clients;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of clients (N): ");
        int numClients = scanner.nextInt();
        scanner.close();

        try (ServerSocket serverSocket = new ServerSocket(12345)) {
            System.out.println("Server is running...");

            for (int i = 0; i < numClients; i++) {
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client " + (i + 1) + " connected.");

                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                out.println("You are client number " + (i + 1));
                
                Thread clientHandler = new ClientHandler(clientSocket, i + 1);
                clientHandler.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class ClientHandler extends Thread {
        private Socket clientSocket;
        private int clientNumber;

        ClientHandler(Socket socket, int clientNumber) {
            this.clientSocket = socket;
            this.clientNumber = clientNumber;
        }

        public void run() {
            try {
                Scanner in = new Scanner(clientSocket.getInputStream());
                while (in.hasNextLine()) {
                    String message = in.nextLine();
                    System.out.println("Message from Client " + clientNumber + ": " + message);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
