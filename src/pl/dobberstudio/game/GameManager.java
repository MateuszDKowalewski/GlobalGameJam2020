package pl.dobberstudio.game;

import pl.dobberstudio.engine.AbstractGame;
import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.locations.City;

public class GameManager extends AbstractGame {

    private Image dobber;
    private City city;
    public GameManager() {
        dobber = new Image("dobberengine.png");
        city = new City(this, "map.png");
    }

    @Override
    public void update(GameContainer gc, double deltaTime) {
        city.update(gc, deltaTime);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        //renderer.drawImage(dobber, 200, 200);
        city.render(gc, renderer);
        //renderer.drawImage(dobber, gc.getInput().getMouseX() - dobber.getWidth(), gc.getInput().getMouseY() - dobber.getHeight());
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
