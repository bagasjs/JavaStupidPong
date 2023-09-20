package dev.dmiitri.pong;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Player implements Entity {
    private int x, y;
    private int width, height;
    private Color color = Color.BLUE;
    private int veloc;

    public void setup(Settings settings) {
        width = 10;
        height = settings.screenHeight/10;
        x = (int)(settings.screenWidth * 1/10);
        y = 0;
        veloc = settings.veloc;
    }

    public void update(Renderer ren, Input in) {
        ren.fillRect(x, y, width, height, color);
        if(in.isKeyPressed(KeyEvent.VK_UP)) {
            y -= veloc;
        }
        if(in.isKeyPressed(KeyEvent.VK_DOWN)) {
            y += veloc;
        }
    }
}
