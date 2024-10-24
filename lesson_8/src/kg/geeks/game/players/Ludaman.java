package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Ludaman extends Hero{
    public Ludaman(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.LUCK);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        int first = RPG_Game.random.nextInt(6)+1;
        int second = RPG_Game.random.nextInt(6)+1;

        for (int i = 0; i <heroes.length ; i++) {
            if (first == second){
                int result = first*second;
                boss.setHealth(getHealth()-result);
                System.out.println("Ludaman hit boss = " + this.getDamage());
                break;
            }
            else {
                int result2 = first + second;
                for(Hero hero : heroes){
                    hero.setHealth(hero.getHealth()-result2);
                    System.out.println("Ludaman hit his teammates = " + this.getDamage());
                    break;
                }
            }
            break;
        }
    }
}
