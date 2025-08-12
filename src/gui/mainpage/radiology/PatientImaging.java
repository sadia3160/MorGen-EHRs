package gui.mainpage.radiology;

import database.dbCon;

import java.sql.ResultSet;

public class PatientImaging {

    public PatientImaging() {
        try {
            dbCon cl = new dbCon();
            //Write CRUD statement for CRUD Operations
            //ResultSet resultSet = cl.statement.executeQuery(q);

        } catch (Exception ev) {
            ev.printStackTrace();
        }
    }
}
