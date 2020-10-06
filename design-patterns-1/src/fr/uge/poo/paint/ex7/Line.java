package fr.uge.poo.paint.ex7;

import java.awt.Graphics2D;

public class Line implements Figure {
	
	private int x1;
	private int x2;
	private int y1;
	private int y2;
	
	public Line(int x1, int x2, int y1, int y2) {
		this.x1 = x1;
		this.x2 = x2;
		this.y1 = y1;
		this.y2 = y2;
	}
	
	@Override
	public void draw(Canvas canvas, Canvas.Color color) {
		canvas.drawLine(x1, y1, x2, y2, color);
	}

	@Override
	public double distanceFrom(int x, int y) {
		int xA = x;
		int yA = y;
		int xB = (x1 + x2) / 2;
		int yB = (y1 + y2) / 2;
		return Math.sqrt((xB - xA)*(xB - xA) + (yB - yA)*(yB - yA));
	}

	@Override
	public String toString() {
		return "Line [x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + "]";
	}
	
}
