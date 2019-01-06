package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {

	String ip = "192.168.213.128";
	String port = "3306";
	String dbname = "dbtest";
	String user = "jonas";
	String pw = "1234";
	
	Connection con = null;
	
	public Database() {
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
	
	public Connection erstelleVerbindung() {
		
		try {
			System.out.println("Verbindung aufbauen...");
			String url = "jdbc:mysql://"+ip+":"+port+"/"+dbname + "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin";
			this.con = DriverManager.getConnection(url, user, pw);
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
		
		return this.con;		
	}

	public void schließeVerbindung() {
		System.out.println("Schließe Verbindung...");
		try {
			this.con.close();
		}
		catch (SQLException sqle) {
			System.out.println("Fehler beim Verbindung schließen");
			System.out.println("SQLException: "+ sqle.getMessage());
			System.out.println("SQLStat: "+ sqle.getSQLState());
			System.out.println("VendorError: " + sqle.getErrorCode());
		}
		System.out.println("Verbindung wurde geschlossen.");
	}
	
	public void erstelleStudentTabelle() {
		String q01 = "CREATE TABLE Student ("
				+ "ID varchar(50));";
		
		Statement stmt = null;
		
		try {
			this.con.setAutoCommit(false);
			stmt = this.con.createStatement();
			System.out.println("Erstelle Tabelle Student...");
			stmt.addBatch(q01);
			stmt.executeBatch();
			this.con.commit();
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println("Fehler beim Erstellen der Tabelle!");
			e.printStackTrace();
		}
		
		System.out.println("Tabelle wurde erstellt...");
		
	}
	
	public void löscheStudentTabelle() {
		String q01 = "DROP TABLE Student";
		
		Statement stmt = null;
		
		try {
			this.con.setAutoCommit(false);
			stmt = this.con.createStatement();
			System.out.println("Lösche Tabelle Student...");
			stmt.addBatch(q01);
			stmt.executeBatch();
			this.con.commit();
			stmt.close();
		}
		catch (SQLException e) {
			System.out.println("Fehler beim Löschen!");
			e.printStackTrace();
		}
		
		System.out.println("Tabelle wurde erfolgreich gelöscht.");
	}
	
	
	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getDbname() {
		return dbname;
	}

	public void setDbname(String dbname) {
		this.dbname = dbname;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public Connection getCon() {
		return con;
	}

	public void setCon(Connection con) {
		this.con = con;
	}

}
