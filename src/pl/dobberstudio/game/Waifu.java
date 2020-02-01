package pl.dobberstudio.game;

public class Waifu
{
    private int romantic;
    private int food;
    private int music;
    private int look;
    private int body;
    private int money;
    private String name;
    private String description;
    Waifu(int romantic, int food, int music, int look, int body, int money, String description, String name)
    {
        this.romantic = romantic;
        this.food = food;
        this.music = music;
        this.look = look;
        this.body = body;
        this.money = money;
        this.description = description;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
