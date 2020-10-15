package fr.uge.poo.paint.ex9;

public class SimpleGraphicsFactory implements CanvasFactory {
	
	@Override
	public Canvas create(String name, int width, int height) {
		return new SimpleGraphicsAdaptateur(name, width, height);
	}
	
}