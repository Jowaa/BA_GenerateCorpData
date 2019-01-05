package test;

public class DBTest {

	static {
		try {
			System.out.println("Treiber wird geladen...");
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			System.out.println("Fehler beim Laden des Treibers..");
			e.printStackTrace();
			System.exit(0);;
		}
		System.out.println("Treiber erfolgreich geladen.");
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
