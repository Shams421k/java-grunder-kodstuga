
package Week44;

import java.util.Scanner;
import java.util.InputMismatchException;

public class RobotCafe {

    static final int MIN_ROBOT_CODE = 1000;
    static final int MAX_ROBOT_CODE = 9999;
    static final int EXIT_CHOICE = 0;

    static final String[] PRODUCTS = {
        "Kaffe", "Te", "Bulle", "Energidryck"
    };

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Välkommen till Robotcafé!");

        boolean running = true;

        while (running) {

            printMenu();

            int choice = readNumber("Välj en produkt: ");

            if (choice == EXIT_CHOICE) {
                System.out.println("Tack för besöket!");
                running = false;
            } else if (choice < 1 || choice > PRODUCTS.length) {
                System.out.println("Ogiltigt val. Försök igen.");
            } else {
                placeOrder(choice);
            }
        }

        scanner.close();
    }

    static void printMenu() {
        System.out.println("\n=== ROBOTCAFÉ ===");

        for (int i = 0; i < PRODUCTS.length; i++) {
            System.out.println((i + 1) + ". " + PRODUCTS[i]);
        }

        System.out.println("0. Avsluta");
    }

    static int readNumber(String message) {

        while (true) {
            System.out.print(message);

            try {
                int number = scanner.nextInt();
                scanner.nextLine();
                return number;

            } catch (InputMismatchException e) {
                System.out.println("Fel! Du måste skriva ett heltal.");
                scanner.nextLine();
            }
        }
    }

    static void placeOrder(int choice) {

        String product = PRODUCTS[choice - 1];

        System.out.println("Du har beställt: " + product);

        int robotCode = readNumber("Ange din fyrsiffriga robotkod: ");

        try {
            validateRobotCode(robotCode);
            System.out.println("Robotkoden är godkänd!");
            System.out.println("Din beställning är klar!");

        } catch (IllegalArgumentException e) {
            System.out.println("Felaktig robotkod: " + e.getMessage());
        }
    }

    static void validateRobotCode(int code) {

        if (code < MIN_ROBOT_CODE || code > MAX_ROBOT_CODE) {
            throw new IllegalArgumentException(
                "Koden måste innehålla exakt fyra siffror."
            );
        }
    }
}
