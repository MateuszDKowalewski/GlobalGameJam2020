package pl.dobberstudio.engine.gfx;

import java.util.Arrays;

public class Font {
    public final static Font STANDARD = new Font("res/font.png");
    public final static int LINE_HEIGHT = 25;

    private Image fontImage;
    private int offsets[];
    private int widths[];

    public Font(String path) {
        fontImage = new Image(path);
        offsets = new int[59];
        widths = new int[59];

        int unicode = 0;

        for(int i = 0; i < fontImage.getWidth(); i++) {
            if(fontImage.getPixels()[i] == 0xFF0000FF) {
                offsets[unicode] = i;
            }

            if(fontImage.getPixels()[i] == 0xFFFFFF00) {
                widths[unicode] = i - offsets[unicode] + 1;
                unicode++;
            }
        }
    }

    public Image getFontImage() {
        return fontImage;
    }

    public int[] getOffsets() {
        return offsets;
    }

    public int[] getWidths() {
        return widths;
    }

    @Override
    public String toString() {
        return "Font{" +
                "offsets=" + Arrays.toString(offsets) +
                ", widths=" + Arrays.toString(widths) +
                '}';
    }
}
