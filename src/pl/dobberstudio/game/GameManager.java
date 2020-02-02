package pl.dobberstudio.game;

import pl.dobberstudio.engine.AbstractGame;
import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;

import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.gui.Stats;
import pl.dobberstudio.game.gui.Timer;
import pl.dobberstudio.game.locations.*;

import java.awt.event.MouseEvent;
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
    private WaifuPanel waifuPanel;
    private Florist florist;
    private Jeweller jeweller;
    private Clother clother;
    private DatePlace[] datePlace;
    private Stats stats;
    private Timer timer;
    private EndingPanel[] endingPanel;
  
    public GameManager() {
        character = new Character();
        current = CurrentLocation.CITY;

        stats = new Stats(this,"stats_bar.png", character);

        workRopuch = new WorkRopuch(this, "kasa.png", character);
        city = new City(this, "map.png");
        gym = new Gym(this, "res/gym.png", character);
        toad = new Toad(this, "ropuch.png", character);
        characterPanel = new CharacterPanel(this, "characterPanel.png", character);
        house = new House(this, "house_inside.png", character);
        florist = new Florist(this, "florist_inside.png", character);
        jeweller = new Jeweller(this, "jeweller_inside.png", character);
        clother = new Clother(this, "clother_inside.png", character);
        waifuPanel = new WaifuPanel(this, "waifuPanel.png");
        timer = new Timer(this, "timer_background.png");
        florist = new Florist(this, "florist_inside.png", character);
        datePlace = new DatePlace[5];
        datePlace[0] = new DatePlace(this, "datePlaces/restaurant_inside.png");
        datePlace[1] = new DatePlace(this, "datePlaces/cinema_inside.png");
        datePlace[2] = new DatePlace(this, "datePlaces/orlen_inside.png");
        datePlace[3] = new DatePlace(this, "datePlaces/pub_inside.png");
        datePlace[4] = new DatePlace(this, "datePlaces/park_inside.png");
        endingPanel = new EndingPanel[3];
        endingPanel[0] = new EndingPanel(this, "endings/ending_bad.png");
        endingPanel[1] = new EndingPanel(this, "endings/ending_good.png");
        endingPanel[2] = new EndingPanel(this, "endings/ending_best.png");
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
            case FLORIST: florist.update(gc, deltaTime); break;
            case JEWELLER: jeweller.update(gc, deltaTime); break;
            case CLOTHER: clother.update(gc, deltaTime); break;
            case WAIFU_PANEL: waifuPanel.update(gc, deltaTime); break;
            case RESTAURANT: datePlace[0].update(gc, deltaTime); break;
            case CINEMA: datePlace[1].update(gc, deltaTime); break;
            case ORLEN: datePlace[2].update(gc, deltaTime); break;
            case PUB: datePlace[3].update(gc, deltaTime); break;
            case PARK: datePlace[4].update(gc, deltaTime); break;
            case ENDING_BAD: endingPanel[0].update(gc, deltaTime); break;
            case ENDING_GOOD: endingPanel[1].update(gc, deltaTime); break;
            case ENDING_BEST: endingPanel[2].update(gc, deltaTime); break;
        }
        if((current != CurrentLocation.CHARACTER_PANEL) && (current != CurrentLocation.WAIFU_PANEL) && (current != CurrentLocation.ENDING_BAD) && (current != CurrentLocation.ENDING_GOOD) && (current != CurrentLocation.ENDING_BEST))
        stats.update(gc, deltaTime);
        if((current != CurrentLocation.ENDING_BAD) && (current != CurrentLocation.ENDING_GOOD) && (current != CurrentLocation.ENDING_BEST))
        timer.update(this, gc, deltaTime);
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        switch(current) {
            case WORK_ROPUCH: workRopuch.render(gc, renderer); break;
            case GYM: gym.render(gc, renderer); break;
            case TOAD: toad.render(gc, renderer); break;
            case CITY: city.render(gc, renderer); break;
            case CHARACTER_PANEL: characterPanel.render(gc, renderer); break;
            case HOUSE: house.render(gc, renderer); break;
            case FLORIST: florist.render(gc, renderer); break;
            case JEWELLER: jeweller.render(gc, renderer); break;
            case CLOTHER: clother.render(gc, renderer); break;
            case WAIFU_PANEL: waifuPanel.render(gc, renderer); break;
            case RESTAURANT: datePlace[0].render(gc, renderer); break;
            case CINEMA: datePlace[1].render(gc, renderer); break;
            case ORLEN: datePlace[2].render(gc, renderer); break;
            case PUB: datePlace[3].render(gc, renderer); break;
            case PARK: datePlace[4].render(gc, renderer); break;
            case ENDING_BAD: endingPanel[0].render(gc, renderer); break;
            case ENDING_GOOD: endingPanel[1].render(gc, renderer); break;
            case ENDING_BEST: endingPanel[2].render(gc, renderer); break;
        }
        if((current != CurrentLocation.CHARACTER_PANEL) && (current != CurrentLocation.WAIFU_PANEL) && (current != CurrentLocation.ENDING_BAD) && (current != CurrentLocation.ENDING_GOOD) && (current != CurrentLocation.ENDING_BEST))
            stats.render(gc, renderer);
        if((current != CurrentLocation.ENDING_BAD) && (current != CurrentLocation.ENDING_GOOD) && (current != CurrentLocation.ENDING_BEST))
        timer.render(gc, renderer);
    }

    public void setLocation(CurrentLocation location) {
        this.current = location;
    }


    public void setLocationByKey(GameContainer gc) {
        if(gc.getInput().isKeyDown(KeyEvent.VK_Q)) setLocation(CurrentLocation.CITY);
        if(gc.getInput().isKeyDown(KeyEvent.VK_W)) setLocation(CurrentLocation.ENDING_BAD);
        if(gc.getInput().isKeyDown(KeyEvent.VK_E)) setLocation(CurrentLocation.ENDING_GOOD);
        if(gc.getInput().isKeyDown(KeyEvent.VK_R)) setLocation(CurrentLocation.ENDING_BEST);

    }

    public static void main(String[] args) {
        GameContainer gc = new GameContainer(new GameManager());
        gc.start();
    }
}