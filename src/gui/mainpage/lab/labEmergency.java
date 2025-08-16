package gui.mainpage.pharmacy;

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
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class labEmergency {

    DefaultTableModel tableModel;
    JTable myTable;
    JScrollPane sPane;

    public JScrollPane myEmer() {

        createJTable();
        try {
            dbCon cl = new dbCon();
            String q = "SELECT * FROM emergency";
            PreparedStatement pst = cl.con.prepareStatement(q);
            ResultSet resultSet =   pst.executeQuery();

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
        myTable.setBackground(new Color(0xEAEDED)); //0xf0f0f0)); //0xf3f1ea));
        myTable.setRowHeight(27);
        myTable.setFont(new Font("Helvetica", Font.BOLD, 12));
        myTable.setEnabled(false);
        myTable.setShowGrid(true);
        myTable.setGridColor(Color.DARK_GRAY);
    }
}
