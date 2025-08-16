package gui.mainpage.pharmacy;

import database.dbCon;
import gui.mainpage.emerContacts;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class pharmacyMainpage extends PharmacyMainpageParent implements ActionListener {

    JTextField patientSearchBox;
    JLabel label; JButton search;
    DefaultTableModel defaultTableModel;
    JTable table; JScrollPane scrollPane;
    JPanel bottom;

    public pharmacyMainpage(String userID){

        JButton btn1 = new JButton("User ID: "+userID);
        btn1.setFont(new Font("Helvetica", Font.BOLD, 15));
        btn1.setBorder(BorderFactory.createLineBorder(new Color(0xccecee)));
        btn1.setRolloverEnabled(true);
        btn1.setBackground(new Color(0xB3D7E0));
        JButton btn2 = new JButton("Role: Pharmacist");
        btn2.setFont(new Font("Libre Baskerville", Font.ITALIC, 11));
        btn2.setBackground(Color.DARK_GRAY);
        btn2.setForeground(Color.WHITE);

        JPanel myPanel = new JPanel(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(3,3,3,11);

        gbc.gridx = 31;
        gbc.gridy = 0;
        myPanel.add(btn1,gbc);
        gbc.gridx = 31;
        gbc.gridy = 1;
        myPanel.add(btn2,gbc);

        myPanel.setBackground(new Color(0xB3D7E0));
        bottom = new JPanel();
        top.add(myPanel, BorderLayout.EAST);
        ecom.addActionListener(this);
        patient.addActionListener(this);
        search = new JButton("Search");
        search.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ecom){
            center.removeAll();
            pharmacyEmergency ec = new pharmacyEmergency();
            JScrollPane jsp = ec.myEmer();
            center.add(jsp, BorderLayout.CENTER);
            center.revalidate();
            center.repaint();
        }
        if(e.getSource() == patient){
            center.removeAll();
            JPanel up = new JPanel(new GridBagLayout());
            label = new JLabel("Patient ID:");
            patientSearchBox = new JTextField();
            patientSearchBox.setPreferredSize(new Dimension(100,25));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(7,7,7,7);

            gbc.gridx = 0;
            gbc.gridy = 0;
            up.add(label, gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            up.add(patientSearchBox,gbc);
            gbc.gridx = 2;
            gbc.gridy = 0;
            up.add(search,gbc);

            //seePatientsMedicine(pid);

            center.add(up, BorderLayout.NORTH);
            center.validate();
            center.repaint();
        }
        if(e.getSource() == search){
            if(bottom != null){
                bottom.removeAll();
            }

            String uid = patientSearchBox.getText();

            defaultTableModel = new DefaultTableModel();
            table = new JTable(defaultTableModel);
            table.setEnabled(false);
            table.setShowGrid(true);
            defaultTableModel.addColumn("Medicine");
            defaultTableModel.addColumn("Quantity");
            try{
                dbCon db_con = new dbCon();
                String q = "SELECT * FROM MedicineTable Where user_id=?";
                PreparedStatement pst = db_con.con.prepareStatement(q);
                pst.setString(1, uid);
                ResultSet rs = pst.executeQuery();
                //ResultSetMetaData rsm = rs.getMetaData();

                //int col = rsm.getColumnCount();
                while(rs.next()) {
                    String m = rs.getString(2);
                    String qt = rs.getString(3);
                    defaultTableModel.addRow(new Object[]{m,qt});
                }

            }
            catch (Exception ev){
                ev.printStackTrace();
            }
            scrollPane = new JScrollPane(table);
            scrollPane.setPreferredSize(new Dimension(1251,551));
            bottom.add(scrollPane);
            center.add(bottom, BorderLayout.CENTER);
            center.validate();
            center.repaint();
        }

    }
}
