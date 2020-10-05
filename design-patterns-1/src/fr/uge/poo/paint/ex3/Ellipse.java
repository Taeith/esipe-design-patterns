package fr.uge.poo.paint.ex3;

import java.awt.Graphics2D;

public class Ellipse implements Figure {
	
	int x;
	int y;
	int width;
	int height;
	
	public Ellipse(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawOval(x, y, width, height);		
	}

	@Override
	public String toString() {
		return "Ellipse [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}
	
}
