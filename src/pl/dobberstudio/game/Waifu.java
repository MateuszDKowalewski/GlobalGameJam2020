package pl.dobberstudio.game;

public class Waifu
{
    private int romantic;
    private int food;
    private int look;
    private int body;
    private int money;
    private int charisma;
    private String name;
    private String description;
    Waifu(String name, String description, int romantic, int food, int look, int body, int charisma, int money)
    {
        this.romantic = romantic;
        this.food = food;
        this.look = look;
        this.body = body;
        this.money = money;
        this.description = description;
        this.name = name;
        this.charisma = charisma;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public int getRomantic() {
        return romantic;
    }

    public int getFood() {
        return food;
    }

    public int getLook() {
        return look;
    }

    public int getBody() {
        return body;
    }

    public int getMoney() {
        return money;
    }

    public int getCharisma() {
        return charisma;
    }
}
