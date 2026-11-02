package Week43;

public abstract class Monster {
    String namn;
    int hp;

    public Monster(String namn) {
        this.namn = namn;
        this.hp = 100;
    }

    public abstract int attack();

    public boolean lever() {
        return hp > 0;
    }

    public void taSkada(int skada) {
        hp -= skada;

        if (hp < 0) {
            hp = 0;
        }
    }

    public void resetHp() {
        hp = 100;
    }
}