package guessnumberclientserver;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) throws UnknownHostException, IOException {
        final int port = 12345;
        Scanner in = new Scanner(System.in);
        InetAddress serverAddress = InetAddress.getLocalHost();

        Socket socket = new Socket(serverAddress, port);
        InputStream inputStream = socket.getInputStream();
        OutputStream outputStream = socket.getOutputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        PrintWriter writer = new PrintWriter(outputStream, true);

        int round = 0;

        while (true) {
            System.out.println("Enter your guess (round " + (round + 1) + "):");
            int guess = in.nextInt();
            writer.println(guess);
            String serverResponse = reader.readLine();
            String[] respuesta = serverResponse.split("\\|"); // Corrected split delimiter
            round = Integer.parseInt(respuesta[1]);

            if (respuesta[0].equals("y")) {
                System.out.println("Congratulations you have guessed in round " + round);
                socket.close();
                break;
            } else {
                System.out.println("Round " + round + " sorry try it again.");
            }
        }
    }
}
