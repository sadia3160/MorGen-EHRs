package gui.mainpage.doctor;

import database.dbCon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;

public class PharmacyPage {

    JButton newData, addData, updateData, deleteData;
    JTable table;
    DefaultTableModel tableModel;
    JTextField searchPatient;
    JLabel sp;

    public PharmacyPage() {

        tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        table.setShowGrid(true);
        table.setEnabled(true);
        tableModel.addColumn("Medicines");
        tableModel.addColumn("Quantity");
    }

    public JScrollPane myMedicines(){
        JScrollPane jsp = new JScrollPane(table);
        return jsp;
    }

    public void declareMediButtons(){
        newData = new JButton("New");
        addData = new JButton("Add");
        updateData = new JButton("Reset");
        deleteData = new JButton("Delete");
        searchPatient = new JTextField();
        searchPatient.setBackground(new Color(0xeff9fe));
        sp = new JLabel("Enter Patient ID:");
        sp.setBorder(BorderFactory.createEtchedBorder());
    }

    public JPanel getAllButtons(){

        JPanel pharmaButtons = new JPanel(new GridLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7,7,7,7);

        gbc.gridx = 0;
        gbc.gridy = 0;
        pharmaButtons.add(sp);
        gbc.gridx = 1;
        gbc.gridy = 0;
        pharmaButtons.add(searchPatient);
        gbc.gridx = 2;
        gbc.gridy = 0;
        pharmaButtons.add(newData);
        gbc.gridx = 3;
        gbc.gridy = 0;
        pharmaButtons.add(addData);
        gbc.gridx = 4;
        gbc.gridy = 0;
        pharmaButtons.add(updateData);
        gbc.gridx = 5;
        gbc.gridy = 0;
        pharmaButtons.add(deleteData);

        return pharmaButtons;
    }

    public void newMedicine(){
       tableModel.addRow(new Object[]{"", ""});
    }

    public void addMedicine(String uid, String medi, String quan){
        try {
            dbCon dbcon = new dbCon();
            String q = "INSERT INTO MedicineTable (user_id, medicine,quantity) VALUES (?,?,?)";
            PreparedStatement pst = dbcon.con.prepareStatement(q);
            pst.setString(1, uid);
            pst.setString(2, medi);
            pst.setString(3, quan);
            pst.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void updateMedicine(){

    }

    public void deleteMedicine(String uid, String medi, String quan){
        try {
            dbCon dbcon = new dbCon();
            String q = "DELETE FROM MedicineTable WHERE user_id=? AND medicine=? AND quantity=?";
            PreparedStatement pst = dbcon.con.prepareStatement(q);
            pst.setString(1, uid);
            pst.setString(2, medi);
            pst.setString(3, quan);
            pst.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
