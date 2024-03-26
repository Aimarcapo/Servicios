/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package eus.alonso.aimar.fibonaccithread;

/**
 *
 * @author aimar
 */
public class FibonacciThread extends Thread {
 private int n;

    public FibonacciThread(int n) {
        this.n = n;
    }

    @Override
    public void run() {
        int first = 1;
        int second = 1;

        System.out.println("Fibonacci Sequence for N=" + n + ":");
        System.out.print(first + " " + second + " ");

        for (int i = 2; i < n; i++) {
            int next = first + second;
            System.out.print(next + " ");
            first = second;
            second = next;
        }
    }

    public static void main(String[] args) {
        int N = 10; // Specify the number of Fibonacci numbers to calculate

        FibonacciThread fibonacciThread = new FibonacciThread(N);
        fibonacciThread.start();
    }
}
