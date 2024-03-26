/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketa2ariketa;

import java.util.concurrent.Semaphore;

/**
 *
 * @author aimar
 */
public class Restaurant {
      private Semaphore sushiChef = new Semaphore(1);
    private Semaphore pastaChef = new Semaphore(1);
    private Semaphore marmitakoChef = new Semaphore(1);

    public void order(String dish, int customerNumber) {
        try {
            switch (dish) {
                case "sushi":
                    sushiChef.acquire();
                    System.out.println("Customer " + customerNumber + " ordered sushi.");
                    prepareDish("Sushi", customerNumber);
                    sushiChef.release();
                    break;
                case "pasta":
                    pastaChef.acquire();
                    System.out.println("Customer " + customerNumber + " ordered pasta.");
                    prepareDish("Pasta", customerNumber);
                    pastaChef.release();
                    break;
                case "marmitako":
                    marmitakoChef.acquire();
                    System.out.println("Customer " + customerNumber + " ordered marmitako.");
                    prepareDish("Marmitako", customerNumber);
                    marmitakoChef.release();
                    break;
                default:
                    System.out.println("Invalid dish ordered by customer " + customerNumber);
                    break;
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    private void prepareDish(String dish, int customerNumber) throws InterruptedException {
        System.out.println("Chef preparing " + dish + " for customer " + customerNumber);
        Thread.sleep(2000); // Simulating dish preparation time
        System.out.println(dish + " prepared for customer " + customerNumber);
    }
}
