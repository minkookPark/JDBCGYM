package DataSource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    // 집에서 mysql로 구동하기 위해 임시로 만든 DataSource 클래스임. 병합 시에는 반드시 원래대로 돌려놓을 것.
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String URL = "jdbc:mysql://localhost:3306/jangdb?useSSL=false&serverTimezone=Asia/Seoul&allowPublicKeyRetrieval=true";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "12345";

    public static Connection getDataSource() {

        Connection connection = null;
        try
        {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }

        return connection;
    }
}
