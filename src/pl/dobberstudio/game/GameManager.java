package pl.dobberstudio.game;

import pl.dobberstudio.engine.AbstractGame;
import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.locations.Gym;
import pl.dobberstudio.game.locations.WorkRopuch;
import pl.dobberstudio.game.locations.City;
import java.awt.event.MouseEvent;

public class GameManager extends AbstractGame {

    private WorkRopuch workRopuch;
    private City city;
    private Gym gym;
  
    public GameManager() {
      workRopuch = new WorkRopuch(this, "kasa.png");
      city = new City(this, "map.png");
      gym = new Gym(this, "res/gym.png");
    }

    @Override
    public void update(GameContainer gc, double deltaTime) {
        //workRopuch.update(gc, deltaTime);
        //city.update(gc, deltaTime);
        gym.update(gc, deltaTime);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        //workRopuch.render(gc, renderer);
        //city.render(gc, renderer);
        gym.render(gc, renderer);
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
