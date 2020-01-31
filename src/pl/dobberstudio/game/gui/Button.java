package pl.dobberstudio.game.gui;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.GameManager;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public abstract class Button extends Rectangle2D.Double {
    GameManager gm;
    Image icon;

    public Button(GameManager gm, String path, double x, double y) {
        icon = new Image(path);
        int w = icon.getWidth();
        int h = icon.getHeight();
        super.setFrame(x, y, w, h);
        this.gm = gm;
    }

    protected abstract void onClickAction(GameContainer gc);

    public void isClicked(GameContainer gc) {
        if(contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && (gc.getInput().isButtonDown(MouseEvent.BUTTON1))) {
            onClickAction(gc);
        }
    }

    public void update(GameContainer gc, double deltaTime) {

    }

    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(icon, (int)getX(), (int)getY());
    }
}
