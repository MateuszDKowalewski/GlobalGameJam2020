package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;

public class DatePlace extends Location
{
    MapLocation exit;
    MapLocation date;
    private int romantic;
    private int food;
    private int money;

    public DatePlace(GameManager gm, String path, int romantic, int food, int money)
    {
        super(gm, path);
        this.romantic = romantic;
        this.food = food;
        this.money = money;
        exit = new MapLocation(gm, "exit.png", 1027, 19);
        exit.setOnClick(new Runnable() {
            @Override
            public void run()
            {
                gm.setLocation(CurrentLocation.CITY);
            }
        });
        date = new MapLocation(gm, "date_button.png", 619, 400);
        date.setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("DATE!!!!");
            }
        });
    }

    public void calculate(Runnable r) {
        date.setOnClick(r);
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        exit.isClicked(gc);
        date.isClicked(gc);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
        renderer.drawImage(exit.getIcon(), (int)exit.x, (int)exit.y);
        renderer.drawImage(date.getIcon(), (int)date.x, (int)date.y);
    }

    public int getRomantic() {
        return romantic;
    }

    public int getFood() {
        return food;
    }

    public int getMoney() {
        return money;
    }
}

