package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.GameManager;

public class CharacterPanel extends Location
{

    public CharacterPanel(GameManager gm, String path) {
        super(gm, path);
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {

    }

    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);
    }
}
