package filosofo;

public class Cena {
    public static void main(String[] args) {
        Palillo p1 = new Palillo();
        Palillo p2 = new Palillo();
        Palillo p3 = new Palillo();
        Palillo p4 = new Palillo();
        Palillo p5 = new Palillo();
        Filosofo th1 = new Filosofo(p1, p2);
        Filosofo th2 = new Filosofo(p2, p3);
        Filosofo th3 = new Filosofo(p3, p4);
        Filosofo th4 = new Filosofo(p4, p5);
        Filosofo th5 = new Filosofo(p5, p1);
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        th5.start();

    }
}
