import java.sql.*;

public class Main {

	public static void main(String[] args) {
		
		boolean testCon = db_connectTEST(); //--> funktioniert nicht

		
	}
	
	private static boolean db_connectTEST() {
		
		Connection conn = null;
		DB_Connect dbconn = new DB_Connect();
		
		conn = dbconn.erstelleVerbindung();
		
		
		if(conn == null) {
			System.out.println("Fehler");
			return false;
		}else {
			System.out.println("Erfolgreich");
			return true;
		}
	}
	
}
