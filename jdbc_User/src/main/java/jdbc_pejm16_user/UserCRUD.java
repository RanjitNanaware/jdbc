package jdbc_pejm16_user;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

public class UserCRUD {
	
	public Connection getConnection() throws Exception {
		FileReader fileReader = new FileReader("userdbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileReader);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"),properties.getProperty("password"));
		return connection ;
		
	}
	
	public void SignUpUser(User user) throws Exception {
		 Connection connection = getConnection();
		 PreparedStatement prepareStatement = connection.prepareStatement("INSERT INTO USER(ID,NAME,PHONE,EMAIL,PASSWORD) VALUES (?,?,?,?,?)");
		 prepareStatement.setInt(1, user.getId());
		 prepareStatement.setString(2, user.getName());
		 prepareStatement.setLong(3, user.getPhone());
		 prepareStatement.setString(4, user.getEmail());
		 prepareStatement.setString(5, user.getPassword());
		 int count = prepareStatement.executeUpdate();
		 if(count != 0) {
			 System.out.println("SignUp Successful");
		 }else {
			 System.out.println("failed To SignUp");
		 }
		 connection.close();
	}
	
	public boolean logInUser(User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement prepareStatemnt = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		prepareStatemnt.setString(1, user.getEmail());
		ResultSet resultSet = prepareStatemnt.executeQuery();
		String password = null ;
		while(resultSet.next()) {
			password = resultSet.getString("password");
		}
		connection.close();
		
		if(password.equals(user.getPassword())) {
			return true;
		}else {
			return false ;
		}
	}
	
	public void diplayPasswords(String email) throws Exception {
		Connection connection = getConnection();
		PreparedStatement prepareStatement = connection.prepareStatement("SELECT * FROM USER WHERE EMAIL=?");
		prepareStatement.setString(1, email);
		ResultSet resultset = prepareStatement.executeQuery();
		while(resultset.next()) {
			System.out.println("The Saved Passwords Are:- ");
			System.out.println("Facebook : "+ resultset.getString("facebook"));
			System.out.println("Instagram : "+ resultset.getString("instagram"));
			System.out.println("Snapchat : "+ resultset.getString("snapchat"));
			System.out.println("WhatsApp : "+ resultset.getString("whatsapp"));
			System.out.println("Twitter : "+ resultset.getString("twitter"));
		}
		connection.close();
	}
	
	public void updatePasswords (User user) throws Exception {
		Connection connection = getConnection();
		PreparedStatement preparedStatement = connection.prepareStatement("UPDATE USER SET FACEBOOK=?,"
				+ " INSTAGRAM=?, SNAPCHAT=?, WHATSAPP=?, TWITTER=? WHERE EMAIL=?");
		preparedStatement.setString(1, user.getFacebook());
		preparedStatement.setString(2, user.getInstagram());
		preparedStatement.setString(3, user.getSnapchat());
		preparedStatement.setString(4, user.getWhatsapp());
		preparedStatement.setString(5, user.getTwitter());
		preparedStatement.setString(6, user.getEmail());
		int result = preparedStatement.executeUpdate();
		if(result != 0) {
			System.out.println("Updated Successfully");
		}else {
			System.out.println("Failed To Update");
		}
		connection.close();
	}
}



