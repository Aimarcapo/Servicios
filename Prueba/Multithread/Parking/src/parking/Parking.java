/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package parking;

/**
 *
 * @author aimar
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ParkingLot {
    private final int totalSpaces;
    private int availableSpaces;
    private final List<Boolean> parkingSpaces;
    private final Object lock = new Object();

    ParkingLot(int totalSpaces, int existingCars) {
        this.totalSpaces = totalSpaces;
        this.availableSpaces = totalSpaces - existingCars;
        this.parkingSpaces = new ArrayList<>(totalSpaces);
        for (int i = 0; i < totalSpaces; i++) {
            parkingSpaces.add(false);
        }
    }

    void vehicleEnter(int vehicleId) throws InterruptedException {
        while (true) {
            synchronized (lock) {
                while (availableSpaces <= 0) {
                    System.out.println("Vehicle " + vehicleId + " waiting at entrance.");
                    lock.wait();
                }

                int parkingSpaceIndex = findEmptyParkingSpace();
                parkingSpaces.set(parkingSpaceIndex, true);
                availableSpaces--;

                System.out.println("Vehicle " + vehicleId + " parked at space " + parkingSpaceIndex +
                        ". Available spaces: " + availableSpaces);

                lock.notifyAll();
            }

            // Simulate time inside parking
            Thread.sleep(new Random().nextInt(800) + 300);

            synchronized (lock) {
                parkingSpaces.set(findParkingSpaceOfVehicle(vehicleId), false);
                availableSpaces++;

                System.out.println("Vehicle " + vehicleId + " left space. Available spaces: " + availableSpaces);

                lock.notifyAll();
            }

            // Simulate time outside parking before re-entering
            Thread.sleep(new Random().nextInt(1500) + 500);
        }
    }

    private int findEmptyParkingSpace() {
        for (int i = 0; i < totalSpaces; i++) {
            if (!parkingSpaces.get(i)) {
                return i;
            }
        }
        return -1;
    }

    private int findParkingSpaceOfVehicle(int vehicleId) {
        for (int i = 0; i < totalSpaces; i++) {
            if (parkingSpaces.get(i) && parkingSpaces.get(i).equals(true)) {
                return i;
            }
        }
        return -1;
    }
}

public class Parking {
    public static void main(String[] args) {
        int totalSpaces = 5;
        int existingCars = 2;

        ParkingLot parkingLot = new ParkingLot(totalSpaces, existingCars);

        // Simulating existing cars
        int numCars = existingCars;
        for (int i = 0; i < numCars; i++) {
            final int vehicleId = i;
            new Thread(() -> {
                try {
                    parkingLot.vehicleEnter(vehicleId);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        }

        // Keep the main thread running indefinitely
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

