package dev.dmiitry.pong;

import java.awt.Color;

public class Game {
    public static String TITLE = "PONG";
    public static int WIDTH = 800;
    public static int HEIGHT = 600;
    private boolean shouldClose = false;

    public boolean isRunning() {
        return !shouldClose;
    }

    public void handleInput(Input input) {

    }

    public void setup() {
        
    }

    public void render(Renderer renderer) {
        renderer.fillRect(0, 0, 100, 100, Color.RED);
    }
}
