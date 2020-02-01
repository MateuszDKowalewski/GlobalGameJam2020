package pl.dobberstudio.game;

import pl.dobberstudio.game.eq.Equipment;
import pl.dobberstudio.game.eq.Flowers;
import pl.dobberstudio.game.eq.Food;

public class Character {
    public static int MAX_LOOK = 100;
    public static int MAX_BODY = 100;
    public static int MAX_CHARISMA = 100;
    public static int MAX_HUNGER = 100;
    public static int MAX_TIREDNESS = 100;

    private Equipment equipment;

    private int look;
    private int body;
    private int charisma;

    private int hunger;
    private int tiredness;
    private int money;

    public Character() {
        look = 0;
        body = 0;
        charisma = 0;
        hunger = MAX_HUNGER;
        tiredness = MAX_TIREDNESS;
        money = 50;
        equipment = new Equipment();
    }

    public void trainOnGym() {
        body += 5;
        look += 1;
        charisma += 1;
        tiredness -= 15;
        hunger -= 15;

        if(body > MAX_BODY) {
            body = MAX_BODY;
        }

        if(look >MAX_LOOK) {
            look = MAX_LOOK;
        }

        if(this.hunger < 0) {
            hunger = 0;
        }

        if(this.tiredness < 0) {
            this.tiredness = 0;
        }

        if(this.charisma > MAX_CHARISMA) {
            this.charisma = MAX_CHARISMA;
        }
    }

    public void workInRopuch(int money) {
        this.money += money;
        this.hunger -= 10;
        this.tiredness -= 10;
        this.charisma += 5;

        if(this.hunger < 0) {
            hunger = 0;
        }

        if(this.tiredness < 0) {
            this.tiredness = 0;
        }

        if(this.charisma > MAX_CHARISMA) {
            this.charisma = MAX_CHARISMA;
        }
    }

    public void addFood(Food food, int amount) {
        equipment.addFood(food, amount);
    }

    public void addFlowers(Flowers flower, int amount) {
        equipment.addFlowers(flower, amount);
    }

    public void eat(int hunger) {
        this.hunger += hunger;
    }

    public int getLook() {
        return look;
    }

    public int getBody() {
        return body;
    }

    public int getCharisma() {
        return charisma;
    }

    public int getHunger() {
        return hunger;
    }

    public int getTiredness() {
        return tiredness;
    }

    public int getMoney() {
        return money;
    }

    public static int getMaxLook() {
        return MAX_LOOK;
    }

    public static int getMaxBody() {
        return MAX_BODY;
    }

    public static int getMaxCharisma() {
        return MAX_CHARISMA;
    }

    public static int getMaxHunger() {
        return MAX_HUNGER;
    }

    public static int getMaxTiredness() {
        return MAX_TIREDNESS;
    }

    @Override
    public String toString() {
        return "Character{" +
                "equipment=" + equipment +
                '}';
    }
}
