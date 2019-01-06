package test;

public class GeneratorTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("Vornamen: ");
		System.out.println("_______________________________________________________________________");
		testVornamen();
		System.out.println("_______________________________________________________________________");
		System.out.println("");
		System.out.println("_______________________________________________________________________");
		System.out.println("Nachnamen: ");
		testNachname();
		System.out.println("_______________________________________________________________________");
		System.out.println("");
		System.out.println("_______________________________________________________________________");
		System.out.println("Namen: ");
		testName();

		
	}
	
	
	public static void testVornamen() {
		
		Generator g = new Generator();
		
		System.out.println("Teste 5 Vornamen: ");
		
		for(int i = 0; i < 5; i++)
			System.out.println(g.getRandomVorname());
		
	}
	
	public static void testNachname() {
		
		Generator g = new Generator();
		
		System.out.println("Teste 5 Nachnamen: ");
		
		for(int i = 0; i < 5; i++)
			System.out.println(g.getRandomNachname());
		
	}
	
	public static void testName() {
		
		Generator g = new Generator();
		
		System.out.println("Teste 5 Namen: ");
		
		for(int i = 0; i < 5; i++)
			System.out.println(g.getRandomVorname()+" "+g.getRandomNachname());
		
	}
	
	
	
	
	
/*	
 * public static void testeRandomIntGen() {
		
		Generator g = new Generator();
		
		for(int i = 0; i < 10; i++) {
			int res = g.getRandInt(0, 19);
			System.out.println(res);
		}
		
	}
	
*/	

}
