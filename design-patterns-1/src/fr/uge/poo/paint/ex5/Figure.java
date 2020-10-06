package fr.uge.poo.paint.ex5;

import java.awt.Graphics2D;

public interface Figure {
	
	public void draw(Graphics2D graphics);
	
	public double distanceFrom(int x, int y);
	
}
