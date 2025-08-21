package Java_Core;

import java.sql.*;

public class JDBCConnection {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "96510");
        connection.setAutoCommit(false);
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM enterprise.employees");
       while(result.next()){
           int employeeId = result.getInt("employee_id");
           String employeeName = result.getString("employee_name");
           String managerName = result.getString("manager_name");

           System.out.println("Id "+ employeeId);
           System.out.println("Name "+ employeeName);
           System.out.println("Manager Name "+managerName);
       }
        connection.commit();
        connection.rollback();
        connection.commit();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO enterprise.employees (employee_name, manager_name) VALUES (?, ?)");
        preparedStatement.setString(1, "ROB");
        preparedStatement.setString(2, "DON");
        preparedStatement.execute();
    }
}
