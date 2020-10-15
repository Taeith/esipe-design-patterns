package fr.uge.poo.paint.ex9;

public class CoolGraphicsFactory implements CanvasFactory {
	
	@Override
	public Canvas create(String name, int width, int height) {
		return new CoolGraphicsAdaptateur(name, width, height);
	}
	
}