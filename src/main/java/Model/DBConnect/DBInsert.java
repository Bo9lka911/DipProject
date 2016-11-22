package Model.DBConnect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fedorishchev_as on 16.11.2016.
 */
public class DBInsert {
    public static void Insert(String lastName, String firstName, String middleName, String chief, String department) {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost/EmployeesBD";
        String name = "Admin";
        String password = "Admin";
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement("INSERT INTO Employees(id_employ,last_name, first_name, middle_name, chief, departament)\n" +
                    "VALUES ((SELECT (MAX(id_employ) +1) FROM Employees),?,?,?,?,?);");
                preparedStatement.setString(1, lastName);
                preparedStatement.setString(2, firstName);
                preparedStatement.setString(3, middleName);
                preparedStatement.setString(4, chief);
                preparedStatement.setString(5, department);
                preparedStatement.executeUpdate();


        } catch (Exception ex) {
            Logger.getLogger(DBSelect.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException ex) {
                    Logger.getLogger(DBSelect.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }

    }
}
