package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.locations.ropuch.Assortment;
import pl.dobberstudio.game.locations.ropuch.Basket;
import pl.dobberstudio.game.locations.ropuch.Product;
import pl.dobberstudio.game.locations.ropuch.Scanner;

import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class WorkRopuch extends Location {

    Assortment assortment;
    Scanner scanner;

    private List<Product> products = new ArrayList<>();
    private Basket basket;

    Product grabbedProduct;
    int grabbedOffX;
    int grabbedOffY;


    public WorkRopuch(GameManager gm, String path) {
        super(gm, path);
        assortment = new Assortment();
        grabbedProduct = null;
        scanner = new Scanner("scaner.png", 622, 51);

        basket = new Basket(this);
        basket.getProducts().forEach(p -> products.add(p));
        products.sort(Comparator.comparingDouble(Product::getX));
    }



    @Override
    public void update(GameContainer gc, double deltaTime) {
        if(gc.getInput().isButtonDown(MouseEvent.BUTTON1)) {
            products.forEach(p -> {
                if(p.contains(gc.getInput().getMouseX(), gc.getInput().getMouseY())) {
                    grabbedProduct = p;
                    grabbedOffX = gc.getInput().getMouseX() - (int)p.getX();
                    grabbedOffY = gc.getInput().getMouseY() - (int)p.getY();

                    basket.remove(p);
                }
            });
        }

        if(gc.getInput().isButtonUp(MouseEvent.BUTTON1)) {
            grabbedProduct = null;
        }

        if(grabbedProduct != null) {
            grabbedProduct.x = gc.getInput().getMouseX() - grabbedOffX;
            grabbedProduct.y = gc.getInput().getMouseY() - grabbedOffY;
            if(scanner.contains(grabbedProduct.getCenterX(), grabbedProduct.getCenterY())) {
                scanner.scanProduct(grabbedProduct);
                boolean all = true;
                for(Product p : products) {
                    if(!p.isMade()) {
                        all = false;
                    }
                }
                if(all) {
                    System.out.println("Gratulacje");
                    madeBasket();
                }
            }
        }

        if((basket != null) && (basket.getAmount() > 0) && (basket.getProducts().get(0).x < scanner.x - basket.getProducts().get(0).width - 50)) {
            basket.run(deltaTime);
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        super.render(gc, renderer);
        scanner.render(renderer);
        if(products != null) {
            products.forEach(p -> p.render(gc, renderer));
        }
    }

    public Assortment getAssortment() {
        return assortment;
    }

    private void madeBasket() {
        //TODO: add coins to player
        products = null;
        basket = null;
        grabbedProduct = null;
        basket = new Basket(this);
        products = new ArrayList<>();
        basket.getProducts().forEach(p -> products.add(p));
    }
}
