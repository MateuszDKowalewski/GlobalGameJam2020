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
    public DatePlace(GameManager gm, String path)
    {
        super(gm, path);
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
}

