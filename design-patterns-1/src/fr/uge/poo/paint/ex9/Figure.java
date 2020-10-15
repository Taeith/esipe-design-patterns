package fr.uge.poo.paint.ex9;

public interface Figure {
	
	public void draw(Canvas canvas, Canvas.Color color);
	
	public double distanceFrom(int x, int y);
	
	public int getX();
	
	public int getY();
	
	public int getWidth();
	
	public int getHeight();
	
}
