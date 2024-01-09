package jdbc_PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Student_Delete {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Id");
		int id = scanner.nextInt();
		
		String classname = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/studentdb";
		String user = "root";
		String password = "root";
		String query = "DELETE FROM STUDENT WHERE ID=?";
		
		Class.forName(classname);
		Connection connection = DriverManager.getConnection(url, user, password);
		PreparedStatement preparestatement = connection.prepareStatement(query);
		preparestatement.setInt(1, id);
		int result = preparestatement.executeUpdate();
		if(result != 0) {
			System.out.println("DELETED");
		}
		else {
			System.out.println("Data Not Found");
		}
		connection.close();
	}
}
