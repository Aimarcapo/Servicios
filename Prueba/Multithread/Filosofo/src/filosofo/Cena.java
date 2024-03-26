package filosofo;

public class Cena {
    public static void main(String[] args) {
        Palillo[] palillos = new Palillo[5];
        Filosofo[] filosofos = new Filosofo[5];

        for (int i = 0; i < 5; i++) {
            palillos[i] = new Palillo(i);
        }

        for (int i = 0; i < 5; i++) {
            filosofos[i] = new Filosofo(i, palillos[i], palillos[(i + 1) % 5]);
            filosofos[i].start();
        }
    }
}
