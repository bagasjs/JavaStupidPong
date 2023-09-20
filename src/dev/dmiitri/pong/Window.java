package dev.dmiitri.pong;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class Window {
    private JFrame frame;
    private Canvas canvas;
    private BufferedImage image;
    private Graphics g;
    private BufferStrategy bs;

    public Window(String title, int width, int height) {
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        canvas = new Canvas();
        Dimension s = new Dimension(width, height);
        canvas.setPreferredSize(s);
        canvas.setMaximumSize(s);

        frame = new JFrame(title);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(canvas, BorderLayout.CENTER);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        canvas.createBufferStrategy(2);
        bs = canvas.getBufferStrategy();
        g = bs.getDrawGraphics();
    }

    public void update() {
        g.drawImage(image, 0, 0, canvas);
        bs.show();
    }

    public void cleanUp()
	{
		g.dispose();
		bs.dispose();
		image.flush();
		frame.dispose();
	}

	public Canvas getCanvas()
	{
		return canvas;
	}

	public BufferedImage getImage()
	{
		return image;
	}
}
