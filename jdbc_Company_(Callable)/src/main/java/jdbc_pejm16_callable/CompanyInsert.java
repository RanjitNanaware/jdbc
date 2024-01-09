package jdbc_pejm16_callable;

import java.io.FileInputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class CompanyInsert {
	
	public static void main(String[] args) throws Exception {
		FileInputStream fileInputStream = new FileInputStream("companydbconfig.properties");
		Properties properties = new Properties();
		properties.load(fileInputStream);
		
		Class.forName(properties.getProperty("className"));
		Connection connection = DriverManager.getConnection(properties.getProperty("url"),
				properties.getProperty("user"),properties.getProperty("password"));
		
		CallableStatement callableStatement = connection.prepareCall("call companydb.insert_company(?,?,?,?,?)");
		callableStatement.setInt(1, 3);
		callableStatement.setString(2, "infosys");
		callableStatement.setString(3, "infosys123");
		callableStatement.setString(4, "Hinjewadi");
		callableStatement.setLong(5, 9595089559l);
		int result = callableStatement.executeUpdate();
		if (result != 0) {
			System.out.println("Inserted");
		}else {
			System.out.println("Not Inserted");
		}
		connection.close();
		
	}
}
