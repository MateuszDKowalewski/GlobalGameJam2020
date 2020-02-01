package pl.dobberstudio.game;

import pl.dobberstudio.engine.AbstractGame;
import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.locations.*;

import java.awt.event.KeyEvent;

public class GameManager extends AbstractGame {

    Character character;

    CurrentLocation current;

    private WorkRopuch workRopuch;
    private City city;
    private Gym gym;
    private Toad toad;
    private CharacterPanel characterPanel;
    private House house;
  
    public GameManager() {
        character = new Character();
        current = CurrentLocation.CITY;

        workRopuch = new WorkRopuch(this, "kasa.png", character);
        city = new City(this, "map.png");
        gym = new Gym(this, "res/gym.png", character);
        toad = new Toad(this, "ropuch.png");
        characterPanel = new CharacterPanel(this, "characterPanel.png", character);
        house = new House(this, "house_inside.png", character);
    }

    @Override
    public void update(GameContainer gc, double deltaTime) {
        setLocationByKey(gc);
        switch(current) {
            case WORK_ROPUCH: workRopuch.update(gc, deltaTime); break;
            case GYM:  gym.update(gc, deltaTime); break;
            case TOAD: toad.update(gc, deltaTime); break;
            case CITY: city.update(gc, deltaTime); break;
            case CHARACTER_PANEL: characterPanel.update(gc, deltaTime); break;
            case HOUSE: house.update(gc, deltaTime); break;
        }
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        switch(current) {
            case WORK_ROPUCH: workRopuch.render(gc, renderer); break;
            case GYM: gym.render(gc, renderer); break;
            case TOAD: toad.render(gc, renderer); break;
            case CITY: city.render(gc, renderer); break;
            case CHARACTER_PANEL: characterPanel.render(gc, renderer); break;
            case HOUSE:house.render(gc, renderer); break;
        }
        renderer.drawText("WAIFUUUU\nKAWAII", 100, 100, 0xFFFFFFFF);
    }

    public void setLocation(CurrentLocation location) {
        this.current = location;
    }

    public void setLocationByKey(GameContainer gc) {
        if(gc.getInput().isKeyDown(KeyEvent.VK_Q)) setLocation(CurrentLocation.WORK_ROPUCH);
        if(gc.getInput().isKeyDown(KeyEvent.VK_W)) setLocation(CurrentLocation.GYM);
        if(gc.getInput().isKeyDown(KeyEvent.VK_E)) setLocation(CurrentLocation.TOAD);
        if(gc.getInput().isKeyDown(KeyEvent.VK_R)) setLocation(CurrentLocation.CITY);
        if(gc.getInput().isKeyDown(KeyEvent.VK_T)) setLocation(CurrentLocation.CHARACTER_PANEL);
        if(gc.getInput().isKeyDown(KeyEvent.VK_Y)) setLocation(CurrentLocation.HOUSE);
    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        System.out.println("\n".codePointAt(0));
        gc.start();
    }
}