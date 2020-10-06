package fr.uge.poo.paint.ex6;

public abstract class AbstractFigure implements Figure {
	
	final int x;
	final int y;
	final int width;
	final int height;
	
	public AbstractFigure(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
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
	public int getX() {
		return this.x;
	}
	
	@Override
	public int getY() {
		return this.y;
	}
	
	@Override
	public int getWidth() {
		return this.width;
	}
	
	@Override
	public int getHeight() {
		return this.height;
	}

	@Override
	public String toString() {
		return "[x=" + this.x + ", y=" + this.y + ", width=" + this.width + ", height=" + this.height + "]";
	}
	
}
