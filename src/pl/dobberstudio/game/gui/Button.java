package pl.dobberstudio.game.gui;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.GameManager;

import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;

public abstract class Button extends Rectangle2D.Double {
    Runnable onClick;
    GameManager gm;
    Image icon;

    public Button(GameManager gm, String path, double x, double y) {
        icon = new Image(path);
        int w = icon.getWidth();
        int h = icon.getHeight();
        super.setFrame(x, y, w, h);
        this.gm = gm;
    }

    public void isClicked(GameContainer gc) {
        if(contains(gc.getInput().getMouseX(), gc.getInput().getMouseY()) && (gc.getInput().isButtonDown(MouseEvent.BUTTON1))) { //todo: isbuttondown repair
            onClick.run();
        }
    }

    public void update(GameContainer gc, double deltaTime) {

    }

    public Image getIcon() {
        return icon;
    }

    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(icon, (int)getX(), (int)getY());
    }

    public void setOnClick(Runnable onClick) {
        this.onClick = onClick;
    }
}
