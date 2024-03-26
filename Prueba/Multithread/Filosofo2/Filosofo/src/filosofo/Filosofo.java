/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package filosofo;

/**
 *
 * @author aimar
 */
public class Filosofo extends Thread {
    private Palillo palillo_izquierdo;
    private Palillo palillo_derecho;

    public Filosofo(Palillo palillo_izquierdo, Palillo palillo_derecho) {
        this.palillo_izquierdo = palillo_izquierdo;
        this.palillo_derecho = palillo_derecho;

    }

    private void pensar() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " esta pensando");
        Thread.sleep((int) Math.random() * 100);
    }

    private void comer() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " esta comiendo");
        Thread.sleep((int) Math.random() * 100);
    }

    private synchronized void empezarAcomer() throws InterruptedException {
       
        synchronized (palillo_izquierdo) {
            System.out.println(Thread.currentThread().getName() + " coge palillo izquierdo");
            synchronized (palillo_derecho) {
                System.out.println(Thread.currentThread().getName() + " coge palillo derecho");
                comer();

            }

        }
    }

    @Override
    public void run() {

        while (true) {
            try {
                pensar();
                empezarAcomer();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

}
