package jdbc_PrepareStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.cj.jdbc.Driver;

public class Student_Fetch {
	public static void main(String[] args) throws SQLException {
		String url = "jdbc:mysql://localhost:3306/studentdb?user=root&password=root";
		String query = "SELECT * FROM STUDENT WHERE ID=?";
		
		Driver driver = new com.mysql.cj.jdbc.Driver();
		DriverManager.registerDriver(driver);
		Connection connection = DriverManager.getConnection(url);
		PreparedStatement preparedstatement = connection.prepareStatement(query);
		preparedstatement.setInt(1, 2);
		ResultSet resultset = preparedstatement.executeQuery();
		while (resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString("name"));
			System.out.println(resultset.getInt(3));
			System.out.println(resultset.getLong("phoneno"));
			System.out.println(resultset.getString(5));
		}
		System.out.println("Fetched Succesfully");
		connection.close();
	}
}
