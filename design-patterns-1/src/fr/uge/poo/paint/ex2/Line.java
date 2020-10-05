package fr.uge.poo.paint.ex2;

import java.awt.Graphics2D;

public class Line {
	
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
	
	public void draw(Graphics2D graphics) {
		graphics.drawLine(x1, y1, x2, y2);
	}

	public String toString() {
		return "Line [x1=" + x1 + ", x2=" + x2 + ", y1=" + y1 + ", y2=" + y2 + "]";
	}
	
}
