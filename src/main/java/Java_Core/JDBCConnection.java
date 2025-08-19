package Java_Core;

import java.sql.*;

public class JDBCConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:myDriver:myDatabase", "user", "password");
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM myTable");
        connection.commit();
        connection.rollback();
        connection.commit();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO users (username, password) VALUES (?, ?)");
        preparedStatement.setString(1, "user");
        preparedStatement.setString(2, "pwd");
        preparedStatement.execute();
    }
}
