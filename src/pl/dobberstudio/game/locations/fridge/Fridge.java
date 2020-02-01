package pl.dobberstudio.game.locations.fridge;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.eq.Food;
import pl.dobberstudio.game.locations.House;
import pl.dobberstudio.game.locations.MapLocation;
import pl.dobberstudio.game.locations.Toad;
import pl.dobberstudio.game.locations.ToadProduct;

import java.awt.*;
import java.awt.event.MouseEvent;

public class Fridge {
    Image image;
    ToadProduct products[];
    House house;
    Character character;
    GameManager gm;
    int x;
    int y;

    public Fridge(GameManager gm, String path, Character character, House house, int x, int y) {
        image = new Image(path);
        this.house = house;
        this.x = x;
        this.y = y;
        this.gm = gm;
        this.character = character;

        products = new ToadProduct[15];
        products[0] = new ToadProduct(gm,"res/fridge/bread.png", x + 90, y + 191, 1);
        products[0].setFoodKind(Food.BREAD);
        products[0].setOnClick(() -> {
            if(character.getFoodAmount(Food.BREAD) > 0) {
                character.eat(10);
                character.addFood(Food.BREAD, -1);
            }
        });
        products[1] = new ToadProduct(gm,"res/fridge/cheese.png", x + 257, y +193, 1);
        products[1].setFoodKind(Food.CHEESE);
        products[1].setOnClick(() -> {
            if(character.getFoodAmount(Food.CHEESE) > 0) {
                character.eat(10);
                character.addFood(Food.CHEESE, -1);
            }
        });
        products[2] = new ToadProduct(gm,"res/fridge/lays.png", x + 395, y + 245, 1);
        products[2].setFoodKind(Food.LAYS);
        products[2].setOnClick(() -> {
            if(character.getFoodAmount(Food.LAYS) > 0) {
                character.eat(10);
                character.addFood(Food.LAYS, -1);
            }
        });
        products[3] = new ToadProduct(gm,"res/fridge/choclet.png", x + 471, y + 74, 1);
        products[3].setFoodKind(Food.CHOCKED);
        products[3].setOnClick(() -> {
            if(character.getFoodAmount(Food.CHOCKED) > 0) {
                character.eat(10);
                character.addFood(Food.CHOCKED, -1);
            }
        });
        products[4] = new ToadProduct(gm,"res/fridge/egs.png", x + 250, y + 290, 1);
        products[4].setFoodKind(Food.EGGS);
        products[4].setOnClick(() -> {
            if(character.getFoodAmount(Food.EGGS) > 0) {
                character.eat(10);
                character.addFood(Food.EGGS, -1);
            }
        });
        products[5] = new ToadProduct(gm,"res/fridge/bears.png", x + 264, y + 413, 1);
        products[5].setFoodKind(Food.BEERS);
        products[5].setOnClick(() -> {
            if(character.getFoodAmount(Food.BEERS) > 0) {
                character.eat(10);
                character.addFood(Food.BEERS, -1);
            }
        });
        products[6] = new ToadProduct(gm,"res/fridge/tomatoes.png", x + 93, y + 88, 1);
        products[6].setFoodKind(Food.TOMATOES);
        products[6].setOnClick(() -> {
            if(character.getFoodAmount(Food.TOMATOES) > 0) {
                character.eat(10);
                character.addFood(Food.TOMATOES, -1);
            }
        });
        products[7] = new ToadProduct(gm,"res/fridge/wine.png", x + 527, y + 434, 1);
        products[7].setFoodKind(Food.WINE);
        products[7].setOnClick(() -> {
            if(character.getFoodAmount(Food.WINE) > 0) {
                character.eat(10);
                character.addFood(Food.WINE, -1);
            }
        });
        products[8] = new ToadProduct(gm,"res/fridge/ham.png", x + 111, y + 301, 1);
        products[8].setFoodKind(Food.HAM);
        products[8].setOnClick(() -> {
            if(character.getFoodAmount(Food.HAM) > 0) {
                character.eat(10);
                character.addFood(Food.HAM, -1);
            }
        });
        products[9] = new ToadProduct(gm,"res/fridge/pasta.png", x + 222, y + 72, 1);
        products[9].setFoodKind(Food.PASTA);
        products[9].setOnClick(() -> {
            if(character.getFoodAmount(Food.PASTA) > 0) {
                character.eat(10);
                character.addFood(Food.PASTA, -1);
            }
        });
        products[10] = new ToadProduct(gm,"res/fridge/tea.png", x + 555, y + 280, 1);
        products[10].setFoodKind(Food.TEA);
        products[10].setOnClick(() -> {
            if(character.getFoodAmount(Food.TEA) > 0) {
                character.eat(10);
                character.addFood(Food.TEA, -1);
            }
        });
        products[11] = new ToadProduct(gm,"res/fridge/milk.png", x + 480, y + 420, 1);
        products[11].setFoodKind(Food.MILK);
        products[11].setOnClick(() -> {
            if(character.getFoodAmount(Food.MILK) > 0) {
                character.eat(10);
                character.addFood(Food.MILK, -1);
            }
        });
        products[12] = new ToadProduct(gm,"res/fridge/soup.png", x + 204, y + 427, 1);
        products[12].setFoodKind(Food.SOUP);
        products[12].setOnClick(() -> {
            if(character.getFoodAmount(Food.SOUP) > 0) {
                character.eat(10);
                character.addFood(Food.SOUP, -1);
            }
        });
        products[13] = new ToadProduct(gm,"res/fridge/sausage.png", x + 80, y + 400, 1);
        products[13].setFoodKind(Food.SAUSAGE);
        products[13].setOnClick(() -> {
            if(character.getFoodAmount(Food.SAUSAGE) > 0) {
                character.eat(10);
                character.addFood(Food.SAUSAGE, -1);
            }
        });
        products[14] = new ToadProduct(gm,"res/fridge/beer.png", x + 420, y + 414, 1);
        products[14].setFoodKind(Food.BEER);
        products[14].setOnClick(() -> {
            if(character.getFoodAmount(Food.BEER) > 0) {
                character.eat(10);
                character.addFood(Food.BEER, -1);
            }
        });
    }

    public void update(GameContainer gc, double deltaTime) {
        if (gc.getInput().isButtonDown(MouseEvent.BUTTON1) && !(new Rectangle.Double(x, y, image.getWidth(), image.getHeight()).contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()))) {
            house.setOpenFridge(false);
        }

        for(ToadProduct product : products) {
            if(character.getFoodAmount(product.getFoodKind()) > 0) {
                product.isClicked(gc);
            }
        }
    }

    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(image, x, y);
        for(ToadProduct product : products) {
            if(character.getFoodAmount(product.getFoodKind()) > 0) {
                product.render(gc, renderer);
            }
        }
    }
}
