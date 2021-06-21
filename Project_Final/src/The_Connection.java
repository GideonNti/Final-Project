import java.sql.*;
import javax.swing.*;
public class The_Connection {
	Connection conn = null;
	public static Connection dbconnector() {
		
		try {
			
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager.getConnection("jdbc:sqlite:C:\\Users\\JOSEPHINE BOAKYE\\Desktop\\DataBases\\LoanBalance.db");
			JOptionPane.showMessageDialog(null, "Connected successfully!");
			return conn;
		}catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return null;
		}
	}
}
