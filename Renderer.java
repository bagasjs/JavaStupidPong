package dev.dmiitry.pong;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;

public class Renderer {
    private Window window;
    private int[] pixels;
    private Color clearColor = Color.BLACK;
    private int viewportWidth, viewportHeight;
    private Map<String, BufferedImage> images;

    public Renderer(Window win) {
        window = win;
        pixels = ((DataBufferInt)window.getImage().getRaster().getDataBuffer()).getData();
        viewportWidth = win.getImage().getWidth();
        viewportHeight = win.getImage().getHeight();

        images = new HashMap<>();
    }

    public void setPixel(int x, int y, Color color) {
		if ((x < 0 || x >= viewportWidth || y < 0 || y >= viewportHeight) || color == clearColor)
			return;
        pixels[x + y * viewportWidth] = color.getRGB();
    }

    public void fillRect(int x, int y, int width, int height, Color color) {
        for(int i = y; i < y + height; i++) {
            for(int j = x; j < x + width; j++) {
                setPixel(j, i, color);
            }
        }
    }

    public BufferedImage loadImageFromFile(String filePath) {
        try {
            if(images.containsKey(filePath)) {
                return images.get(filePath);
            } else {
                BufferedImage image = ImageIO.read(new File(filePath));
                images.put(filePath, image);
                return image;
            }
        } catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void drawImage(int x, int y, BufferedImage image) {
        int width = image.getWidth();
        int height = image.getHeight();
        int[] pixels = ((DataBufferInt)image.getRaster().getDataBuffer()).getData();

        for(int i = y; i < y + height; i++) {
            for(int j = x; j < x + width; j++) {
                setPixel(j, i, new Color(pixels[j + i*width]));
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
