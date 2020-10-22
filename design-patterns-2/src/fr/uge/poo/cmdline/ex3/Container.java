package fr.uge.poo.cmdline.ex3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

public class Container {
	
	private ArrayList<Figure> figures = new ArrayList<>();
	private int highlighted;
	
	public Container(ArrayList<Figure> figures) {
		this.figures = figures;
		this.highlighted = Integer.MIN_VALUE;
	}
	
	public void drawAll(Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		for (Figure figure : figures) {
			figure.draw(graphics);
		}
	}
	
	public int size() {
		return figures.size();
	}
	
	private int getClosestTo(int x, int y) {
		double minimum = Double.MAX_VALUE;
		int index = Integer.MIN_VALUE;
        for (int i = 0; i < figures.size(); i++) {
        	double distance = figures.get(i).distanceFrom(x, y);        	
        	if (distance < minimum) {
        		minimum = distance;
        		index = i;
        	}
        }
        return index;
	}
	
	public Figure getHighlighted() {
		if (highlighted != Integer.MIN_VALUE) {
			return figures.get(highlighted);
		}
		return null;
	}
	
	public void updateHighlighted(int x, int y) {
		this.highlighted = getClosestTo(x, y);
	}
	
	public int[] getWindowSize() {
		if (figures.isEmpty()) {
			return new int[] {
				0, 0
			};
		}
		int x = figures.stream().mapToInt(figure -> (figure.getX() + figure.getWidth())).max().getAsInt();
		int y = figures.stream().mapToInt(figure -> (figure.getY() + figure.getHeight())).max().getAsInt();
		return new int[] {
			x > 500 ? x : 500,
			y > 500 ? y : 500
		};
	}

}
