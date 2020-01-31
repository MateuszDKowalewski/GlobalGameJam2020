package pl.dobberstudio.engine;

public abstract class AbstractGame {
    public abstract void update(GameContainer gc, double deltaTime);
    public abstract void render(GameContainer gc, Renderer renderer);
}
