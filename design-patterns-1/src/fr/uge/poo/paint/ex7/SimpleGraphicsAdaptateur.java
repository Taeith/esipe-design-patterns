package fr.uge.poo.paint.ex7;

import fr.uge.poo.simplegraphics.SimpleGraphics;

public class SimpleGraphicsAdaptateur implements Canvas {
	
	private SimpleGraphics graphics = new SimpleGraphics("area", 800, 600);

	@Override
	public void drawLine(int x1, int y1, int x2, int y2, Color color) {
		graphics.render(graphic2D -> {
			graphic2D.setColor(convertColor(color));
			graphic2D.drawLine(x1, y1, x2, y2);
		});
	}

	@Override
	public void drawRectangle(int x, int y, int width, int height, Color color) {
		graphics.render(graphic2D -> {
			graphic2D.setColor(convertColor(color));
			graphic2D.drawRect(x, y, width, height);
		});
	}

	@Override
	public void drawEllipse(int x, int y, int width, int height, Color color) {
		graphics.render(graphic2D -> {
			graphic2D.setColor(convertColor(color));
			graphic2D.drawOval(x, y, width, height);
		});
	}	

	@Override
	public void waitOnClick(MouseCallback2 mouseCallback) {
		graphics.waitForMouseEvents((x, y) -> mouseCallback.click(x, y));
	}	
	
	@Override
	public void clear(Color color) {
		graphics.clear(convertColor(color));
	}

	public java.awt.Color convertColor(Canvas.Color color) {
		switch (color) {
		case BLACK:
			return java.awt.Color.black;
		case WHITE:
			return java.awt.Color.white;
		case RED:
			return java.awt.Color.red;
		}
		return null;
	}

}
