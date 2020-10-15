package fr.uge.poo.paint.ex9;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.function.Consumer;

import fr.uge.poo.simplegraphics.SimpleGraphics;

public class SimpleGraphicsAdaptateur implements Canvas {
	
	private SimpleGraphics graphics;
	
	private ArrayList<Consumer<Graphics2D>> todos = new ArrayList<Consumer<Graphics2D>>();
	
	public SimpleGraphicsAdaptateur() {
		this.graphics = new SimpleGraphics("Example", 800, 600);
	}
	
	public SimpleGraphicsAdaptateur(String name, int width, int height) {
		this.graphics = new SimpleGraphics(name, width, height);
	}

	@Override
	public void drawLine(int x1, int y1, int x2, int y2, Color color) {
		todos.add(graphic2D -> {
			graphic2D.setColor(convertColor(color));
			graphic2D.drawLine(x1, y1, x2, y2);
		});
	}

	@Override
	public void drawRectangle(int x, int y, int width, int height, Color color) {
		todos.add(graphic2D -> {
			graphic2D.setColor(convertColor(color));
			graphic2D.drawRect(x, y, width, height);
		});
	}

	@Override
	public void drawEllipse(int x, int y, int width, int height, Color color) {
		todos.add(graphic2D -> {
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

	@Override
	public void render() {
		graphics.render(graphics2D -> {
			todos.stream()
			.forEach(consumer -> consumer.accept(graphics2D));
		});
			
	}

}
