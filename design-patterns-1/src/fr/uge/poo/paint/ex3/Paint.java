package fr.uge.poo.paint.ex3;

import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import fr.uge.poo.simplegraphics.SimpleGraphics;

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
	
	public static void drawFile(Graphics2D graphics) {
		Path path = Paths.get(System.getProperty("user.dir") + "/src/fr/uge/poo/simplegraphics/figures.txt");
		graphics.setColor(Color.BLACK);
		try (Stream<String> fileStream = Files.lines(path)) {
			for (String line : fileStream.collect(Collectors.toList())) {
				Figure figure = readFigure(line);
				figure.draw(graphics);
			}
		} catch(IOException exception) {
			throw new AssertionError();
		}		
	}

	public static void main(String[] args) throws IOException {
		SimpleGraphics area = new SimpleGraphics("area", 800, 600);
        area.clear(Color.WHITE);
        area.render(graphics -> drawFile(graphics));
	}

}
