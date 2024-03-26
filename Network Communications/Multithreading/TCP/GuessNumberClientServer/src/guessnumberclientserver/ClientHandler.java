package guessnumberclientserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler extends Thread {

    private Socket clientSocket;
    private int targetNumber;
    private int round;
    private boolean alguienHaAcertado;
    private boolean haRespondido;

    public ClientHandler(Socket clientSocket, int targetNumber) {
        this.clientSocket = clientSocket;
        this.targetNumber = targetNumber;
        this.round = 0;
        this.alguienHaAcertado = false;
        this.haRespondido = false;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
        this.haRespondido = false; // Reset response flag for the new round
    }

    public boolean isAlguienHaAcertado() {
        return alguienHaAcertado;
    }

    public void setAlguienHaAcertado(boolean alguienHaAcertado) {
        this.alguienHaAcertado = alguienHaAcertado;
    }

    public boolean haRespondido() {
        return haRespondido;
    }

    public void run() {
        try {
            InputStream inputStream = clientSocket.getInputStream();
            OutputStream outputStream = clientSocket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            PrintWriter writer = new PrintWriter(outputStream, true);

            while (!alguienHaAcertado) {
                String clientMessage = reader.readLine();
                try {
                    int guess = Integer.parseInt(clientMessage);
                    if (guess == targetNumber) {
                        writer.println("y|" + round);
                        System.out.println("Client Guessed Right in round " + round);
                        alguienHaAcertado = true;
                        break;
                    } else {
                        writer.println("n|" + round);
                    }
                    haRespondido = true; // Set the response flag
                } catch (NumberFormatException e) {
                    writer.println("Invalid input. Please send a valid number.");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (clientSocket != null) {
                try {
                    clientSocket.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
}
