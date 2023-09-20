package dev.dmiitri.pong;

import java.awt.Color;

public class Ball implements Entity {
    int cx, cy, rad;
    Color color;

    public void setup(Settings settings) {
        cx = settings.screenWidth/2;
        cy = settings.screenHeight/2;
        rad = 10;
        color = Color.GREEN;
    }

    public void update(Renderer ren, Input in) {
        ren.fillCircle(cx, cy, rad, color);
    }
}
