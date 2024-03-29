package pl.dobberstudio.game.locations;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;

public class CharacterPanel extends Location
{
    Character character;
    private MapLocation exit;

    private static final int BAR_X_START = 400;
    private static final int BAR_X_END = 1170;
    private static final int BAR_HEIGHT = 50;
    private static final int CHARISMA_BAR_Y = 382;
    private static final int LOOK_BAR_Y = 495;
    private static final int BODY_BAR_Y = 609;


    public CharacterPanel(GameManager gm, String path, Character character) {
        super(gm, path);
        exit = new MapLocation(gm, "exit.png", 1027, 19);
        exit.setOnClick(new Runnable() {
            @Override
            public void run()
            {
                gm.setLocation(CurrentLocation.CITY);
            }
        });
        this.character = character;
    }

    @Override
    public void update(GameContainer gc, double deltaTime)
    {
        exit.isClicked(gc);
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

        renderer.drawImage(exit.getIcon(), (int)exit.x, (int)exit.y);

        if(character.getEquipment().getHeadValue() > 0) {
            renderer.drawImage(character.getEquipment().getHead().getIcon(), 400, 150);
        }
        if(character.getEquipment().getBodyValue() > 0) {
            renderer.drawImage(character.getEquipment().getBody().getIcon(), 600, 150);
        }
        if(character.getEquipment().getLegsValue() > 0) {
            renderer.drawImage(character.getEquipment().getLegs().getIcon(), 800, 150);
        }
        if(character.getEquipment().getFootsValue() > 0) {
            renderer.drawImage(character.getEquipment().getFoots().getIcon(), 1000, 150);
        }
    }
}
