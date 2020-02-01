package pl.dobberstudio.engine;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Window {
    private JFrame frame;
    private BufferedImage image;
    private Canvas canvas;
    private BufferStrategy bs;
    private Graphics g;

    public Window(GameContainer gc) {
        image = new BufferedImage(GameContainer.WIDTH, GameContainer.HEIGHT, BufferedImage.TYPE_INT_ARGB);

        canvas = new Canvas();
        Dimension s = new Dimension((int)(GameContainer.WIDTH * GameContainer.SCALE), (int)(GameContainer.HEIGHT * GameContainer.SCALE));
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);
        canvas.setMinimumSize(s);

        frame = new JFrame(GameContainer.TITLE);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        //frame.setLocation();
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public void update() {
        g.drawImage(image, 0, 0, canvas.getWidth(), canvas.getHeight(), null);
        bs.show();
    }

    public JFrame getFrame() {
        return frame;
    }

    public BufferedImage getImage() {
        return image;
    }

    public Canvas getCanvas() {
        return canvas;
    }

    public BufferStrategy getBs() {
        return bs;
    }

    public Graphics getG() {
        return g;
    }

    public void print(String s, int x, int y) {
        try {
            Font f = Font.createFont(Font.TRUETYPE_FONT, new File("res/comici.ttf")).deriveFont(Font.PLAIN, 40);
            System.out.println("str");
            g.setColor(Color.WHITE);
            g.setFont(f);
            g.drawString("QWERTYU", 10, 10);
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
