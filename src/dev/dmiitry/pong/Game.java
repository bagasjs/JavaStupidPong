package dev.dmiitry.pong;

import java.awt.Color;
import java.awt.event.KeyEvent;

public class Game implements Runnable {
    private Thread thread;
    private boolean shouldClose = false;
    private Renderer renderer;
    private Window window;
    private Input input;

    public Game() {
        window = new Window(GameConfig.TITLE, GameConfig.WIDTH, GameConfig.HEIGHT);
        renderer = new Renderer(window);
        input = new Input(window);
    }

    public void start() {
        thread = new Thread(this);
        thread.run();
    }

    public void stop() {

    }

    public void run() {
        while(!shouldClose) {
            if(input.isKeyPressed(KeyEvent.VK_ESCAPE)) {
                shouldClose = true;
                System.out.println("Closing the game");
                continue;
            }

            renderer.clear();
            renderer.fillRect(0, 0, 100, 100, Color.WHITE);
            window.update();
        }
        window.cleanUp();
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.start();
    }
}
