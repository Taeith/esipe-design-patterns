package fr.uge.poo.paint.ex7;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Paint {
	
	public static Figure readFigure(String line) {
		String[] tokens = ((String) line).split(" ");
		switch (tokens[0]) {
		case "line":
			return new Line(
					Integer.parseInt(tokens[1]),
					Integer.parseInt(tokens[3]),
					Integer.parseInt(tokens[2]),
					Integer.parseInt(tokens[4]));
		case "ellipse":
			return new Ellipse(
					Integer.parseInt(tokens[1]),
					Integer.parseInt(tokens[2]),
					Integer.parseInt(tokens[3]),
					Integer.parseInt(tokens[4]));
		case "rectangle":
			return new Rectangle(
					Integer.parseInt(tokens[1]),
					Integer.parseInt(tokens[2]),
					Integer.parseInt(tokens[3]),
					Integer.parseInt(tokens[4]));
		}
		return null;
	}
	
	public static void drawFile(Canvas canvas, Container container) {
		Path path = Paths.get(System.getProperty("user.dir") + "/src/fr/uge/poo/simplegraphics/figures.txt");
		try (Stream<String> fileStream = Files.lines(path)) {
			for (String line : fileStream.collect(Collectors.toList())) {
				Figure figure = readFigure(line);
				figure.draw(canvas, Canvas.Color.BLACK);
				container.add(figure);
			}
		} catch(IOException exception) {
			throw new AssertionError();
		}		
	}
	
	private static void callback(Canvas canvas, Container container, int x, int y) {
		Figure highlighted = container.getHighlighted();
		if (highlighted != null) {
			highlighted.draw(canvas, Canvas.Color.BLACK);
		}
		container.updateHighlighted(x, y);
		container.getHighlighted().draw(canvas, Canvas.Color.RED);
    }

	public static void main(String[] args) throws IOException {
		Canvas canvas = null;
		if (args.length > 0 && "-legacy".equals(args[0])) {
			canvas = new SimpleGraphicsAdaptateur();
		} else {
			canvas = new CoolGraphicsAdaptateur();
		}
		Container container = new Container();
		canvas.clear(Canvas.Color.WHITE);
		drawFile(canvas, container);
		final Canvas canvas2 = canvas;
        canvas.waitOnClick((x, y) -> callback(canvas2, container, x, y));
	}

}
