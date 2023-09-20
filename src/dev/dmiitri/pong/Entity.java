package dev.dmiitri.pong;

public interface Entity {
    public void setup(Settings settings);
    public void update(Renderer ren, Input in);
}
