package fr.uge.poo.paint.ex7;

import java.util.ArrayList;

public class Container {
	
	private ArrayList<Figure> figures = new ArrayList<>();
	private int highlighted;
	
	public Container(ArrayList<Figure> figures) {
		this.figures = figures;
		this.highlighted = Integer.MIN_VALUE;
	}
	
	public void drawAll(Canvas canvas, Canvas.Color color) {
		for (Figure figure : figures) {
			figure.draw(canvas, color);
		}
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

}
