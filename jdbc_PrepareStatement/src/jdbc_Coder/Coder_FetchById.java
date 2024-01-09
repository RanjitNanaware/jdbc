package jdbc_Coder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Coder_FetchById {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter ID To Get Information");
		int id = scanner.nextInt();
		
		// Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		//Create Connection
		String url = "jdbc:mysql://localhost:3306/coderdb";
		String user = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// Execute Query
		String query = "SELECT * FROM CODER WHERE ID = ?" ;
		
		// Create Statement
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, id);
		
		ResultSet resultSet = prepareStatement.executeQuery();
		while(resultSet.next()) {
			System.out.println("Id : "+resultSet.getInt(1));
			System.out.println("Name : "+resultSet.getString(2));
			System.out.println("Age : "+resultSet.getInt(3));
			System.out.println("Phone : "+resultSet.getLong(4));
			System.out.println("Address : "+resultSet.getString(5));
			System.out.println("Job Profile : "+resultSet.getString(6));
			System.out.println("*************");
		}
		System.out.println("Fetched SuccessFully");
		connection.close();
	}
}
