package pl.dobberstudio.game.locations.ropuch;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;

import java.awt.*;
import java.awt.geom.Rectangle2D;

public class Scanner extends Rectangle2D.Double {
    Image image;

    public Scanner(String path, double x, double y) {
        image = new Image(path);
        setFrame(x, y, image.getWidth(), image.getHeight());
    }

    public void render(Renderer renderer) {
        renderer.drawImage(image, (int)x, (int)y);
    }

    public void scanProduct(Product product) {
        product.setMade(true);
    }
}
