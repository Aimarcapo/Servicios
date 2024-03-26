/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package exercise1;

/**
 *
 * @author aimar
 */
public class Exercise1 extends Thread {
private int n;
public Exercise1(int n){
    this.n=n;
}
@Override
public void run(){
    int first=1;
    int second=1;
         System.out.println("Fibonacci Sequence for N=" + n + ":");
        System.out.print(first+" "+second+" ");
        for(int i=2;i<n;i++){
            int next=first+second;
            System.out.print(next+" ");
            first=second;
            second=next;
          
        }
}
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int N=10;
        Exercise1 fibonacci=new Exercise1(N);
        fibonacci.start();
        
        // TODO code application logic here
    }
    
}
