package jdbc_PrepareStatement;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_Update {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter The Id");
		int id = scanner.nextInt();
		System.out.println("Enter The name");
		String name = scanner.next();
		System.out.println("Enter The Marks");
		int marks = scanner.nextInt();
		System.out.println("Enter The phone");
		long phone = scanner.nextLong();
		System.out.println("Enter The Address");
		String address = scanner.next();
		
		String url = "jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		String query = "UPDATE STUDENT SET NAME=?, MARKS=?, PHONENO=?, ADDRESS=? WHERE ID=? ";
		
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparestatement = connection.prepareStatement(query);
		preparestatement.setString(1, name);
		preparestatement.setInt(2, marks);
		preparestatement.setLong(3, phone);
		preparestatement.setString(4, address);
		preparestatement.setInt(5, id);
		
		int result = preparestatement.executeUpdate();
		if(result != 0) {
			System.out.println("Updated");
		}
		else
		{
			System.out.println("Failed To Update");
		}
		connection.close();
	}
}
