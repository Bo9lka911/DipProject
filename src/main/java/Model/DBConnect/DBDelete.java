package Model.DBConnect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fedorishchev_as on 16.11.2016.
 */
public class DBDelete {
    public static void Delete(Integer id) {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost/EmployeesBD";
        String name = "Admin";
        String password = "Admin";
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, name, password);

            Statement statement = null;
            statement = connection.createStatement();
            String DeleteTaB = "DELETE FROM Employees where id_employ =" + id;
            statement.execute(DeleteTaB);

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
