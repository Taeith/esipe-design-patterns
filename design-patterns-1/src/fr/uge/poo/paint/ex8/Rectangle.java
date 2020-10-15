package fr.uge.poo.paint.ex8;

public class Rectangle extends AbstractFigure {
	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y, width, height);
	}
	
	@Override
	public void draw(Canvas canvas, Canvas.Color color) {
		canvas.drawRectangle(this.x, this.y, this.width, this.height, color);		
	}
	
	@Override
	public String toString() {
		return "Rectangle " + super.toString();
	}		
	
}
