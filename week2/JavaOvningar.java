package week2;
import java.util.Scanner;
public class JavaOvningar {

    public static void main(String[] args) {


        ovning1();
        ovning2();
        ovning3();
        ovning4();
        ovning5();

    }


    // 1
    static void ovning1() {
        int age = 90;
        int height = 150;

        if (age < 12) {
            System.out.println("Du är för ung för att åka.");
        } else if (age > 80) {
            System.out.println("Du är för gammal för att åka.");
        } else if (height < 140) {
            System.out.println("Du är gammal nog, men för kort.");
        } else if (height > 200) {
            System.out.println("Du är gammal nog, men för lång.");
        } else {
            System.out.println("Du får åka!");
        }
    }


    // 2
    static void ovning2() {
        //int choice = 3;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Välj en maträtt:");
        System.out.println("1. Pizza");
        System.out.println("2. Tacos");
        System.out.println("3. Hamburgare");
        System.out.println("4. Sushi");

        int choice = scanner.nextInt();


        switch (choice) {
            case 1:
                System.out.println("Pizza");
                break;
            case 2:
                System.out.println("Tacos");
                break;
            case 3:
                System.out.println("Hamburgare");
                break;
            case 4:
                System.out.println("Sushi");
                break;
            default:
                System.out.println("Ogiltigt val.");
        }
    }



    // 3
    static void ovning3() {
        for (int i = 10; i >= 1; i--) {

            if (i == 5) {
                continue;
            }

            System.out.println(i);
        }

        System.out.println("LIFTOFF!");
    }



    // 4
    static void ovning4() {
        Djur hund = new Djur("Bosse", 4, "Voff!"); //steg 1
        Djur katt = new Djur("Maja", 2, "Mjau!"); //steg 3

        System.out.println(hund.namn + " är " + hund.alder + " år."); //steg 5
        hund.gorLjud();

        System.out.println(katt.namn + " är " + katt.alder + " år."); // steg 7
        katt.gorLjud();
    }

    static class Djur {
        String namn;
        int alder;
        String ljud;

        //Konstruktor
        Djur(String namn, int alder, String ljud) { //steg2 och 4
            this.namn = namn;
            this.alder = alder;
            this.ljud = ljud;
        }

        void gorLjud() {
            System.out.println(namn + " säger: " + ljud); //steg 6 och 8
        }
    }



    // 5
    static void ovning5() {
        Monster monster = new Monster("Göran", 100); // Steg 1

        for (int runda = 1; runda <= 10; runda++) { // Steg 3
            System.out.println("Runda " + runda);

            monster.health = monster.health - 20; // Steg 4
            System.out.println( // Steg 5
                monster.namn + " har " + monster.health + " health kvar."
            );

            if (monster.health <= 0) { // Steg 6
                System.out.println(monster.namn + " är besegrad!");
                break;
            }
        }
    }

    static class Monster {
        String namn;
        int health;

        Monster(String namn, int health) { // Steg 2
            this.namn = namn;
            this.health = health;
        }
    }
}
