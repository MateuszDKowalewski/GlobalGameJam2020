package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.locations.city.MapLocation;

public class Florist extends Location
{
    ToadProduct[] flowers;
    public Florist(GameManager gm, String path)
    {
        super(gm, "florist_inside.png");
        flowers = new ToadProduct[5];
        flowers[0] = new ToadProduct(gm, "florist/mixed.png", 90, 20, 1);
        flowers[0].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("mixed");
            }
        });
        flowers[1] = new ToadProduct(gm, "florist/roses.png", 670, 20, 1);
        flowers[1].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("roses");
            }
        });
        flowers[2] = new ToadProduct(gm, "florist/tulips.png", 90, 344, 1);
        flowers[2].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("tulips");
            }
        });
        flowers[3] = new ToadProduct(gm, "florist/dandelions.png", 470, 344, 1);
        flowers[3].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("dandelions");
            }
        });
        flowers[4] = new ToadProduct(gm, "florist/chrisantema.png", 892, 344, 1);
        flowers[4].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("chrisantema");
            }
        });
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        for(ToadProduct m : flowers)
        {
            m.isClicked(gc);
        }
    }
    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
        for(ToadProduct m : flowers)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
    }
}
