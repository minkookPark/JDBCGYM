package 희진;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataSource {
	
	private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
	private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	private static final String USERNAME = "heejin";
	private static final String PASSWORD = "jin";
	
	public static Connection getDataSource() {
		Connection connection = null;

//PreparedStatement pStatement = null; 대신 작성
		
		try {
// 데이터 소스: class~ password);
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
		} catch(SQLException e) {
			e.printStackTrace();
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} 	
		return connection; 
	}
}