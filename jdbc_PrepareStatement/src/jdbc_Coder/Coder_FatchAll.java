package jdbc_Coder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Coder_FatchAll {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		//Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create Connection
		String url = "jdbc:mysql://localhost:3306/coderdb";
		String user = "root";
		String password ="root";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// Execute Query
		String query = "SELECT * FROM CODER";
		
		// Create Statement
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		
		ResultSet resultSet = prepareStatement.executeQuery();
		
		while(resultSet.next()) {
			System.out.println("Id : "+resultSet.getInt(1));
			System.out.println("Name : "+resultSet.getString(2));
			System.out.println("Age : "+resultSet.getInt(3));
			System.out.println("Phone : "+resultSet.getLong(4));
			System.out.println("Address : "+resultSet.getString(5));
			System.out.println("Job Profile : "+resultSet.getString(6));
			System.out.println("*******Fetched********");
		}
		System.out.println("Fetched All Data Successfully");
		connection.close();
	}
}



