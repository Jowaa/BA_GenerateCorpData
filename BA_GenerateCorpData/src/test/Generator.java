package test;

import java.util.Random;

public class Generator {

	public Generator() {
		
	}
	
	public String getRandomVorname() {
		
		String result = null;
		
		
		String[] vornamen = { "Anna", "Alfred", "Andrea", "Robert", "Lisa", "Nils",	"Kate",	"Linus", "Kate", "Jan", "Franziska", "Franz", "Jana", "Viktor", "Melanie", "Henning", "Luisa", "Luca", "Johanna", "David"};
		
		result = vornamen[getRandInt(0,19)];
		
		return result;
		
	}
	
	public String getRandomNachname() {

		String result = null;
		
		
		String[] vornamen = { "Lebe", "Stirb", "Musterfrau", "Mustermann", "Brazzo", "Kovac", "Hummels", "Neuer", "Coman", "Gnabry", "Süle", "Alaba", "Müller", "Messi", "Zuckerberg", "Gates", "Jobs", "Page", "Zuse", "Schmitt"};
		
		result = vornamen[getRandInt(0,19)];
		
		return result;
		
	}
	
	public static int getRandInt(int min, int max) {
		int res;
		
		Random r = new Random();
		res = r.nextInt((max-min) + 1)+min;
		
		return res;
	}
	
}
