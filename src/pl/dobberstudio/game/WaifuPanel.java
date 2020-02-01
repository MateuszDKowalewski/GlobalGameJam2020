package pl.dobberstudio.game;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.locations.Location;
import pl.dobberstudio.game.locations.MapLocation;

public class WaifuPanel extends Location
{
    private MapLocation exit;
    public WaifuPanel(GameManager gm, String path)
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
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        exit.isClicked(gc);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
        renderer.drawImage(exit.getIcon(), (int)exit.x, (int)exit.y);
    }
}
