package 진욱;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String PATH = "jdbc:oracle:thin:@localhost:1521:xe";
    public static final String USERNAME = "gymprj";
    public static final String PASSWORD = "a1234";

    public static Connection getDataSource() {

        Connection conn = null;

        try {
            Class.forName(DRIVER);
            conn = DriverManager.getConnection(PATH, USERNAME, PASSWORD);

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return conn;
    }
}
