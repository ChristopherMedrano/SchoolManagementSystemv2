package CoreJava.DAO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.sql.Statement;
import java.util.ArrayList;

public class SampleDB{
	OracleConnection oc = new OracleConnection();
	ArrayList<String> queries = new ArrayList<String>();
	ArrayList<String> dropStatements = new ArrayList<String>();
	
	/*
	 * These objects are used to connect and query the database 
	 */
	protected Connection conn = null;
	protected Statement st = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	public SampleDB getQueryList() {
		File file = new File("C:\\Users\\Students\\git\\SchoolManagementSystemv2\\SchoolManagementv2\\src\\CoreJava\\Resources\\populateData.sql");
		try {
			FileReader inputStream = new FileReader(file);
			BufferedReader br = new BufferedReader(inputStream);
			String query;
			
			while((query = br.readLine()) != null) {
				this.queries.add(query);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return this;
	}
	
	public SampleDB getDropStatements() {
		File file = new File("C:\\Users\\Students\\git\\SchoolManagementSystemv2\\SchoolManagementv2\\src\\CoreJava\\Resources\\purgeData.sql");
		try {
			FileReader inputStream = new FileReader(file);
			BufferedReader br = new BufferedReader(inputStream);
			String query;
			
			while((query = br.readLine()) != null) {
				this.dropStatements.add(query);
			}
			
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} 

		return this;
	}
	
	public SampleDB populateDB() {
		try {
			conn = oc.getConnection();
			
			for(String s: this.queries) {
				st = conn.createStatement();
				st.executeUpdate(s);
			}
			
			System.out.println("Database successfully created!");
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error populating database!");
		}
		
		return this;
	}
	
	public void dropDB() {
		try {
			conn = oc.getConnection();
			
			for(String s: this.dropStatements) {
				st = conn.createStatement();
				st.executeUpdate(s);
			}
			
			System.out.println("All tables dropped!");
			
		} catch (ClassNotFoundException | IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("Error dropping tables!");
			e.printStackTrace();
		}
		
	
	}
	
	public static void main(String[] args) {
		SampleDB testDB = new SampleDB();
		
		//testDB.getQueryList().populateDB();
		//testDB.getDropStatements().dropDB();
	}

}
