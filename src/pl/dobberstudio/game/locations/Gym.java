package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Gym extends Location {
    private static final double DEFAULT_UP_TIME = 0.5;

    Character character;
    MapLocation exit;

    private Image boy;
    private int boyX;
    private int boyY;
    private double upTime;

    public Gym(GameManager gm, String path, Character character) {
        super(gm, path);
        exit = new MapLocation(gm, "exit.png", 19, 608);
        exit.setOnClick(new Runnable() {
            @Override
            public void run()
            {
                gm.setLocation(CurrentLocation.CITY);
            }
        });
        boy = new Image("res/pullUpBoy.png");
        boyX = 583;
        boyY = 60;
        upTime = DEFAULT_UP_TIME;
        this.character = character;
    }

    @Override
    public void update(GameContainer gc, double deltaTime) {
        upTime -= deltaTime;
        if(upTime < 0) {
            upTime = DEFAULT_UP_TIME;
            boyY += 5;
        }

        if(gc.getInput().isButtonDown(MouseEvent.BUTTON1)) {
            boyY -= 4;
        }


        if(boyY > 60) {
            boyY = 60;
        }

        if(boyY < -118) {
            madePullUp();
            boyY = 60;
        }
        exit.isClicked(gc);
    }

    private void madePullUp() {
        character.trainOnGym();
    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        super.render(gc, renderer);
        renderer.drawImage(boy, boyX, boyY);
        renderer.drawImage(exit.getIcon(), (int)exit.x, (int)exit.y);
    }
}
