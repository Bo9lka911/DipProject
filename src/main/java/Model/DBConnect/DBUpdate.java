package Model.DBConnect;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fedorishchev_as on 16.11.2016.
 */
public class DBUpdate {
    public static void Update(Integer id,String lastName, String firstName, String middleName, String  chief, String departament) {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost/EmployeesBD";
        String name = "Admin";
        String password = "Admin";
        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, name, password);

            Statement statement = null;

            statement = connection.createStatement();
            String UpdateTaB = "UPDATE Employees SET last_name = '" + lastName + "', first_name = '" + firstName + "',middle_name = '" + middleName + "', chief = '" + chief + "', departament = '" + departament + "' WHERE id_employ = '"+ id +"';";
            statement.execute(UpdateTaB);

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
