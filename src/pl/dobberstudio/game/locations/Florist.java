package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.eq.Flowers;
import pl.dobberstudio.game.eq.Food;
import pl.dobberstudio.game.locations.city.MapLocation;

public class Florist extends Location
{
    ToadProduct[] flowers;
    MapLocation exit;

    public Florist(GameManager gm, String path, Character character)
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
        flowers = new ToadProduct[5];
        flowers[0] = new ToadProduct(gm, "florist/mixed.png", 290, 20, 1);
        flowers[0].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                if(character.getMoney() > flowers[0].getPrice()) {
                    character.spendMoney(flowers[0].getPrice());
                    character.addFlowers(Flowers.MIXED, 1);
                }
            }
        });
        flowers[1] = new ToadProduct(gm, "florist/roses.png", 670, 20, 1);
        flowers[1].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                if(character.getMoney() > flowers[1].getPrice()) {
                    character.spendMoney(flowers[1].getPrice());
                    character.addFlowers(Flowers.ROSES, 1);
                }
            }
        });
        flowers[2] = new ToadProduct(gm, "florist/tulips.png", 90, 344, 1);
        flowers[2].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                if(character.getMoney() > flowers[2].getPrice()) {
                    character.spendMoney(flowers[2].getPrice());
                    character.addFlowers(Flowers.TULIPS, 1);
                }
            }
        });
        flowers[3] = new ToadProduct(gm, "florist/dandelions.png", 470, 344, 1);
        flowers[3].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                if(character.getMoney() > flowers[3].getPrice()) {
                    character.spendMoney(flowers[3].getPrice());
                    character.addFlowers(Flowers.DANDELIONS, 1);
                }
            }
        });
        flowers[4] = new ToadProduct(gm, "florist/chrisantema.png", 892, 344, 1);
        flowers[4].setOnClick(new Runnable() {
            @Override
            public void run()
            {
                if(character.getMoney() > flowers[4].getPrice()) {
                    character.spendMoney(flowers[4].getPrice());
                    character.addFlowers(Flowers.CHRISANTEMA, 1);
                }
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
        exit.isClicked(gc);
    }
    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
        for(ToadProduct m : flowers)
        {
            renderer.drawImage(m.getIcon(), (int)m.x, (int)m.y);
        }
        renderer.drawImage(exit.getIcon(), (int)exit.x, (int)exit.y);
    }
}
