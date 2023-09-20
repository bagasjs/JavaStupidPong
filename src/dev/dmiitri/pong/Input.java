package dev.dmiitri.pong;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class Input implements KeyListener, MouseListener, MouseMotionListener {
    private boolean[] keys = new boolean[256];
    private boolean[] keysLast = new boolean[256];
	private boolean[] buttons = new boolean[5];
	private boolean[] buttonsLast = new boolean[5];
    private int mouseX, mouseY;

    public Input(Window window) {
        window.getCanvas().addKeyListener(this);
        window.getCanvas().addMouseListener(this);
        window.getCanvas().addMouseMotionListener(this);
    }
	public void update()
	{
		keysLast = keys.clone();
		buttonsLast = buttons.clone();
	}
	
	public int getMouseX()
	{
		return mouseX;
	}

    public int getMouseY()
	{
		return mouseY;
	}
    
	public boolean isKey(int keyCode)
	{
		return keys[keyCode];
	}
	
	public boolean isKeyPressed(int keyCode)
	{
		return keys[keyCode] && !keysLast[keyCode];
	}
	
	public boolean isKeyReleased(int keyCode)
	{
		return !keys[keyCode] && keysLast[keyCode];
	}
	
	public boolean isButton(int button)
	{
		return buttons[button];
	}
	
	public boolean isButtonPressed(int button)
	{
		return buttons[button] && !buttonsLast[button];
	}
	
	public boolean isButtonReleased(int button)
	{
		return !buttons[button] && buttonsLast[button];
	}

	@Override
	public void mouseDragged(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e)
	{
		mouseX = e.getX();
		mouseY = e.getY();
	}

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
		buttons[e.getButton()] = true;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
		buttons[e.getButton()] = false;
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
    }
}
