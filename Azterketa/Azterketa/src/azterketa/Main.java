/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package azterketa;

/**
 *
 * @author aimar
 */
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean validar = false;
        int numberOfCustomers;
        do {
            System.out.println("Enter the number of customers (must be a multiple of 3):");
            numberOfCustomers = scanner.nextInt();

            if (numberOfCustomers % 3 != 0) {
                System.out.println("Number of customers must be a multiple of 3.");

            } else {
                validar = true;
            }
        } while (!validar);

        int numberOfChefs = numberOfCustomers / 3;

        Restaurante restaurant = new Restaurante(numberOfChefs);

        // Creating chefs
        String[] chefTypes = {"sushi", "pasta", "marmitako"};
        for (int i = 0; i < numberOfChefs; i++) {
            Cocinero chef = new Cocinero(chefTypes[i%3], restaurant);
            chef.setName("Chef " + (i + 1) + " - " + chefTypes[i%3]);
            restaurant.assignChef(i, chef);
            chef.start();
        }

        // Creating customers
        for (int i = 0; i < numberOfCustomers; i++) {
            Cliente cliente = new Cliente(restaurant);
            cliente.setName("Customer " + (i + 1));
            cliente.start();
        }
    }

}
