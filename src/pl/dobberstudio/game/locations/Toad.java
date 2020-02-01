package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;

public class Toad extends Location
{
    ToadProduct products[];
    MapLocation exit;
    public Toad(GameManager gm, String path)
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
        products = new ToadProduct[15];
        products[0] = new ToadProduct(gm,"ropuch/bread.png", 176, 9, 1);
        products[0].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("bread");
            }
        });
        products[1] = new ToadProduct(gm,"ropuch/cheese.png", 417, 9, 1);
        products[1].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("cheese");
            }
        });
        products[2] = new ToadProduct(gm,"ropuch/chips.png", 768, 9, 1);
        products[2].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("chips");
            }
        });
        products[3] = new ToadProduct(gm,"ropuch/chocolate.png", 1000, 494, 1);
        products[3].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("chocolate");
            }
        });
        products[4] = new ToadProduct(gm,"ropuch/eggs.png", 334, 178, 1);
        products[4].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("eggs");
            }
        });
        products[5] = new ToadProduct(gm,"ropuch/harnold.png", 628, 178, 1);
        products[5].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("harnold");
            }
        });
        products[6] = new ToadProduct(gm,"ropuch/tomatoes.png", 912, 178, 1);
        products[6].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("tomatoes");
            }
        });
        products[7] = new ToadProduct(gm,"ropuch/wine.png", 132, 336, 1);
        products[7].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("wine");
            }
        });
        products[8] = new ToadProduct(gm,"ropuch/krakus.png", 478, 336, 1);
        products[8].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("krakus");
            }
        });
        products[9] = new ToadProduct(gm,"ropuch/pasta.png", 864, 336, 1);
        products[9].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("pasta");
            }
        });
        products[10] = new ToadProduct(gm,"ropuch/lipton.png", 96, 494, 1);
        products[10].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("lipton");
            }
        });
        products[11] = new ToadProduct(gm,"ropuch/milk.png", 288, 494, 1);
        products[11].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("milk");
            }
        });
        products[12] = new ToadProduct(gm,"ropuch/oyakata.png", 480, 494, 1);
        products[12].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("oyakata");
            }
        });
        products[13] = new ToadProduct(gm,"ropuch/sausage.png", 674, 494, 1);
        products[13].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("sausage");
            }
        });
        products[14] = new ToadProduct(gm,"ropuch/stern.png", 868, 494, 1);
        products[14].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("stern");
            }
        });
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        for(ToadProduct m : products)
        {
            m.isClicked(gc);
        }
        exit.isClicked(gc);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
        for(ToadProduct m : products)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
        renderer.drawImage(exit.getIcon(), (int)exit.x, (int)exit.y);
    }
}
