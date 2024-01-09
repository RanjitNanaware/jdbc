package jdbc_Coder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Coder_Delete {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Coder Id To Delete Information");
		int id = scanner.nextInt();
		
		//Register Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// Create Connection
		String url = "jdbc:mysql://localhost:3306/coderdb" ;
		String user = "root" ;
		String password = "root";
		
		Connection connection = DriverManager.getConnection(url, user, password);
		
		// Execute Query
		String query = "DELETE FROM CODER WHERE ID = ?";
		
		//Create Statement
		PreparedStatement prepareStatement = connection.prepareStatement(query);
		prepareStatement.setInt(1, id);
		
		int result = prepareStatement.executeUpdate();
		if(result != 0) {
			System.out.println("Deleted Coder Information");
		}else {
			System.out.println("Failed To Delete");
		}
		connection.close();
	}
}
