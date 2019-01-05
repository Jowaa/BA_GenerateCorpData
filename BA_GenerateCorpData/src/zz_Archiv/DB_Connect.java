package zz_Archiv;
import java.sql.*;


public class DB_Connect {

	final String hostname = "192.168.178.34";
	final String port = "3306";
	final String dbname = "test";
	final String user = "root";
	final String password = "mond2395";
	
	public DB_Connect() {
		
	}
	
	public Connection erstelleVerbindung() {
		
		Connection conn = null;
		
		
		try {
			System.out.println("Treiber laden...");
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			System.out.println("Unable to load driver.");
			e.printStackTrace();
		}
		try {
			System.out.println("Verbindung aufbauen...");
			String url = "jdbc:mysql://"+hostname+":"+port+"/"+dbname;
			conn = DriverManager.getConnection(url, user, password);
		}
		catch (SQLException sqle) {
			System.out.println("SQLException: "+ sqle.getMessage());
			System.out.println("SQLStat: "+ sqle.getSQLState());
			System.out.println("VendorError: "+ sqle.getErrorCode());
			sqle.printStackTrace();
		}
		
		
		if(conn != null)
			return conn;
		else
			return null;
		
	}
	
	public boolean testTreiber() {
		
		try {
			System.out.println("Treiber laden...");
			Class.forName("org.hsqldb.jdbcDriverr").newInstance();
		}
		catch (Exception e) {
			System.out.println("Unable to load driver.");
			e.printStackTrace();
		}
		return true;
	}
	
}
