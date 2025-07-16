package task.manager.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {
	
	
	// Since I am using the H2 database and want that the client will be able to run the application without much 
	// configuration therefore in the DBUtil we have to create the required tables at the time of the database connection
	// establishment.
	
	
	// For this we need to write so many insert queries, therefore I have tried to many a query generator 
	// A custom query generator where you would just pass the column name and rest is set.
	
	
	private List<String> requiredTableQueries = new ArrayList<>(); 
	private static final String username = "sa";
	private static final String password = "";
	public static final String dbName = "\\data\\task_manager";
	private static final String dbUrl = "jdbc:h2:file:";
	private static final String dbFolder = System.getProperty("user.dir");
	
	public DBUtil() {
		QueryGenerator a = new QueryGenerator("Task");
		try {
			a.addColumn("timestamp", "timestamp", false);
			a.addColumn("Title", "varchar", 200, false);
			a.addColumn("Description" , "varchar", 300, true);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	
		System.out.println(a.getFinalQuery());
		
		
	}

	
	public static Connection getConnection() {
		
		String finalDBUrl = dbUrl + dbFolder + dbName;
		
		//System.out.println(finalDBUrl);
		
		try {
			Connection connection = DriverManager.getConnection(finalDBUrl, username, password);
			System.out.println("Connection success");
			return connection;
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("Return null connection");
			return null;
		} 
		
	}
	
	private void createRequiredTables(Connection connection) throws Exception{
	
		
		
		Statement st = connection.createStatement();
		
		
		
	}
	
	public static void closeConnection(Connection connection, ResultSet rs, PreparedStatement ps) {
		
		try {
			
			if(rs != null) {
				rs.close();
			}
			
			if(ps != null) {
				ps.close();
			}
			
			if(connection != null) {
				connection.close();
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
			
	}
	
}
