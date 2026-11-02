package Week43;

import java.util.Random;

public class Robot extends Monster implements SpecialAttack {

    Random random = new Random();

    public Robot() {
        super("Robot");
    }

    @Override
    public int attack() {
        return random.nextInt(11) + 8;
    }

    @Override
    public int useSpecialAttack() {
        System.out.println("Robot använder LASER!");
        return random.nextInt(11) + 22;
    }
}