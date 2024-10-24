package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;

public class Deku extends Hero{
    public Deku(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.BOOST_PUNCH);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        for(Hero hero : heroes){
            int boost = RPG_Game.random.nextInt(30)+5;
            hero.setHealth(this.getHealth() - boost);
            hero.setDamage(this.getDamage() + boost);
            System.out.println("Deku punch = " + this.getDamage());
            break;
        }
    }
}
