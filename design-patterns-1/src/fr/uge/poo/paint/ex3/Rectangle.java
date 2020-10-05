package fr.uge.poo.paint.ex3;

import java.awt.Graphics2D;

public class Rectangle implements Figure {
	
	int x;
	int y;
	int width;
	int height;
	
	public Rectangle(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawRect(x, y, width, height);		
	}

	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}	
	
}
