package fr.uge.poo.paint.ex5;

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
	public double distanceFrom(int x, int y) {
		int xA = x;
		int yA = y;
		int xB = this.x + (width / 2);
		int yB = this.y + (height / 2);
		return Math.sqrt((xB - xA)*(xB - xA) + (yB - yA)*(yB - yA));
	}

	@Override
	public String toString() {
		return "Rectangle [x=" + x + ", y=" + y + ", width=" + width + ", height=" + height + "]";
	}	
	
}
