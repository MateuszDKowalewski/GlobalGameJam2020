package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.locations.fridge.Fridge;

public class House extends Location
{
    boolean openFridge = false;

    private Character character;

    private MapLocation[] furniture;
    Fridge fridge;


    public House(GameManager gm, String path, Character character)
    {
        super(gm, path);
        this.character = character;

        fridge = new Fridge(gm, "res/fridge/fridge.png", character, this, 250, 30);

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
        furniture[1] = new MapLocation(gm,"house_kitchen.png", c * 12, c * 6);
        furniture[1].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("kitchen");
            }
        });
        furniture[2] = new MapLocation(gm,"house_fridge.png", c * 16, c * 3);
        furniture[2].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                setOpenFridge(true);
            }
        });
        furniture[3] = new MapLocation(gm,"house_bed.png", c * 21, c * 2);
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

    public void setOpenFridge(boolean openFridge) {
        this.openFridge = openFridge;
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        if(openFridge) {
            fridge.update(gc, deltaTime);
        } else {
            for (MapLocation m : furniture) {
                m.isClicked(gc);
            }
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        super.render(gc, renderer);
        for(MapLocation m : furniture)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
        if(openFridge) {
            fridge.render(gc, renderer);
        }
    }
}
