package jdbc_pejm16_callable;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.util.Scanner;

public class CompanyDelete {
	
	public static void main(String[] args) throws Exception {
		Scanner scanner = new Scanner (System.in);
		System.out.println("Enter The Id : ");
		int id = scanner.nextInt();
		
		FileInputStream fileInputStream = new FileInputStream("companydbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"),properties.getProperty("password"));
		
		CallableStatement callableStatemnt = connection.prepareCall("call companydb.delete_Company(?)");
		callableStatemnt.setInt(1, id);
		int result = callableStatemnt.executeUpdate();
		if (result != 0) {
			System.out.println("Deleted");
		}else {
			System.out.println("Failed To Delete");
		}
		
		connection.close();
	}
}





