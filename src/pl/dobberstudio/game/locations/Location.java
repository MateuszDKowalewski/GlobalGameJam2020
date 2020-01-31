package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.GameManager;

public abstract class Location {
    GameManager gm;
    Image background;

    public Location(GameManager gm, String path) {
        this.gm = gm;
        background = new Image(path);
    }


    public abstract void update(GameContainer gc, double deltaTime);
    public void render(GameContainer gc, Renderer renderer) {
        renderer.drawImage(background, 0, 0);
    }
}
