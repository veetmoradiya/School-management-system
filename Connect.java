import java.sql.*;

import javax.swing.JOptionPane;

public class Connect {
	
	public static void main(String[] args) throws SQLException {
		String username = "root";
		String password = "";
		Connection conn = null;
		try {
			
			String url = "jdbc:mysql://localhost:3306/mydatabase";
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);	
		
			JOptionPane.showMessageDialog(null, "Connected To DB");
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			conn.close();
		}
	}
}
