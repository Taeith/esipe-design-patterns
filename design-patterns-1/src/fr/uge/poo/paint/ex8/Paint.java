package fr.uge.poo.paint.ex8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.ServiceLoader;
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
	
	public static ArrayList<Figure> readFile(String path) {
		ArrayList<Figure> figures = new ArrayList<>();
		try (Stream<String> fileStream = Files.lines(Paths.get(System.getProperty("user.dir") + path))) {
			for (String line : fileStream.collect(Collectors.toList())) {
				figures.add(readFigure(line));
			}
		} catch(IOException exception) {
			throw new AssertionError();
		}
		return figures;
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
			canvas = ServiceLoader.load(fr.uge.poo.paint.ex8.CanvasFactory.class)
					.findFirst()
					.orElse(new SimpleGraphicsFactory())
					.create("Example", 800, 600);
		} else {
			canvas = new SimpleGraphicsAdaptateur("Example", 800, 600);
		}
		Container container = new Container(readFile("/src/fr/uge/poo/simplegraphics/figures.txt"));
		canvas.clear(Canvas.Color.WHITE);
		container.drawAll(canvas, Canvas.Color.BLACK);
		final Canvas canvas2 = canvas;
        canvas.waitOnClick((x, y) -> callback(canvas2, container, x, y));
	}

}
