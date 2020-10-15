package fr.uge.poo.paint.ex9;

public interface Canvas {
	
	public enum Color {
		BLACK, WHITE, RED
	}
	
	public interface MouseCallback2 {
		 public void click(int x, int y);
	}
	
	public void render();
	
	public void drawLine(int x1, int y1, int x2, int y2, Color color);
	
	public void drawRectangle(int x, int y, int width, int height, Color color);
	
	public void drawEllipse(int x, int y, int width, int height, Color color);
	
	public void clear(Color color);
	
	public void waitOnClick(MouseCallback2 mouseCallback);

}
