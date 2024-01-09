package jdbc_Coder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Coder_Insert {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Id : ");
		int id = scanner.nextInt();
		System.out.println("Enter Name : ");
		String name = scanner.next();
		System.out.println("Enter Age : ");
		int age = scanner.nextInt();
		System.out.println("Enter phone : ");
		long phone = scanner.nextLong();
		System.out.println("Enter address : ");
		String address = scanner.next();
		System.out.println("Enter Job Profile : ");
		String job = scanner.next();
		
		// Register The Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Create Connection 
		String url = "jdbc:mysql://localhost:3306/coderdb";
		String user = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// Execute Query 
		String query = "INSERT INTO CODER VALUES(?,?,?,?,?,?)";
		
		// Create Statement
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		
		prepareStatement.setInt(1, id);
		prepareStatement.setString(2, name);
		prepareStatement.setInt(3, age);
		prepareStatement.setLong(4, phone);
		prepareStatement.setString(5, address);
		prepareStatement.setString(6, job);
		
		prepareStatement.executeUpdate();
		
		System.out.println("Coder Inserted");
		connection.close();
	}
}










