package pejm16_jdbc;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class PersonCRUD {

	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
		FileInputStream fileInputStream = new FileInputStream("persondbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);

		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"), properties.getProperty("password"));

		return connection;
	}

	public void savePerson(Person person) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO PERSON VALUES (?,?,?,?)");
		prepareStatement.setInt(1, person.getId());
		prepareStatement.setString(2, person.getNameString());
		prepareStatement.setLong(3, person.getPhone());
		prepareStatement.setString(4, person.getAddress());
		int result = prepareStatement.executeUpdate();
		if (result != 0) {
			System.out.println("Inseted");
		} else {
			System.out.println("Failed To Insert");
		}

	}

	public void updatePerson(Person person) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection
				.prepareStatement("UPDATE PERSON SET NAME=?, PHONE=?, " + "ADDRESS=? WHERE ID=?");
		prepareStatement.setString(1, person.getNameString());
		prepareStatement.setLong(2, person.getPhone());
		prepareStatement.setString(3, person.getAddress());
		prepareStatement.setInt(4, person.getId());
		int result = prepareStatement.executeUpdate();
		if (result != 0) {
			System.out.println("Updated");
		} else {
			System.out.println("Not Updated");
		}
		connection.close();
	}

	public void deletePerson(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
		preparedStatement.setInt(1, id);
		int result = preparedStatement.executeUpdate();
		if (result != 0) {
			System.out.println("Deleted");
		} else {
			System.out.println("Failed To Delete");
		}
		connection.close();
	}

	public void findPerson(int id) throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON WHERE ID =?");
		preparedStatement.setInt(1, id);
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong("phone"));
			System.out.println(resultSet.getString(4));
		}
		connection.close();
	}

	public void findAllPerson() throws ClassNotFoundException, IOException, SQLException {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PERSON");
		ResultSet resultSet = preparedStatement.executeQuery();
		while (resultSet.next()) {
			System.out.println(resultSet.getInt("id"));
			System.out.println(resultSet.getString(2));
			System.out.println(resultSet.getLong("phone"));
			System.out.println(resultSet.getString(4));
		}
		connection.close();
	}
}

