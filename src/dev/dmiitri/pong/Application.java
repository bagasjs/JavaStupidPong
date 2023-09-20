package dev.dmiitri.pong;

import java.awt.event.KeyEvent;

public class Application implements Runnable {
    private Thread thread;
    private Renderer renderer;
    private Settings settings;
    private Window window;
    private Input input;
    private Game game;

    public Application() {
        settings = new Settings();

        game = new Game(settings);
        window = new Window(settings.title, settings.screenWidth, settings.screenHeight);
        renderer = new Renderer(window);
        input = new Input(window);
    }

    public void start() {
        thread = new Thread(this);
        thread.run();
    }

    public void run() {
        game.setup();
        while(game.isRunning()) {
            renderer.clear();
            if(input.isKeyPressed(KeyEvent.VK_ESCAPE)) {
                break;
            }
            game.update(renderer, input);
            // TODO: add FPS limitter
            window.update();
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
