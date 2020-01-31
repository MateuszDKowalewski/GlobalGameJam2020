package pl.dobberstudio.game;

import pl.dobberstudio.engine.AbstractGame;
import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;

public class GameManager extends AbstractGame {

    private Image dobber;

    public GameManager() {
        dobber = new Image("dobberengine.png");
    }

    @Override
    public void update(GameContainer gc, double deltaTime) {

    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        //renderer.drawImage(dobber, 200, 200);
        renderer.drawImage(dobber, gc.getInput().getMouseX() - dobber.getWidth() / 2, gc.getInput().getMouseY() - dobber.getHeight() / 2);
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
