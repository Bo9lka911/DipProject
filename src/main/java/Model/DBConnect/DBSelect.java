package Model.DBConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by fedorishchev_as on 15.11.2016.
 */
public class DBSelect {
    public static void Select(Integer id) {
        Connection connection = null;
        String url = "jdbc:postgresql://localhost/EmployeesBD";
        String name = "Admin";
        String password = "Admin";

        ArrayList idEmployList = new ArrayList();
        ArrayList lastNameList = new ArrayList();
        ArrayList firstNameList = new ArrayList();
        ArrayList middleNameList = new ArrayList();
        ArrayList chiefList = new ArrayList();
        ArrayList departamentList = new ArrayList();

        try {
            Class.forName("org.postgresql.Driver");

            connection = DriverManager.getConnection(url, name, password);

            PreparedStatement preparedStatement = null;

            preparedStatement = connection.prepareStatement("SELECT * FROM Employees where id_employ = ? ORDER BY id_employ");
            preparedStatement.setInt(1, id);

            ResultSet result1 = preparedStatement.executeQuery();
            while (result1.next()) {

                System.out.println(result1.getString(1));
                idEmployList.add(result1.getString(1));

                System.out.println(result1.getString(2));
                lastNameList.add(result1.getString(2));

                System.out.println(result1.getString(3));
                firstNameList.add(result1.getString(3));

                System.out.println(result1.getString(4));
                middleNameList.add(result1.getString(4));

                System.out.println(result1.getString(5));
                chiefList.add(result1.getString(5));

                System.out.println(result1.getString(6));
                departamentList.add(result1.getString(6));
            }

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
