package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.GameManager;

public class House extends Location
{
    private MapLocation[] locations;
    public House(GameManager gm, String path)
    {
        super(gm, path);
        int c = 38;
        locations = new MapLocation[5];
        locations[0] = new MapLocation(gm,"house_doors.png", c * 7, c * 1);
        locations[0].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("doors");
            }
        });
        locations[1] = new MapLocation(gm,"house_kitchen.png", c * 12, c * 5);
        locations[1].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("kitchen");
            }
        });
        locations[2] = new MapLocation(gm,"house_fridge.png", c * 16, c * 2);
        locations[2].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("fridge");
            }
        });
        locations[3] = new MapLocation(gm,"house_bed.png", c * 21, c * 6);
        locations[3].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("bed");
            }
        });
        locations[4] = new MapLocation(gm,"house_table.png", c * 3, c * 10);
        locations[4].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("table");
            }
        });
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        for(MapLocation m : locations)
        {
            m.isClicked(gc);
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        super.render(gc, renderer);
        for(MapLocation m : locations)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
    }
}
