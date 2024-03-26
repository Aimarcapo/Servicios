/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filosofo;

import java.util.Random;

/**
 *
 * @author aimar
 */
public class Filosofo extends Thread {
        private final int id;
    private final Palillo leftPalillo;
    private final Palillo rightPalillo;
    private final Random random = new Random();

    public Filosofo(int id, Palillo leftPalillo, Palillo rightPalillo) {
        this.id = id;
        this.leftPalillo = leftPalillo;
        this.rightPalillo = rightPalillo;
    }

    private void piensa() throws InterruptedException {
        System.out.println("Filosofo " + id + " esta pensando");
        Thread.sleep(random.nextInt(1000)); // Simulating thinking
    }

    private void come() throws InterruptedException {
        leftPalillo.coge();
        rightPalillo.coge();

        System.out.println("Filosofo " + id + " esta comiendo");
        Thread.sleep(random.nextInt(1000)); // Simulating eating

        leftPalillo.deja();
        rightPalillo.deja();
    }

    @Override
    public void run() {
        try {
            while (true) {
                piensa();
                come();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

}
