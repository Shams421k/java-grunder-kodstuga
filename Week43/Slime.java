package Week43;

import java.util.Random;

public class Slime extends Monster {

    Random random = new Random();

    public Slime() {
        super("Slime");
    }

    @Override
    public int attack() {
        return random.nextInt(16) + 10;
    }
}