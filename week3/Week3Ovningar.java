
package week3;

public class Week3Ovningar {

    // Övning 5
    enum Superkraft {
        ELD, IS, VIND, BLIXT
    }

    public static void main(String[] args) {

        // Övning 1
        halsa("Alex");
        halsa("Sara");
        halsa("Erik");

        System.out.println("Robotens favoritnummer är " + favoritNummer());

        // Övning 2
        int totalPris = raknaPris(10, 3);
        System.out.println("Totalt pris: " + totalPris + " kr");

        int fastPris = raknaPris(8);
        System.out.println("Pris med fast styckpris: " + fastPris + " kr");

        // Övning 3
        String[] spelare = {"Messi", "Ronaldo", "Neymar", "Mbappe", "Haaland"};

        System.out.println("Första spelaren: " + spelare[0]);
        System.out.println("Sista spelaren: " + spelare[4]);

        spelare[2] = "Salah";

        for (int i = 0; i < spelare.length; i++) {
            System.out.println(spelare[i]);
        }

        System.out.println("Antal spelare i laget: " + spelare.length);

        // Extra utmaning
        for (String namn : spelare) {
            System.out.println(namn);
        }

        // Övning 4
        int[] guldKistor = {15, 40, 25, 80, 30};

        int totaltGuld = raknaGuld(guldKistor);
        System.out.println("Totalt antal guldmynt: " + totaltGuld);

        // Extra utmaning
        int storstaKistan = hittaStorstaKistan(guldKistor);
        System.out.println("Största guldmängden i en kista: " + storstaKistan);

        // Övning 5
        Superkraft spelarensKraft = Superkraft.BLIXT;

        switch (spelarensKraft) {
            case ELD:
                System.out.println("Du kan kasta eldklot!");
                break;
            case IS:
                System.out.println("Du kan frysa dina fiender!");
                break;
            case VIND:
                System.out.println("Du kan skapa kraftiga stormar!");
                break;
            case BLIXT:
                System.out.println("Du kan skjuta blixtar!");
                break;
        }

        // Extra utmaning
        System.out.println("Tillgängliga superkrafter:");

        for (Superkraft kraft : Superkraft.values()) {
            System.out.println(kraft);
        }

        // Övning 6 - Bygg ett litet spel
        Hjalte hjalte = new Hjalte();

        int[] poangLista = {10, 20, 5, 50, 15};

        int totalPoang = 0;

        for (int i = 0; i < poangLista.length; i++) {
            totalPoang += poangLista[i];
        }

        hjalte.setPoang(totalPoang);

        System.out.println("Hjältens totala poäng: " + hjalte.getPoang());

        // Extra utmaning
        int hogstaPoang = hittaHogstaPoang(poangLista);
        System.out.println("Högsta poängen i en runda: " + hogstaPoang);
    }

    // Övning 1
    static void halsa(String namn) {
        System.out.println("Hej " + namn + "! Jag är din robot!");
    }

    static int favoritNummer() {
        return 7;
    }

    // Övning 2
    static int raknaPris(int antal, int prisPerBit) {
        return antal * prisPerBit;
    }

    static int raknaPris(int antal) {
        return antal * 2;
    }

    // Övning 4
    static int raknaGuld(int[] kistor) {
        int summa = 0;

        for (int i = 0; i < kistor.length; i++) {
            summa += kistor[i];
        }

        return summa;
    }

    // Extra utmaning
    static int hittaStorstaKistan(int[] kistor) {
        int storsta = kistor[0];

        for (int i = 1; i < kistor.length; i++) {
            if (kistor[i] > storsta) {
                storsta = kistor[i];
            }
        }

        return storsta;
    }

    // Övning 6 - Klassen Hjalte
    static class Hjalte {
        private int poang;

        public int getPoang() {
            return poang;
        }

        public void setPoang(int poang) {
            this.poang = poang;
        }
    }

    // Extra utmaning - Hitta högsta poängen
    static int hittaHogstaPoang(int[] poangLista) {
        int hogsta = poangLista[0];

        for (int i = 1; i < poangLista.length; i++) {
            if (poangLista[i] > hogsta) {
                hogsta = poangLista[i];
            }
        }

        return hogsta;
    }
}
