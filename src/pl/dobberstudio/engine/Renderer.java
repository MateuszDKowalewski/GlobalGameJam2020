package pl.dobberstudio.engine;

import pl.dobberstudio.engine.gfx.Image;

import java.awt.image.DataBufferInt;

public class Renderer {
    private int pW, pH;
    private int[] p;

    public Renderer(GameContainer gc) {
        pW = GameContainer.WIDTH;
        pH = GameContainer.HEIGHT;
        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
    }

    public void clear() {
        for(int i = 0; i < p.length; i++) {
            p[i] = 0xFF000000;
        }
    }

    public void setPixel(int x, int y, int value) {
        if(x < 0 || x >= pW || y < 0 || y >= pH || value == -15584170) {
            return;
        }

        p[x + y * pW] = value;
    }

    public void drawImage(Image img, int offX, int offY) {
        for(int y = 0; y < img.getHeight(); y++) {
            for(int x = 0; x < img.getWidth(); x++) {
                setPixel(x + offX, y + offY, img.getPixels()[x + y * img.getWidth()]);
            }
        }
    }
}
