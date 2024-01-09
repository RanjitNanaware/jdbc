package jdbc_Coder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Coder_Update {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Enter Id To Update : ");
		int id = scanner.nextInt();
		System.out.println("Enter Name : ");
		String name = scanner.next();
		System.out.println("Enter age : ");
		int age = scanner.nextInt();
		System.out.println("Enter phone : ");
		long phone = scanner.nextLong();
		System.out.println("Enter address : ");
		String address = scanner.next();
		System.out.println("Enter job : ");
		String job = scanner.next();
		
		// register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Create Connection
		String url = "jdbc:mysql://localhost:3306/coderdb";
		String user = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// Execute Query
		String query = "UPDATE CODER SET NAME=?, AGE=?, PHONE=?, ADDRESS=?, JOB=? WHERE ID=?";
		
		// Create Statement
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		
		prepareStatement.setString(1, name);
		prepareStatement.setInt(2, age);
		prepareStatement.setLong(3, phone);
		prepareStatement.setString(4, address);
		prepareStatement.setString(5, job);
		prepareStatement.setInt(6, id);
		
		int result = prepareStatement.executeUpdate();
		
		if(result != 0) {
			System.out.println("Coder Updated..");
		}else {
			System.out.println("Failed To Update..");
		}
		
		connection.close();
	}
}




