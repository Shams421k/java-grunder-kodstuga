package Week43;

import java.util.*;

public class MonsterArena {

    static Scanner scanner = new Scanner(System.in);

    static List<Monster> monsterLista = new ArrayList<>();
    static Map<String, Integer> topplista = new HashMap<>();
    static Set<String> monsterTyper = new HashSet<>();
    static Random random = new Random();

    public static void main(String[] args) {

        monsterLista.add(new Dragon());
        monsterLista.add(new Robot());
        monsterLista.add(new Slime());

        Collections.shuffle(monsterLista);

        for (Monster monster : monsterLista) {
            topplista.put(monster.namn, 0);
            monsterTyper.add(monster.namn);
        }

        boolean spela = true;

        while (spela) {
            System.out.println("\n=== MONSTER ARENA ===");
            System.out.println("1. Visa alla monster");
            System.out.println("2. Starta en match");
            System.out.println("3. Visa topplistan");
            System.out.println("4. Visa monstertyper");
            System.out.println("5. Avsluta");
            System.out.print("Välj: ");

            int val;

            try {
                val = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Skriv ett nummer mellan 1 och 5.");
                continue;
            }

            switch (val) {
                case 1:
                    visaMonster();
                    break;
                case 2:
                    startaMatch();
                    break;
                case 3:
                    visaTopplista();
                    break;
                case 4:
                    visaTyper();
                    break;
                case 5:
                    spela = false;
                    System.out.println("Spelet avslutas!");
                    break;
                default:
                    System.out.println("Ogiltigt val.");
            }
        }

        scanner.close();
    }

    // Visa alla monster
    static void visaMonster() {
        System.out.println("\nAlla monster:");

        for (Monster monster : monsterLista) {
            System.out.println(monster.namn + " - " + monster.hp + " HP");
        }
    }

    // Starta en match
    static void startaMatch() {

        System.out.println("\nVälj ditt monster:");

        for (int i = 0; i < monsterLista.size(); i++) {
            System.out.println((i + 1) + ". " + monsterLista.get(i).namn);
        }

        int val;

        try {
            val = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Ogiltigt val.");
            return;
        }

        if (val < 1 || val > monsterLista.size()) {
            System.out.println("Ogiltigt monster.");
            return;
        }

        Monster spelare = monsterLista.get(val - 1);

        List<Monster> motstandare = new ArrayList<>(monsterLista);
        motstandare.remove(spelare);

        Collections.shuffle(motstandare);
        Monster fiende = motstandare.get(0);

        spelare.resetHp();
        fiende.resetHp();

        System.out.println("\n" + spelare.namn + " VS " + fiende.namn);

        Queue<Monster> turordning = new LinkedList<>();
        turordning.add(spelare);
        turordning.add(fiende);

        int runda = 1;

        while (spelare.lever() && fiende.lever()) {

            Monster attackerare = turordning.poll();

            Monster forsvarare;

            if (attackerare == spelare) {
                forsvarare = fiende;
            } else {
                forsvarare = spelare;
            }

            System.out.println("\nRunda " + runda);

            int skada;

            if (attackerare instanceof SpecialAttack
                    && random.nextInt(4) == 0) {

                skada = ((SpecialAttack) attackerare).useSpecialAttack();

            } else {
                skada = attackerare.attack();
            }

            forsvarare.taSkada(skada);

            System.out.println(attackerare.namn + " attackerar "
                    + forsvarare.namn + " och gör " + skada + " skada!");

            System.out.println(forsvarare.namn + " har "
                    + forsvarare.hp + " HP kvar.");

            if (!forsvarare.lever()) {
                System.out.println("\n" + attackerare.namn + " VINNER!");

                int poang = topplista.get(attackerare.namn);
                topplista.put(attackerare.namn, poang + 3);

                break;
            }

            turordning.add(attackerare);
            runda++;
        }
    }

    // Visa topplistan
    static void visaTopplista() {
        System.out.println("\n=== TOPPLISTA ===");

        List<Map.Entry<String, Integer>> resultat =
                new ArrayList<>(topplista.entrySet());

        resultat.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : resultat) {
            System.out.println(entry.getKey() + ": "
                    + entry.getValue() + " poäng");
        }
    }

    // Visa unika monstertyper
    static void visaTyper() {
        System.out.println("\nMonstertyper:");

        for (String typ : monsterTyper) {
            System.out.println(typ);
        }
    }
}