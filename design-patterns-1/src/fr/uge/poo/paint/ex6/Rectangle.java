package fr.uge.poo.paint.ex6;

import java.awt.Graphics2D;

public class Rectangle extends AbstractFigure {
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawRect(this.x, this.y, this.width, this.height);		
	}
	
	@Override
	public String toString() {
		return "Rectangle " + super.toString();
	}		
	
}
