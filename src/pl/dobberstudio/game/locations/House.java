package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;

public class House extends Location
{
    private Character character;

    private MapLocation[] furniture;


    public House(GameManager gm, String path, Character character)
    {
        super(gm, path);
        this.character = character;

        int c = 38;
        furniture = new MapLocation[5];
        furniture[0] = new MapLocation(gm,"house_doors.png", c * 7, c * 1);
        furniture[0].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                gm.setLocation(CurrentLocation.CITY);
            }
        });
        furniture[1] = new MapLocation(gm,"house_kitchen.png", c * 12, c * 5);
        furniture[1].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("kitchen");
            }
        });
        furniture[2] = new MapLocation(gm,"house_fridge.png", c * 16, c * 2);
        furniture[2].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("fridge");
            }
        });
        furniture[3] = new MapLocation(gm,"house_bed.png", c * 21, c * 6);
        furniture[3].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("bed");
            }
        });
        furniture[4] = new MapLocation(gm,"house_table.png", c * 3, c * 10);
        furniture[4].setOnClick(new Runnable() {
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
        for(MapLocation m : furniture)
        {
            m.isClicked(gc);
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        super.render(gc, renderer);
        for(MapLocation m : furniture)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
    }
}
