package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DWCGDB {

	private Connection con = null;
	private Statement stmt = null;
	
	public DWCGDB(){
		con = null;
		
		dbConnect();
		insert();
	}
	
	private void dbConnect() {
		String protocol = "jdbc:derby:";
		
		try {
			con = DriverManager.getConnection(protocol + "DWCGDB;create=true");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void insert() {
		try {
			stmt = con.createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			stmt.executeUpdate(""
				+ "CREATE TABLE Test("
				+ "ID INT PRIMARY KEY, "
				+ "NAME VARCHAR(50))");
			stmt.executeUpdate("INSERT INTO Test VALUES(1, 'Audi')");
			ResultSet res = stmt.executeQuery("SELECT * From Test");
			while(res.next()) {
				System.out.println(res.getInt("ID"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}