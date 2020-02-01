package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.GameManager;

public class Toad extends Location
{
    ToadProduct products[];
    public Toad(GameManager gm, String path)
    {
        super(gm, path);
        products = new ToadProduct[1];
        products[0] = new ToadProduct(gm,"ropuch/bread.png", 96, 9, 1);
        products[0].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                System.out.println("bread");
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
    }

    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
        for(ToadProduct m : products)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
    }
}
