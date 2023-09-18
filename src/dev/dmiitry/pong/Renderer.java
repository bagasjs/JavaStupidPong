package dev.dmiitry.pong;

import java.awt.Color;
import java.awt.image.DataBufferInt;

public class Renderer {
    private Window window;
    private int[] pixels;
    private Color clearColor = Color.BLACK;
    private int viewportWidth, viewportHeight;

    public Renderer(Window win) {
        window = win;
        pixels = ((DataBufferInt)window.getImage().getRaster().getDataBuffer()).getData();
        viewportWidth = win.getImage().getWidth();
        viewportHeight = win.getImage().getHeight();
    }

    public void setPixel(int x, int y, Color color) {
		if ((x < 0 || x >= viewportWidth || y < 0 || y >= viewportHeight) || color == clearColor)
			return;
        pixels[x + y * viewportWidth] = color.getRGB();
    }

    public void fillRect(int x, int y, int width, int height, Color color) {
        for(int i = y; i < y + height; i++) {
            for(int j = x; j < x + width; j++) {
                setPixel(i, j, color);
            }
        }
    }

	public void clear()
	{
        for(int i = 0; i < viewportWidth*viewportHeight; i++) {
            pixels[i] = clearColor.getRGB();
        }
	}

    public void setClearColor(Color color) {
        clearColor = color;
    }
}
