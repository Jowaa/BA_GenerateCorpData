package test;

public class DBTest {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println("Verbindungstest: ");
		System.out.println("_______________________________________________________________________");
		runVerbindungstest();
		System.out.println("_______________________________________________________________________");
		System.out.println("");
		System.out.println("_______________________________________________________________________");
		System.out.println("Statement Test: ");
		System.out.println("_______________________________________________________________________");
		runTesteStatement();
		
		
	}
	
	public static void runVerbindungstest() {
		
		Database db = new Database();
		
		db.erstelleVerbindung();
		db.schlie�eVerbindung();
		
	}
	
	public static void runTesteStatement() {
		
		Database db = new Database();
		
		db.erstelleVerbindung();
		db.erstelleStudentTabelle();
		db.l�scheStudentTabelle();
		db.schlie�eVerbindung();
	}
	
}
