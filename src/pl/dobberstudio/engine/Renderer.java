package pl.dobberstudio.engine;

import pl.dobberstudio.engine.gfx.Font;
import pl.dobberstudio.engine.gfx.Image;

import java.awt.image.DataBufferInt;

public class Renderer {
    Window w;

    private Font font = Font.STANDARD;

    private int pW, pH;
    private int[] p;

    public Renderer(GameContainer gc, Window w) {
        pW = GameContainer.WIDTH;
        pH = GameContainer.HEIGHT;
        p = ((DataBufferInt)gc.getWindow().getImage().getRaster().getDataBuffer()).getData();
        this.w = w;
    }

    public void clear() {
        for(int i = 0; i < p.length; i++) {
            p[i] = 0xFF000000;
        }
    }

    public void setPixel(int x, int y, int value) {
        if(x < 0 || x >= pW || y < 0 || y >= pH || value == -15584170 || value>>>(6 * 4) < 0x10) {
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

    public void drawText(String text, int offX, int offY, int color) {
        text = text.toUpperCase();
        int offsetX = 0;
        int offsetY = 0;

        for(int i = 0; i < text.length(); i++) {
            if(text.codePointAt(i) == 10) {
                offsetX = 0;
                offsetY += Font.LINE_HEIGHT;
            } else {
                int unicode = text.codePointAt(i) - 32;
                for (int y = 0; y < font.getFontImage().getHeight(); y++) {
                    for (int x = 0; x < font.getWidths()[unicode]; x++) {
                        if (font.getFontImage().getPixels()[(x + font.getOffsets()[unicode]) + y * font.getFontImage().getWidth()] == 0xFFFFFFFF) {
                            setPixel(x + offX + offsetX, y + offY + offsetY, color);
                        }
                    }
                }
                offsetX += font.getWidths()[unicode];
            }
        }
    }

    public void drawRect(int offX, int offY, int w, int h, int color) {
        for(int y = 0; y < h; y++) {
            for(int x = 0; x < w; x++) {
                setPixel(x + offX, y + offY, color);
            }
        }
    }
}
