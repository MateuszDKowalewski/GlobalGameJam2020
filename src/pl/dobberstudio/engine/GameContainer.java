package pl.dobberstudio.engine;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameContainer implements Runnable{
    public static final int WIDTH = 1216;
    public static final int HEIGHT = 684;
    public static final float SCALE = 1f;
    public static final String TITLE = "5 Minutes Before Date";

    private Thread thread;
    private Window window;
    private Renderer renderer;
    private AbstractGame game;
    private Input input;

    private boolean running = false;
    private final double UPDATE_CUP = 1.0/60.0;

    public GameContainer(AbstractGame abstractGame) {
        this.game = abstractGame;
    }

    public void start() {
        window = new Window(this);
        renderer = new Renderer(this, window);
        input = new Input(this);

        thread = new Thread(this);
        thread.run();
    }

    public void run() {
        running = true;

        boolean render = false;
        double firstTime = 0;
        double lastTime = System.nanoTime() / 1000000000.0;
        double passedTime = 0;
        double unprocessedTime = 0;

        double frameTime = 0;
        int frames = 0;
        int fps = 0;

        while(running) {
            render = false;

            firstTime = System.nanoTime() / 1000000000.0;
            passedTime = firstTime - lastTime;
            lastTime = firstTime;

            unprocessedTime += passedTime;
            frameTime += passedTime;

            while(unprocessedTime >= UPDATE_CUP) {
                unprocessedTime -= UPDATE_CUP;
                render = true;

                game.update(this, UPDATE_CUP);
                input.update();

                if(frameTime >= 1.0) {
                    frameTime = 0;
                    fps = frames;
                    frames = 0;
                    //System.out.println("FPS: " + fps);
                }
            }

            if(render) {
                frames++;
                renderer.clear();
                game.render(this, renderer);
                window.update();
            } else {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        dispose();
    }

    public void dispose() {

    }

    public Window getWindow() {
        return window;
    }

    public Input getInput() {
        return input;
    }
}
