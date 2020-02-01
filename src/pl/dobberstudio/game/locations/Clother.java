package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;

public class Clother extends Location
{
    ToadProduct[] clothes;
    MapLocation exit;
    public Clother(GameManager gm, String path)
    {
        super(gm, path);
        exit = new MapLocation(gm, "exit.png", 19, 608);
        exit.setOnClick(new Runnable() {
            @Override
            public void run()
            {
                gm.setLocation(CurrentLocation.CITY);
            }
        });
        clothes = new ToadProduct[12];
        clothes[0] = new ToadProduct(gm, "clother/adidas_hat.png", 250, 2, 1);
        clothes[0].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("adidas_hat");
            }
        });
        clothes[1] = new ToadProduct(gm, "clother/kasket.png", 700, 2, 1);
        clothes[1].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("kasket");
            }
        });
        clothes[2] = new ToadProduct(gm, "clother/slash.png", 970, 2, 1);
        clothes[2].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("slash");
            }
        });
        clothes[3] = new ToadProduct(gm, "clother/wifepuncher.png", 250, 160, 1);
        clothes[3].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("wifepuncher");
            }
        });
        clothes[4] = new ToadProduct(gm, "clother/thrasher.png", 700, 160, 1);
        clothes[4].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("thrasher");
            }
        });
        clothes[5] = new ToadProduct(gm, "clother/jacket.png", 970, 160, 1);
        clothes[5].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("jacket");
            }
        });
        clothes[6] = new ToadProduct(gm, "clother/pants.png", 250, 330, 1);
        clothes[6].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("pants");
            }
        });
        clothes[7] = new ToadProduct(gm, "clother/builder_pants.png", 700, 330, 1);
        clothes[7].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("builder_pants");
            }
        });
        clothes[8] = new ToadProduct(gm, "clother/jeans.png", 970, 330, 1);
        clothes[8].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("jeans");
            }
        });
        clothes[9] = new ToadProduct(gm, "clother/kubota.png", 250, 500, 1);
        clothes[9].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("kubota");
            }
        });
        clothes[10] = new ToadProduct(gm, "clother/shoes.png", 700, 500, 1);
        clothes[10].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("shoes");
            }
        });
        clothes[11] = new ToadProduct(gm, "clother/boots.png", 970, 500, 1);
        clothes[11].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("boots");
            }
        });
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        for(ToadProduct m : clothes)
        {
            m.isClicked(gc);
        }
        exit.isClicked(gc);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
        for(ToadProduct m : clothes)
        {
            m.render(gc, renderer);
        }
        renderer.drawImage(exit.getIcon(), (int)exit.x, (int)exit.y);
    }
}
