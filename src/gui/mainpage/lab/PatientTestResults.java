package gui.mainpage.lab;

import database.dbCon;

import java.sql.ResultSet;

public class PatientTestResults {
    public PatientTestResults() {
        try {
            dbCon cl = new dbCon();
            //Write statement for CRUD
            //ResultSet resultSet = cl.statement.executeQuery(q);

        } catch (Exception ev) {
            ev.printStackTrace();
        }
    }
}
