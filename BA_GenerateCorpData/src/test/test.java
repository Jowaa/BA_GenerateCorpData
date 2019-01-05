package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Treiber Test:
		testeTreiber();
		
		//Verbindungstest:
		testeVerbindungZuDB();
		
		//DBErstellen TEST
		testeDBErstellen();
		
	}

	/*
	 * Teste JDBC Treiber
	 */
	
	public static void testeTreiber() {
		
		System.out.println("--- Treiber wird getestet ---");
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
	/*
	 * teste Verbindungsaufbau
	 */
	
	public static void testeVerbindungZuDB() {
		
		System.out.println("--- Verbindung zur Datenbank wird erstellt und getestet ---");
		System.out.println("Treiber wird geladen: ");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			System.out.println("Fehler beim Laden des Treibers.");
			e.printStackTrace();
		}
		System.out.println("Treiber wurde geladen.");
		
		System.out.println("Teste Verbindungsaufbau...");
		System.out.println("Starte Verbindungsaufbau...");
		
		String ip = "192.168.213.128";
		String port = "3306";
		String dbname = "test";
		String user = "jonas";
		String pw = "1234";
		
		Connection con = null;
		
		try {
			System.out.println("Verbindung aufbauen...");
			String url = "jdbc:mysql://"+ip+":"+port+"/"+dbname + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
			con = DriverManager.getConnection(url, user, pw);
		}
		catch (SQLException sqle) {
			System.out.println("Verbindung konnte nicht hergestellt werden...");
			System.out.println("SQLException: "+ sqle.getMessage());
			System.out.println("SQLStat: "+ sqle.getSQLState());
			System.out.println("VendorError: " + sqle.getErrorCode());
			sqle.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("Verbindung zur Datenbank konnte erfolgreich hergestellt werden.");
		
		try {
			con.close();
		}
		catch (SQLException sqle) {
			System.out.println("Fehler beim Verbindung schlieﬂen");
			System.out.println("SQLException: "+ sqle.getMessage());
			System.out.println("SQLStat: "+ sqle.getSQLState());
			System.out.println("VendorError: " + sqle.getErrorCode());
		}
		
		System.out.println("Verbindung wurde geschlossen.");
		
	}
	
	public static void testeDBErstellen() {
		
		System.out.println("Lade Treiber...");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch (Exception e) {
			System.out.println("Fehler beim Laden des Treibers.");
			e.printStackTrace();
		}
		
		System.out.println("Erstelle Verbindung...");
		String ip = "192.168.213.128";
		String port = "3306";
		String dbname = "test";
		String user = "jonas";
		String pw = "1234";
		
		Connection con = null;
		
		try {
			String url = "jdbc:mysql://"+ip+":"+port+"/"+ "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
			con = DriverManager.getConnection(url, user, pw);
		}
		catch (SQLException sqle) {
			System.out.println("Verbindung konnte nicht hergestellt werden...");
			System.out.println("SQLException: "+ sqle.getMessage());
			System.out.println("SQLStat: "+ sqle.getSQLState());
			System.out.println("VendorError: " + sqle.getErrorCode());
			sqle.printStackTrace();
			System.exit(0);
		}
		
		System.out.println("Verbindung wurde hergestellt...");
		/*
		 * ________________________________________________________________________________________________
		 */
		System.out.println("Erstelle Datenbank 'TestDB'");
		
		String dbName = "Jonas";
		
		String q01 = "CREATE DATABASE IF NOT EXISTS "+dbname+"";
//		String q02 = "USE "+dbname+"";
//		String q03 = "SET SQL_MODE='NO_AUTO_VALUE_ON_ZERO'; "; 
/*		String q04 = "CREATE TABLE IF NOT EXISTS `Studenten` ("
                + "`Name` varchar(100) NOT NULL DEFAULT '', "
                + "`Vorname` varchar(100) NOT NULL DEFAULT '', "
                + "`ID` varchar(50) NOT NULL, " + "UNIQUE KEY `ID` (`ID`)"
                + ") ENGINE=MyISAM DEFAULT CHARSET=utf8 "
                + "DEFAULT COLLATE=utf8_german2_ci";
*/		//String q05 = "DROP DATABASE IF EXISTS "
		
		Statement stmt = null;
		
		try {
			con.setAutoCommit(false);
			stmt = con.createStatement();
			System.out.println("Erstelle TestDB");
			stmt.addBatch(q01);
/*			System.out.println("Nutze TestDB");
			stmt.addBatch(q02);
			stmt.addBatch(q03);
			System.out.println("Erstelle Tabelle Studenten");
			stmt.addBatch(q04);
*/			stmt.executeBatch();
			con.commit();
			stmt.close();
			System.out.println("Datenbank wurde hergestellt oder existiert bereits");
		} 
		catch (SQLException sqle) {
			System.out.println("Fehler beim Erstellen der DB");
			sqle.printStackTrace();
		}
		finally {
			try {
				if (stmt != null)
					stmt.close();
			}
			catch (SQLException e) {
				
			}
		}
		
		/*
		 * ________________________________________________________________________________________________
		 */
		System.out.println("Schlieﬂe Verbindung");
		try {
			con.close();
		}
		catch (SQLException sqle) {
			System.out.println("Fehler beim Verbindung schlieﬂen");
			System.out.println("SQLException: "+ sqle.getMessage());
			System.out.println("SQLStat: "+ sqle.getSQLState());
			System.out.println("VendorError: " + sqle.getErrorCode());
		}
		
	}
	
}
