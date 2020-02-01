package pl.dobberstudio.game.gui;

import pl.dobberstudio.engine.GameContainer;
import pl.dobberstudio.engine.Renderer;
import pl.dobberstudio.engine.gfx.Image;
import pl.dobberstudio.game.Character;
import pl.dobberstudio.game.CurrentLocation;
import pl.dobberstudio.game.GameManager;
import pl.dobberstudio.game.locations.city.MapLocation;

public class Stats
{
    private String path;
    private Character character;
    private Image bar;
    private MapLocation avatar;
    private MapLocation girl;
    public Stats(GameManager gm, String path, Character character)
    {
        this.path = path;
        this.character = character;
        bar = new Image(path);
        avatar = new MapLocation(gm, "avatar.png", 19, 19);
        avatar.setOnClick(new Runnable() {
            @Override
            public void run()
            {
                gm.setLocation(CurrentLocation.CHARACTER_PANEL);
            }
        });
        girl = new MapLocation(gm, "girl_icon.png", 19, 285);
        girl.setOnClick(new Runnable() {
            @Override
            public void run()
            {
                gm.setLocation(CurrentLocation.WAIFU_PANEL);
            }
        });

    }
    public void update(GameContainer gc, double deltaTime)
    {
            avatar.isClicked(gc);
            girl.isClicked(gc);
    }

    public void render(GameContainer gc, Renderer renderer)
    {
        renderer.drawImage(bar, 0, 0);
        avatar.render(gc, renderer);
        girl.render(gc, renderer);
        renderer.drawText(Integer.toString(character.getHunger()) + " / " + Integer.toString(character.MAX_HUNGER), 55, 140, 0xFFAA06BA);
        renderer.drawText(Integer.toString(character.getTiredness()) + " / " + Integer.toString(character.MAX_TIREDNESS), 55, 190, 0xFFAA06BA);
        renderer.drawText(Integer.toString(character.getMoney()) + "$", 55, 240, 0xFFAA06BA);
    }
}
