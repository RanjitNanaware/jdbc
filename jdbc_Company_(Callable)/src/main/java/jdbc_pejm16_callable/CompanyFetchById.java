package jdbc_pejm16_callable;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.Properties;

public class CompanyFetchById {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream("companydbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"),properties.getProperty("password"));
		
		CallableStatement callableStatement = connection.prepareCall("call companydb.fetchcompanyid(?)");
		callableStatement.setInt(1, 2);
		ResultSet resultset = callableStatement.executeQuery();
		while(resultset.next()) {
			System.out.println(resultset.getInt(1));
			System.out.println(resultset.getString("name"));
			System.out.println(resultset.getString(3));
			System.out.println(resultset.getString("address"));
			System.out.println(resultset.getLong(5));
		}
		connection.close();
	}
}
