package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.GameManager;

public class CharacterPanel extends Location
{
    Character character;

    private static final int BAR_X_START = 400;
    private static final int BAR_X_END = 1170;
    private static final int BAR_HEIGHT = 50;
    private static final int CHARISMA_BAR_Y = 382;
    private static final int LOOK_BAR_Y = 495;
    private static final int BODY_BAR_Y = 609;


    public CharacterPanel(GameManager gm, String path, Character character) {
        super(gm, path);
        this.character = character;
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {

    }

    @Override
    public void render(GameContainer gc, Renderer renderer)
    {
        super.render(gc, renderer);

        int width;

        width = BAR_X_END - BAR_X_START;
        renderer.drawRect(BAR_X_START, CHARISMA_BAR_Y, width, BAR_HEIGHT, 0xFF000000);
        renderer.drawRect(BAR_X_START, LOOK_BAR_Y, width, BAR_HEIGHT, 0xFF000000);
        renderer.drawRect(BAR_X_START, BODY_BAR_Y, width, BAR_HEIGHT, 0xFF000000);

        width = (int)((BAR_X_END - BAR_X_START) * ((double)character.getCharisma() / Character.MAX_CHARISMA));
        renderer.drawRect(BAR_X_START, CHARISMA_BAR_Y, width, BAR_HEIGHT, 0xFF00FF00);
        width = (int)((BAR_X_END - BAR_X_START) * ((double)character.getLook() / Character.MAX_LOOK));
        renderer.drawRect(BAR_X_START, LOOK_BAR_Y, width, BAR_HEIGHT, 0xFF00FF00);
        width = (int)((BAR_X_END - BAR_X_START) * ((double)character.getBody() / Character.MAX_BODY));
        renderer.drawRect(BAR_X_START, BODY_BAR_Y, width, BAR_HEIGHT, 0xFF00FF00);
    }
}
