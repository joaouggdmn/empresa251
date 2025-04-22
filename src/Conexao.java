import java.sql.*;

public class Conexao {
    private static final String URL = "jdbc:mysql://localhost:3306/empresa251";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    public static Connection conectaBanco() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}






