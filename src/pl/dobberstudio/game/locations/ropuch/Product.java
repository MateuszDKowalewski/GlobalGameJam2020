package pl.dobberstudio.game.locations.ropuch;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.GameManager;

import java.awt.geom.Rectangle2D;

public class Product extends Rectangle2D.Double {
    private Image graphic;
    private String name;
    private float price;
    private boolean made;

    public Product(String path, String name, float price) {
        graphic = new Image(path);
        this.name = name;
        setFrame(0, 0, graphic.getWidth(), graphic.getHeight());
        this.price = price;
        made = false;
    }

    public Product(Image graphic, String name, float price) {
        this.graphic = graphic;
        this.name = name;
        setFrame(0, 0, graphic.getWidth(), graphic.getHeight());
        this.price = price;
        made = false;
    }

    public Product copy() {
        return new Product(graphic, name, price);
    }

    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(graphic, (int)x, (int)y);
    }

    public boolean isMade() {
        return made;
    }

    public void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void move(double dx, double dy) {
        this.x += dx;
        this.y += dy;
    }

    public void setMade(boolean made) {
        this.made = made;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                '}';
    }
}
