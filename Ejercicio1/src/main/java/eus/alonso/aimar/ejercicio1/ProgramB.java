package eus.alonso.aimar.ejercicio1;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author aimar
 */
public class ProgramB {
    public static void main(String[] args) throws IOException {
        // Runtime runtime = Runtime.getRuntime();
        // Process process = runtime.exec("ProgramA"); DEPRECATED

        try {
            // Compile and run program A
            ProcessBuilder processBuilder = new ProcessBuilder("java", "ProgramA");
            Process process = processBuilder.start();

            Writer writer = new BufferedWriter(new OutputStreamWriter(process.getOutputStream()));

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            System.out.print("Enter Program B string: ");

            // Pass a string to program A
            String inputString = bufferedReader.readLine();
            writer.write(inputString);
            writer.flush();
            writer.close();

            // Read and print the output of program A
            InputStream inputStream = process.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
