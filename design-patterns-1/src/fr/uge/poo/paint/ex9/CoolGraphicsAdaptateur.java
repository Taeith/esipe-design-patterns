package fr.uge.poo.paint.ex9;

import java.util.ArrayList;

import fr.uge.poo.coolgraphics.CoolGraphics;

public class CoolGraphicsAdaptateur implements Canvas {
	
	private CoolGraphics graphics;
	
	private ArrayList<Runnable> todos = new ArrayList<Runnable>();
	
	public CoolGraphicsAdaptateur() {
		this.graphics = new CoolGraphics("Example", 800, 600);
	}
	
	public CoolGraphicsAdaptateur(String name, int width, int height) {
		this.graphics = new CoolGraphics(name, width, height);
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2, Color color) {
		todos.add(() -> graphics.drawLine(x1, y1, x2, y2, convertColor(color)));
	}

	@Override
	public void drawRectangle(int x, int y, int width, int height, Color color) {
		todos.add(() -> graphics.drawLine(x, y, x + width, y, convertColor(color)));
		todos.add(() -> graphics.drawLine(x, y, x, y + height, convertColor(color)));
		todos.add(() -> graphics.drawLine(x + width, y + height, x + width, y, convertColor(color)));
		todos.add(() -> graphics.drawLine(x + width, y + height, x, y + height, convertColor(color)));
	}

	@Override
	public void drawEllipse(int x, int y, int width, int height, Color color) {
		todos.add(() -> graphics.drawEllipse(x, y, width, height, convertColor(color)));
	}	

	@Override
	public void waitOnClick(MouseCallback2 mouseCallback) {
		todos.add(() -> graphics.waitForMouseEvents((x, y) -> mouseCallback.click(x, y)));
	}	
	
	@Override
	public void clear(Color color) {
		todos.add(() -> graphics.repaint(convertColor(color)));
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

	@Override
	public void render() {
		todos.stream().forEach(runnable -> runnable.run());
	}

}
