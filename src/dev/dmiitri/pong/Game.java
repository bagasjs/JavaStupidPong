package dev.dmiitri.pong;

public class Game {
    private boolean shouldClose = false;
    private Settings settings;
    private Player player;
    private Ball ball;

    public Game(Settings s) {
        settings = s;
        player = new Player();
        ball = new Ball();
    }

    public boolean isRunning() {
        return !shouldClose;
    }

    public void setup() {
        player.setup(settings);
        ball.setup(settings);
    }

    public void update(Renderer renderer, Input input) {
        player.update(renderer, input);
        ball.update(renderer, input);
    }
}
