package jdbc_pejm16_callable;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class CompanyUpdate {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter The Id");
		int id = scanner.nextInt();
		System.out.println("Enter The Name : ");
		String name = scanner.next();
		System.out.println("Enter The GST : ");
		String gst = scanner.next();
		System.out.println("Enter The Address : ");
		String address = scanner.next();
		System.out.println("Enter The Phoneno");
		long phone = scanner.nextLong();
		
		FileInputStream fileInputStream = new FileInputStream("companydbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"),properties.getProperty("password"));
		
		CallableStatement callableStatement = connection.prepareCall("call companydb.update_Allcompany"
				+ "(?,?,?,?,?)");
		callableStatement.setInt(1, id);
		callableStatement.setString(2, name);
		callableStatement.setString(3, gst);
		callableStatement.setString(4, address);
		callableStatement.setLong(5, phone);
		
		int result = callableStatement.executeUpdate();
		if(result != 0) {
			System.out.println("Updated");
		}else {
			System.out.println("Failed To Update");
		}
		
		connection.close();
	}
}





