package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Hacker extends Hero{
    private int stolenHealth;


    public Hacker(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.STEAL_HEAL);
    }
    public void setStolenHealth(int stolenHealth){
        this.stolenHealth = stolenHealth;
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for(Hero hero : heroes){
            stolenHealth = RPG_Game.random.nextInt(30)+5;
            boss.setHealth(boss.getHealth() - this.stolenHealth);
            hero.setHealth(getHealth() + this.stolenHealth);
            System.out.println("Hacker steal heal points = " + this.stolenHealth);
            break;
        }
    }
}
