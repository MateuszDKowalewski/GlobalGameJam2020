package pl.dobberstudio.dish;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.eq.Dish;
import pl.dobberstudio.game.eq.Equipment;
import pl.dobberstudio.game.locations.House;
import pl.dobberstudio.game.locations.ToadProduct;

public class Oven {

    private ToadProduct dishes[] = new ToadProduct[6];

    private int offX;
    private int offY;
    private int width;
    private int height;
    private int color;

    private Equipment equipment;

    private GameManager gm;
    private House house;


    public Oven(GameManager gm, House house, Equipment equipment) {
        this.gm = gm;
        this.house = house;
        this.equipment = equipment;

        offX = 300;
        offY = 100;
        width = 300;
        height = 450;
        color = 0xFFCCCCCC;

        dishes[0] = new ToadProduct(gm, "res/dishes/sandwich.png", 0 + offX, 0 + offY, 0);
        dishes[0].setOnClick(() -> {
            house.setDish(DishManager.makeSandwich(equipment, gm));
            house.setOvenInUse(false);
        });
        dishes[1] = new ToadProduct(gm, "res/dishes/toast.png", 150 + offX, 0 + offY, 0);
        dishes[1].setOnClick(() -> {
            house.setDish(DishManager.makeToast(equipment, gm));
            house.setOvenInUse(false);
        });
        dishes[2] = new ToadProduct(gm, "res/dishes/drink.png", 0 + offX, 150 + offY, 0);
        dishes[2].setOnClick(() -> {
            house.setDish(DishManager.makeDrink(equipment, gm));
            house.setOvenInUse(false);
        });
        dishes[3] = new ToadProduct(gm, "res/dishes/wine.png", 150 + offX, 150 + offY, 0);
        dishes[3].setOnClick(() -> {
            house.setDish(DishManager.makeWine(equipment, gm));
            house.setOvenInUse(false);
        });
        dishes[4] = new ToadProduct(gm, "res/dishes/cake.png", 0 + offX, 300 + offY, 0);
        dishes[4].setOnClick(() -> {
            house.setDish(DishManager.makeCake(equipment, gm));
            house.setOvenInUse(false);
        });
        dishes[5] = new ToadProduct(gm, "res/dishes/pasta.png", 150 + offX, 300 + offY, 0);
        dishes[5].setOnClick(() -> {
            house.setDish(DishManager.makePasta(equipment, gm));
            house.setOvenInUse(false);
        });

    }

    public void update(GameContainer gc, double deltaTime) {
        dishes[0].isClicked(gc);
        dishes[1].isClicked(gc);
        dishes[2].isClicked(gc);
        dishes[3].isClicked(gc);
        dishes[4].isClicked(gc);
        dishes[5].isClicked(gc);
    }
    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawRect(offX, offY, width, height, color);
        dishes[0].render(gc, renderer);
        dishes[1].render(gc, renderer);
        dishes[2].render(gc, renderer);
        dishes[3].render(gc, renderer);
        dishes[4].render(gc, renderer);
        dishes[5].render(gc, renderer);
    }
}
