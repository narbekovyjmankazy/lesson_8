package kg.geeks.game.logic;

import kg.geeks.game.players.*;

import java.util.Random;

public class RPG_Game {
    public static Random random = new Random();
    private static int roundNumber;

    public static void startGame() {

        Boss boss = new Boss("Skeleton", 1000, 50);
        Warrior warrior1 = new Warrior("Knight", 280, 10);
        Warrior warrior2 = new Warrior("Ahiles", 290, 10);
        Magic magic = new Magic("Skymag", 270, 10);
        Medic doc = new Medic("Dumbledor", 280, 5, 15);
        Medic assistant = new Medic("Shaman", 270, 5, 5);
        Berserk berserk = new Berserk("Guts", 280, 15);

        Hero[] heroes = {warrior1, doc, warrior2, magic, berserk, assistant};

        showStatistics(boss, heroes);
        while (!isGameOver(boss, heroes)) {
            playRound(boss, heroes);
        }
    }

    private static void playRound(Boss boss, Hero[] heroes) {
        roundNumber++;
        boss.chooseDefence();
        boss.attack(heroes);
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0 && boss.getHealth() > 0 &&
                    hero.getAbility() != boss.getDefence()) {
                hero.attack(boss);
                hero.applySuperPower(boss, heroes);
            }
        }
        showStatistics(boss, heroes);
    }

    private static boolean isGameOver(Boss boss, Hero[] heroes) {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won!!!");
            return true;
        }
        boolean allHeroesDead = true;
        for (Hero hero : heroes) {
            if (hero.getHealth() > 0) {
                allHeroesDead = false;
                break;
            }
        }
        if (allHeroesDead) {
            System.out.println("Boss won!!!");
            return true;
        }
        return false;
    }

    private static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -------------");
        System.out.println(boss);
        for (Hero hero : heroes) {
            System.out.println(hero);
        }
    }
}
