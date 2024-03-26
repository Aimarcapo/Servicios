/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package azterketa2ariketa;

import java.util.Scanner;
import java.util.concurrent.Semaphore;

/**
 *
 * @author aimar
 */
public class Azterketa2Ariketa {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         
       Scanner scanner = new Scanner(System.in);
        boolean validar = false;
        int numberOfCustomers;
        do {
            System.out.println("Enter the number of customers :");
            numberOfCustomers = scanner.nextInt();

            if (numberOfCustomers < 9 ) {
                System.out.println("Number of customers must bigger than the the amount of chefs multiplied by 3");

            } else {
                validar = true;
            }
        } while (!validar);

      Restaurant restaurant = new Restaurant();
       

        for (int i = 1; i <= numberOfCustomers; i++) {
            String[] dishes = {"sushi", "pasta", "marmitako"};
            int randomDish = (int) (Math.random() * dishes.length);
            Client customer = new Client(restaurant, dishes[randomDish], i);
            customer.start();
        }

        scanner.close();
        }
    }
    

