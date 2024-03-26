/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package azterketa;


import java.util.concurrent.Semaphore;

/**
 *
 * @author aimar
 */
 class Restaurante {
  private final Semaphore[] chefSemaphores;
    private final Cocinero[] chefs;
    private final Semaphore orderSemaphore = new Semaphore(0);

    public Restaurante(int numberOfChefs) {
        chefSemaphores = new Semaphore[numberOfChefs];
        chefs = new Cocinero[numberOfChefs];

        for (int i = 0; i < numberOfChefs; i++) {
            chefSemaphores[i] = new Semaphore(0, true); // Fairness enabled
        }
        
    }

    public void makeOrder(String dish) {
        orderSemaphore.release();
    }

    public void prepareDish(String type) throws InterruptedException {
        orderSemaphore.acquire();

        for (Cocinero chef : chefs) {
            if (chef.getType().equals(type)) {
                System.out.println("Chef " + chef.getName() + " is preparing " + type);

                // Simulating cooking time
                Thread.sleep(2000);

                System.out.println("Chef " + chef.getName() + " has prepared " + type);

                chefSemaphores[chef.hashCode() % chefSemaphores.length].release();
                break;
            }
        }
          //orderSemaphore.release();
    }

    public void assignChef(int index, Cocinero chef) {
        chefs[index] = chef;
    }
}
