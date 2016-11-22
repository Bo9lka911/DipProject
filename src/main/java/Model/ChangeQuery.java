package Model;

import Model.DBConnect.DBSelect;
import jdk.nashorn.internal.parser.JSONParser;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.util.logging.Level;
import java.util.logging.Logger;

import static Model.DBConnect.DBDelete.Delete;
import static Model.DBConnect.DBInsert.Insert;
import static Model.DBConnect.DBSelect.Select;
import static Model.DBConnect.DBUpdate.Update;

/**
 * Created by fedorishchev_as on 16.11.2016.
 */

public class ChangeQuery {
    private static final String fileName = "C:\\Users\\fedorishchev_as\\projects2\\PortalTest\\src\\main\\crudRequestSelect.json";

    public static void main(String[] args) {

        JSONParser parser = new JSONParser();

        JSONObject requestJson = (JSONObject)parser.parse(new FileReader(fileName));

        String lastName;
        String middleName;
        String firstName;
        String chief;
        String department;
        Integer id;
        try {
            //select
            if (requestJson.variable = "1") {
                id = requestJson.get(idReq);
                Select(id);
            }
            //insert
            if (requestJson.get(variable) = "2") {
                lastName = requestJson.get(lastNameReq);
                middleName = requestJson.get(middleNameReq);
                firstName = requestJson.get(firstNameReq);
                chief = requestJson.get(chiefReq);
                department = requestJson.get(departmentReq);

                Insert(lastName, firstName, middleName, chief, department);
            }
            //update
            if (requestJson.get(variable) = "3") {
                id = requestJson.get(idReq);
                lastName = requestJson.get(lastNameReq);
                middleName = requestJson.get(middleNameReq);
                firstName = requestJson.get(firstNameReq);
                chief = requestJson.get(chiefReq);
                department = requestJson.get(departmentReq);

                Update(id, lastName, firstName, middleName, chief, department);
            }
            //delete
            if (requestJson.get(variable) = "4") {
                id = requestJson.get(idReq);
                Delete(id);
            }
        } catch (Exception ex) {
            Logger.getLogger(DBSelect.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
