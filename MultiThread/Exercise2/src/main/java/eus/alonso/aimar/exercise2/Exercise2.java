package eus.alonso.aimar.exercise2;

import java.text.NumberFormat;

public class Exercise2 {
    public static void main(String[] args) {
        final int N = 1000000;
        final int numThreads = 4;
        long totalSum = 0;

        Thread[] threads = new Thread[numThreads];
        SumThread[] sumThreads = new SumThread[numThreads];

        // Create the threads
        for (int i = 0; i < numThreads; i++) {
            int start = i * (N / numThreads) + 1;//We calculate the first number for each thread
            int end = (i + 1) * (N / numThreads);//We calculate the last number for each thread;
            sumThreads[i] = new SumThread(start, end);//Create the array with range of numbers(the minimum for that thread and the maximum for that thread)
            threads[i] = new Thread(sumThreads[i]);//We insert that range of numbers array for each thread;
            threads[i].start();//We start that thread
        }

        // Wait for all threads to finish
        for (int i = 0; i < numThreads; i++) {
            //To use join() we need try and catch
            try {
                threads[i].join();//We use it to wait for each thread to finish its work and then we continue
                totalSum += sumThreads[i].getPartialSum();//get the partial sum of each thread and add it to the total sum
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
//Once all threads have finished and their partial sums are added to totalSum,we format the total sum to have comas
       NumberFormat numberFormat = NumberFormat.getInstance();
        String formattedTotalSum = numberFormat.format(totalSum);

        System.out.println("Total Sum: " + formattedTotalSum);
    }
}

class SumThread implements Runnable {//what will execute each thread;
    private int start;
    private int end;
    private long partialSum;

    public SumThread(int start, int end) {//Constructo
        this.start = start;
        this.end = end;
        this.partialSum = 0;
    }

    @Override
    public void run() {//thread´s code;
        for (int i = start; i <= end; i++) {
            partialSum += i;
        }
    }

    public long getPartialSum() {//Getter to get the partialSum
        return partialSum;
    }
}