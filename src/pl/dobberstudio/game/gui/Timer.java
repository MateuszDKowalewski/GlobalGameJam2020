package pl.dobberstudio.game.gui;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;

public class Timer
{
    private double timeLeft = 300;
    private Image timerB;
    public Timer(GameManager gm, String path)
    {
        timerB = new Image(path);
    }
    public void update(GameManager gm, GameContainer gc, double deltaTime)
    {
        if(timeLeft >=0 )
        timeLeft -= deltaTime;
        else
            gm.setLocation(CurrentLocation.ENDING_BAD);
    }
    public void render(GameContainer gc, Renderer renderer)
    {
        renderer.drawImage(timerB, 532, 0);
        if(((int)(timeLeft % 60) < 10) && ((int)(timeLeft / 60) < 10))
            renderer.drawText("0" + Integer.toString((int)(timeLeft / 60)) + " : 0" + Integer.toString((int)(timeLeft % 60)), 580, 6, 0xFFAA06BA);
        else if((int)(timeLeft % 60) < 10)
            renderer.drawText(Integer.toString((int)(timeLeft / 60)) + " : 0" + Integer.toString((int)(timeLeft % 60)), 580, 6, 0xFFAA06BA);
        else if((int)(timeLeft / 60) < 10)
            renderer.drawText("0" + Integer.toString((int)(timeLeft / 60)) + " : " + Integer.toString((int)(timeLeft % 60)), 580, 6, 0xFFAA06BA);
        else
        renderer.drawText(Integer.toString((int)(timeLeft / 60)) + " : " + Integer.toString((int)(timeLeft % 60)), 580, 6, 0xFFAA06BA);
    }

    public void sleep()
    {
        timeLeft -= 10;
    }
}
