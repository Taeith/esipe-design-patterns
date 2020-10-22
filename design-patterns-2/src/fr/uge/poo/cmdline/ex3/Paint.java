package fr.uge.poo.cmdline.ex3;

import java.awt.Color;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Paint {
	
	static private class PaintOptions {
		
        private String path = "";

        public void setPath(String path) {
            this.path = path;
        }

        public String getPath() {
            return path;
        }
        
    }
	
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
	
	private static void callback(SimpleGraphics area, Container container, int x, int y) {
		area.render(graphics -> {
			Figure highlighted = container.getHighlighted();
			if (highlighted != null) {
				graphics.setColor(Color.BLACK);
				highlighted.draw(graphics);
			}
			graphics.setColor(Color.RED);
			container.updateHighlighted(x, y);
			container.getHighlighted().draw(graphics);
		});
    }

	public static void main(String[] args) throws IOException {		
		String[] arguments = {"-path", "/src/fr/uge/poo/cmdline/ex3/figures.txt"};
		PaintOptions options = new PaintOptions();
        var cmdParser = new CmdLineParser();
        cmdParser.registerWithParameter("-path",  path -> options.setPath(path));
        cmdParser.process(arguments);
		Container container = new Container(readFile(options.getPath()));
		int[] windowSize = container.getWindowSize();
		SimpleGraphics area = new SimpleGraphics("area", windowSize[0], windowSize[1]);
        area.clear(Color.WHITE);
        area.render(graphics -> container.drawAll(graphics));
        area.waitForMouseEvents((x, y) -> callback(area, container, x, y));
	}

}