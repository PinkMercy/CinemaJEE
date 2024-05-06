package utilitaire;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingletonConnexion {
	private static Connection con;

	public static Connection getCon() {
		return con;
	}

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/crud","root","");
			System.out.println("Connection successful");
		} catch (ClassNotFoundException e) {
			System.err.println("MySQL JDBC Driver not found");
			e.printStackTrace();
		} catch (SQLException e) {
			System.err.println("Failed to make database connection");
			e.printStackTrace();
		}
	}
}