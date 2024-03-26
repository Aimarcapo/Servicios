/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unai.exercises;







public class Philosopher implements Runnable {
    private Object leftFork;
    private Object rightFork;

    public Philosopher(Object leftFork, Object rightFork){
        this.leftFork = leftFork;
        this.rightFork = rightFork;
    }

    private void doAction(String action) throws InterruptedException{
        System.out.println(Thread.currentThread().getName() + " " + action);
        Thread.sleep((int) Math.random() * 100);
    }

    @Override
    public void run(){
        try{
            while(true){
                //Think
                doAction(System.nanoTime() + ": Thinking");
                synchronized(leftFork){
                    doAction(System.nanoTime() + ": Picked up left fork.");

                    synchronized(rightFork){
                        doAction(System.nanoTime() + ": Picked up right fork - eating");

                        doAction(System.nanoTime() + ": Put down right fork");
                    }

                    doAction(System.nanoTime() + ": Put down left fork - thinking again");
                }
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        //Create array of 5 philosophers
        Philosopher[] philosophers = new Philosopher[5];

        //Create array of 5 Objects(forks)
        Object[] forks = new Object[philosophers.length];

        //Instance the 5 forks and put them in the array
        for(int i = 0; i < forks.length; i++){
            forks[i] = new Object();
        }

        //Instance the objects and start the threads
        for (int i = 0; i < philosophers.length; i++){
            Object leftFork = forks[i];
            Object rightFork = forks[i];

            philosophers[i] = new Philosopher(leftFork, rightFork);

            Thread t = new Thread(philosophers[i], "Philosopher " + (i + 1));
            t.start();
        }
    }
}
