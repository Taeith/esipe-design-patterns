package fr.uge.poo.ducks;

import java.util.ServiceLoader;

public class DuckFarmBetter {
	
	public static void main(String[] args) {
		
		var loader = ServiceLoader.load(fr.uge.poo.ducks.DuckFactory.class);
		
		var names = new String[] {
			"Riri", "Fifi", "Loulou"
		};
		
		for (DuckFactory duckFactory : loader) {
			for (var name : names) {
				System.out.println(duckFactory.withName(name).quack());
			}
		}
		
	}
	
}