package dev.dmiitry.pong;

public class Application implements Runnable {
    private Thread thread;
    private Renderer renderer;
    private Window window;
    private Input input;
    private Game game;

    public Application() {
        game = new Game();
        window = new Window(Game.TITLE, Game.WIDTH, Game.HEIGHT);
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

            game.handleInput(input);

            renderer.clear();

            game.render(renderer);

            window.update();
        }
    }

    public static void main(String[] args) {
        Application app = new Application();
        app.start();
    }
}
