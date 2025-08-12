package gui.mainpage;

import database.dbCon;
import gui.mainpage.doctor.doctorMainpage;
import gui.mainpage.helpdesk.helpdeskMainpage;
import gui.mainpage.lab.labMainpage;
import gui.mainpage.patient.patientMainpage;
import gui.mainpage.pharmacy.pharmacyMainpage;
import gui.mainpage.radiology.radiologyMainpage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.ResultSet;

public class emerContacts {

    DefaultTableModel tableModel;
    JTable myTable;
    JScrollPane sPane;

    public JScrollPane myEmer() {

        createJTable();
        try {
            dbCon cl = new dbCon();
            String q = "SELECT * FROM emergency";
            ResultSet resultSet = cl.statement.executeQuery(q);

            while(resultSet.next()){
                String n =  (resultSet.getString(1));
                String c =  (resultSet.getString(2));
                Object[] record = {n, c};
                tableModel.addRow(record);
            }

        } catch (Exception ev) {
            ev.printStackTrace();
        }

        sPane = new JScrollPane(myTable);
        return sPane;
    }

    private void createJTable(){

        tableModel = new DefaultTableModel();

        tableModel.addColumn("Name");
        tableModel.addColumn("Emergency Numbers");

        myTable = new JTable(tableModel);
        myTable.setBackground(new Color(0xf0f0f0)); //0xf3f1ea));
        myTable.setRowHeight(35);
        myTable.setFont(new Font("Arial", Font.BOLD, 12));
        myTable.setEnabled(false);
        myTable.setShowGrid(true);
        myTable.setGridColor(Color.DARK_GRAY);
    }
}
