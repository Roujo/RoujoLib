package roujo.lib.gui.windows;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;

public class GraphicWindow extends JFrame {
	private static final long serialVersionUID = 1L;

	// Graphics components
	private Canvas canvas; // Our drawing component
	private BufferStrategy buffer;
	private GraphicsEnvironment ge;
	private GraphicsDevice gd;
	private GraphicsConfiguration gc;
	private BufferedImage bi;
	private Graphics2D g2d;
	private Color background;

	public GraphicWindow(String title, int width, int height) {
		this.setTitle(title);
		this.setSize(width, height);
		setIgnoreRepaint(true);
		canvas = new Canvas();
		canvas.setIgnoreRepaint(true);
		canvas.setSize(width, height);
		add(canvas);
		pack();

		this.canvas.createBufferStrategy(2);
		this.buffer = canvas.getBufferStrategy();
		this.ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
		this.gd = ge.getDefaultScreenDevice();
		this.gc = gd.getDefaultConfiguration();
		this.bi = gc.createCompatibleImage(width, height);
		this.background = Color.BLACK;
	}

	/*
	 * public int getWidth() { return width; }
	 * 
	 * public int getHeight() { return height; }
	 */

	public Color getBackgroundColor() {
		return background;
	}

	public void setBackgroundColor(Color background) {
		this.background = background;
	}

	public Graphics2D getG2D() {
		this.g2d = bi.createGraphics();
		this.g2d.setColor(background);
		this.g2d.fillRect(0, 0, getWidth(), getHeight());
		return this.g2d;
	}

	public void draw() {
		Graphics graphics = buffer.getDrawGraphics();
		graphics.drawImage(bi, 0, 0, null);
		if (!buffer.contentsLost())
			buffer.show();

		graphics.dispose();
		this.g2d.dispose();
	}
}
