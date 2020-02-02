package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;

public class Clother extends Location
{
    ToadProduct[] clothes;
    MapLocation exit;
    public Clother(GameManager gm, String path, Character character)
    {
        super(gm, path);
        exit = new MapLocation(gm, "exit.png", 19, 608);
        exit.setOnClick(() -> gm.setLocation(CurrentLocation.CITY));
        clothes = new ToadProduct[12];

        clothes[0] = new ToadProduct(gm, "clother/adidas_hat.png", 250, 2, 1);
        clothes[0].setValue(1);
        clothes[0].setOnClick(() -> {
            if((character.getMoney() >= clothes[0].getPrice()) && (character.getEquipment().getHeadValue() < clothes[0].getValue())) {
                character.spendMoney(clothes[0].getPrice());
                character.getEquipment().setHead(clothes[0]);
            }
        });
        clothes[1] = new ToadProduct(gm, "clother/kasket.png", 700, 2, 1);
        clothes[1].setValue(2);
        clothes[1].setOnClick(() -> {
            if((character.getMoney() >= clothes[1].getPrice()) && (character.getEquipment().getHeadValue() < clothes[1].getValue())) {
                character.spendMoney(clothes[1].getPrice());
                character.getEquipment().setHead(clothes[1]);
            }
        });
        clothes[2] = new ToadProduct(gm, "clother/slash.png", 970, 2, 1);
        clothes[2].setValue(3);
        clothes[2].setOnClick(() -> {
            if((character.getMoney() >= clothes[2].getPrice()) && (character.getEquipment().getHeadValue() < clothes[2].getValue())) {
                character.spendMoney(clothes[2].getPrice());
                character.getEquipment().setHead(clothes[2]);
            }
        });
        clothes[3] = new ToadProduct(gm, "clother/wifepuncher.png", 250, 160, 1);
        clothes[3].setValue(1);
        clothes[3].setOnClick(() -> {
            if((character.getMoney() >= clothes[3].getPrice()) && (character.getEquipment().getBodyValue() < clothes[3].getValue())) {
                character.spendMoney(clothes[3].getPrice());
                character.getEquipment().setBody(clothes[3]);
            }
        });
        clothes[4] = new ToadProduct(gm, "clother/thrasher.png", 700, 160, 1);
        clothes[4].setValue(2);
        clothes[4].setOnClick(() -> {
            if((character.getMoney() >= clothes[4].getPrice()) && (character.getEquipment().getBodyValue() < clothes[4].getValue())) {
                character.spendMoney(clothes[4].getPrice());
                character.getEquipment().setBody(clothes[4]);
            }
        });
        clothes[5] = new ToadProduct(gm, "clother/jacket.png", 970, 160, 1);
        clothes[5].setValue(3);
        clothes[5].setOnClick(() -> {
            if((character.getMoney() >= clothes[5].getPrice()) && (character.getEquipment().getBodyValue() < clothes[5].getValue())) {
                character.spendMoney(clothes[5].getPrice());
                character.getEquipment().setBody(clothes[5]);
            }
        });
        clothes[6] = new ToadProduct(gm, "clother/pants.png", 250, 330, 1);
        clothes[6].setValue(1);
        clothes[6].setOnClick(() -> {
            if((character.getMoney() >= clothes[6].getPrice()) && (character.getEquipment().getLegsValue() < clothes[6].getValue())) {
                character.spendMoney(clothes[6].getPrice());
                character.getEquipment().setLegs(clothes[6]);
            }
        });
        clothes[7] = new ToadProduct(gm, "clother/builder_pants.png", 700, 330, 1);
        clothes[7].setValue(2);
        clothes[7].setOnClick(() -> {
            if((character.getMoney() >= clothes[7].getPrice()) && (character.getEquipment().getLegsValue() < clothes[7].getValue())) {
                character.spendMoney(clothes[7].getPrice());
                character.getEquipment().setLegs(clothes[7]);
            }
        });
        clothes[8] = new ToadProduct(gm, "clother/jeans.png", 970, 330, 1);
        clothes[8].setValue(3);
        clothes[8].setOnClick(() -> {
            if((character.getMoney() >= clothes[8].getPrice()) && (character.getEquipment().getLegsValue() < clothes[8].getValue())) {
                character.spendMoney(clothes[8].getPrice());
                character.getEquipment().setLegs(clothes[8]);
            }
        });
        clothes[9] = new ToadProduct(gm, "clother/kubota.png", 250, 500, 1);
        clothes[9].setValue(1);
        clothes[9].setOnClick(() -> {
            if((character.getMoney() >= clothes[9].getPrice()) && (character.getEquipment().getFootsValue() < clothes[9].getValue())) {
                character.spendMoney(clothes[9].getPrice());
                character.getEquipment().setFoots(clothes[9]);
            }
        });
        clothes[10] = new ToadProduct(gm, "clother/shoes.png", 700, 500, 1);
        clothes[10].setValue(2);
        clothes[10].setOnClick(() -> {
            if((character.getMoney() >= clothes[10].getPrice()) && (character.getEquipment().getFootsValue() < clothes[10].getValue())) {
                character.spendMoney(clothes[10].getPrice());
                character.getEquipment().setFoots(clothes[10]);
            }
        });
        clothes[11] = new ToadProduct(gm, "clother/boots.png", 970, 500, 1);
        clothes[11].setValue(3);
        clothes[11].setOnClick(() -> {
            if((character.getMoney() >= clothes[11].getPrice()) && (character.getEquipment().getFootsValue() < clothes[11].getValue())) {
                character.spendMoney(clothes[11].getPrice());
                character.getEquipment().setFoots(clothes[11]);
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
