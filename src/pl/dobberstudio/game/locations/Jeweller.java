package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.eq.Rings;
import pl.dobberstudio.game.locations.city.MapLocation;

public class Jeweller extends Location
{
    ToadProduct[] jewelery;
    MapLocation exit;
    public Jeweller(GameManager gm, String path, Character character)
    {
        super(gm, path);
        exit = new MapLocation(gm, "exit.png", 1027, 19);
        exit.setOnClick(() -> gm.setLocation(CurrentLocation.CITY));

        jewelery = new ToadProduct[5];
        jewelery[0] = new ToadProduct(gm, "jeweller/diamond_ring.png", 250, 20, 1);
        jewelery[0].setValue(5);
        jewelery[0].setRingType(Rings.DIAMOND);
        jewelery[0].setOnClick(() -> {
            if((character.getMoney() >= jewelery[0].getPrice()) && (character.getEquipment().getRingValue() < jewelery[0].getValue())) {
                character.spendMoney(jewelery[0].getPrice());
                character.getEquipment().setRing(jewelery[0]);
            }
        });
        jewelery[1] = new ToadProduct(gm, "jeweller/gold_ring.png", 670, 20, 1);
        jewelery[1].setValue(3);
        jewelery[1].setRingType(Rings.GOLD);
        jewelery[1].setOnClick(() -> {
            if((character.getMoney() >= jewelery[1].getPrice()) && (character.getEquipment().getRingValue() < jewelery[1].getValue())) {
                character.spendMoney(jewelery[1].getPrice());
                character.getEquipment().setRing(jewelery[1]);
            }
        });
        jewelery[2] = new ToadProduct(gm, "jeweller/earrings.png", 90, 344, 1);
        jewelery[2].setValue(4);
        jewelery[2].setRingType(Rings.EAR);
        jewelery[2].setOnClick(() -> {
            if((character.getMoney() >= jewelery[2].getPrice()) && (character.getEquipment().getRingValue() < jewelery[2].getValue())) {
                character.spendMoney(jewelery[2].getPrice());
                character.getEquipment().setRing(jewelery[2]);
            }
        });
        jewelery[3] = new ToadProduct(gm, "jeweller/silver_ring.png", 470, 344, 1);
        jewelery[3].setValue(2);
        jewelery[3].setRingType(Rings.SILVER);
        jewelery[3].setOnClick(() -> {
            if((character.getMoney() >= jewelery[3].getPrice()) && (character.getEquipment().getRingValue() < jewelery[3].getValue())) {
                character.spendMoney(jewelery[3].getPrice());
                character.getEquipment().setRing(jewelery[3]);
            }
        });
        jewelery[4] = new ToadProduct(gm, "jeweller/tymbark.png", 892, 344, 1);
        jewelery[4].setValue(1);
        jewelery[4].setRingType(Rings.TYMBARK);
        jewelery[4].setOnClick(() -> {
            if((character.getMoney() >= jewelery[4].getPrice()) && (character.getEquipment().getRingValue() < jewelery[4].getValue())) {
                character.spendMoney(jewelery[4].getPrice());
                character.getEquipment().setRing(jewelery[4]);
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
