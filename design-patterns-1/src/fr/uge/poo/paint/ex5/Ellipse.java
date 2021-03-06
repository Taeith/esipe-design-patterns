package fr.uge.poo.paint.ex5;

import java.awt.Graphics2D;

public class Ellipse extends AbstractFigure {
	
	public Ellipse(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(Graphics2D graphics) {
		graphics.drawOval(x, y, width, height);		
	}

	@Override
	public String toString() {
		return "Ellipse " + super.toString();
	}
	
}
