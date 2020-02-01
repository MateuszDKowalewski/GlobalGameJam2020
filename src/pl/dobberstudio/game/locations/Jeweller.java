package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.locations.city.MapLocation;

public class Jeweller extends Location
{
    ToadProduct[] jewelery;
    MapLocation exit;
    public Jeweller(GameManager gm, String path) 
    {
        super(gm, "florist_inside.png");
        exit = new MapLocation(gm, "exit.png", 1027, 19);
        exit.setOnClick(new Runnable() {
        @Override
        public void run()
        {
            gm.setLocation(CurrentLocation.CITY);
        }
    });
        jewelery = new ToadProduct[5];
        jewelery[0] = new ToadProduct(gm, "jeweller/diamond_ring.png", 250, 20, 1);
        jewelery[0].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("diamond");
            }
        });
        jewelery[1] = new ToadProduct(gm, "jeweller/gold_ring.png", 670, 20, 1);
        jewelery[1].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("gold");
            }
        });
        jewelery[2] = new ToadProduct(gm, "jeweller/earrings.png", 90, 344, 1);
        jewelery[2].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("earrings");
            }
        });
        jewelery[3] = new ToadProduct(gm, "jeweller/silver_ring.png", 470, 344, 1);
        jewelery[3].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("silver");
            }
        });
        jewelery[4] = new ToadProduct(gm, "jeweller/tymbark.png", 892, 344, 1);
        jewelery[4].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("tymbark");
            }
        });
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        for(ToadProduct m : jewelery)
        {
            m.isClicked(gc);
        }
        exit.isClicked(gc);
    }
    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
        for(ToadProduct m : jewelery)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
        renderer.drawImage(exit.getIcon(), (int)exit.x, (int)exit.y);
    }
}
