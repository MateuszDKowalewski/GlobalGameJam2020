package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.GameManager;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class Gym extends Location {
    private static final double DEFAULT_UP_TIME = 0.5;

    private Image boy;
    private int boyX;
    private int boyY;
    private double upTime;

    public Gym(GameManager gm, String path) {
        super(gm, path);
        boy = new Image("res/pullUpBoy.png");
        boyX = 560;
        boyY = 300;
        upTime = DEFAULT_UP_TIME;
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


        if(boyY > 300) {
            boyY = 300;
        }

        if(boyY < 50) {
            madePullUp();
            boyY = 300;
        }
    }

    private void madePullUp() {

    }

    @Override
    public void render(GameContainer gc, Renderer renderer) {
        super.render(gc, renderer);
        renderer.drawImage(boy, boyX, boyY);
    }
}
