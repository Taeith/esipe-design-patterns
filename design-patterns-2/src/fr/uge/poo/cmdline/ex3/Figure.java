package fr.uge.poo.cmdline.ex3;

import java.awt.Graphics2D;

public interface Figure {
	
	public void draw(Graphics2D graphics);
	
	public double distanceFrom(int x, int y);
	
	public int getX();
	
	public int getY();
	
	public int getWidth();
	
	public int getHeight();
	
}
