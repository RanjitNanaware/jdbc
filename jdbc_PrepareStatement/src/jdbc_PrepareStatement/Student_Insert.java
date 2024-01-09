package jdbc_PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import com.mysql.cj.jdbc.Driver;

public class Student_Insert {
	public static void main(String[] args) throws SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The id");
		int id = scanner.nextInt();
		System.out.println("Enter The Name");
		String name = scanner.next();
		System.out.println("Enter The marks");
		int marks = scanner.nextInt();
		System.out.println("Enter The phone");
		long phone = scanner.nextLong();
		System.out.println("Enter The Address");
		String address = scanner.next();


		//Register Driver
		Driver driver = new Driver();
		DriverManager.registerDriver(driver);
		
		// Create Connection
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		//Execute Query
		String query = "INSERT INTO STUDENT VALUES (?,?,?,?,?)";
		
		
		//Create Statement
		PreparedStatement preparedstatement = connection.prepareStatement(query);
		
		
		
		preparedstatement.setInt(1, id);
		preparedstatement.setString(2, name);
		preparedstatement.setInt(3, marks);
		preparedstatement.setLong(4, phone);
		preparedstatement.setString(5, address);
		
		preparedstatement.execute();
		System.out.println("Inserted");
		connection.close();
	}
}
