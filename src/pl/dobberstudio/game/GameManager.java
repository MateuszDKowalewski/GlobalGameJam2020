package pl.dobberstudio.game;

import pl.dobberstudio.engine.AbstractGame;
import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.locations.*;

import java.awt.event.MouseEvent;

public class GameManager extends AbstractGame {

    private WorkRopuch workRopuch;
    private City city;
    private Toad toad;
    private CharacterPanel characterPanel;
    private WaifuPanel waifuPanel;
    private Florist florist;
  
    public GameManager() {
      workRopuch = new WorkRopuch(this, "kasa.png");
      city = new City(this, "map.png");
      toad = new Toad(this, "ropuch.png");
      characterPanel = new CharacterPanel(this, "characterPanel.png");
      waifuPanel = new WaifuPanel(this, "waifuPanel.png");
      florist = new Florist(this, "florist_inside.png");
    }

    @Override
    public void update(GameContainer gc, double deltaTime) {
        //workRopuch.update(gc, deltaTime);
        //city.update(gc, deltaTime);
        //toad.update(gc, deltaTime);
        //characterPanel.update(gc, deltaTime);
        //waifuPanel.update(gc, deltaTime);
        florist.update(gc, deltaTime);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {

        //workRopuch.render(gc, renderer);
        //city.render(gc, renderer);
        //toad.render(gc, renderer);
        //characterPanel.render(gc, renderer);
        //waifuPanel.render(gc, renderer);
        florist.render(gc, renderer);
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}
