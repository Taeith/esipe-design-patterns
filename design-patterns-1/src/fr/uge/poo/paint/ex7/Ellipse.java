package fr.uge.poo.paint.ex7;

public class Ellipse extends AbstractFigure {
	
	public Ellipse(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	@Override
	public void draw(Canvas canvas, Canvas.Color color) {
		canvas.drawEllipse(x, y, width, height, color);
	}

	@Override
	public String toString() {
		return "Ellipse " + super.toString();
	}
	
}
