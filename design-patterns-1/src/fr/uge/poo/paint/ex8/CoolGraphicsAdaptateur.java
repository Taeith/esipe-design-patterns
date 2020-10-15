package fr.uge.poo.paint.ex8;

import fr.uge.poo.coolgraphics.CoolGraphics;

public class CoolGraphicsAdaptateur implements Canvas {
	
	private CoolGraphics graphics;
	
	public CoolGraphicsAdaptateur() {
		this.graphics = new CoolGraphics("Example", 800, 600);
	}
	
	public CoolGraphicsAdaptateur(String name, int width, int height) {
		this.graphics = new CoolGraphics(name, width, height);
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2, Color color) {
		graphics.drawLine(x1, y1, x2, y2, convertColor(color));
	}

	@Override
	public void drawRectangle(int x, int y, int width, int height, Color color) {
		graphics.drawLine(x, y, x + width, y, convertColor(color));
		graphics.drawLine(x, y, x, y + height, convertColor(color));
		graphics.drawLine(x + width, y + height, x + width, y, convertColor(color));
		graphics.drawLine(x + width, y + height, x, y + height, convertColor(color));
	}

	@Override
	public void drawEllipse(int x, int y, int width, int height, Color color) {
		graphics.drawEllipse(x, y, width, height, convertColor(color));
	}	

	@Override
	public void waitOnClick(MouseCallback2 mouseCallback) {
		graphics.waitForMouseEvents((x, y) -> mouseCallback.click(x, y));
	}	
	
	@Override
	public void clear(Color color) {
		graphics.repaint(convertColor(color));
	}

	public CoolGraphics.ColorPlus convertColor(Canvas.Color color) {
		switch (color) {
		case BLACK:
			return CoolGraphics.ColorPlus.BLACK;
		case WHITE:
			return CoolGraphics.ColorPlus.WHITE;
		case RED:
			return CoolGraphics.ColorPlus.RED;
		}
		return null;
	}

}
