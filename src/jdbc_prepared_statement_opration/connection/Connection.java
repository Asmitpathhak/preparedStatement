package jdbc_prepared_statement_opration.connection;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Connection {
	public static Connection getCountryConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/countrydb";
			String user="root";
			String pass="root";
			 return DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

}
