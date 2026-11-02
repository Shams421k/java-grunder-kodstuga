package Week43;

import java.util.Random;

public class Dragon extends Monster implements SpecialAttack {

    Random random = new Random();

    public Dragon() {
        super("Dragon");
    }

    @Override
    public int attack() {
        return random.nextInt(11) + 10;
    }

    @Override
    public int useSpecialAttack() {
        System.out.println("Dragon använder ELDKLOT!");
        return random.nextInt(11) + 20;
    }
}