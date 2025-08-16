package gui.mainpage.radiology;

import com.toedter.calendar.JDateChooser;
import database.dbCon;
import gui.mainpage.emerContacts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class radiologyMainpage extends RadiologyMainpageParent implements ActionListener {

    JLabel label, id, testName, testDate;
    JTextField patientSearchBox, idT, testDateT, testNameT;
    JButton add,select,save;
    File imgFile;
    JFileChooser jfc;
    JDialog dialog;

    public radiologyMainpage(){
        ecom.addActionListener(this);
        patient.addActionListener(this);
        add = new JButton("Add");
        add.addActionListener(this);
        select = new JButton("Select");
        select.addActionListener(this);
        save = new JButton("Save");
        save.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ecom){
            center.removeAll();
            radiologyEmergency ec = new radiologyEmergency();
            JScrollPane jsp = ec.myEmer();

            center.add(jsp, BorderLayout.CENTER);
            center.revalidate();
            center.repaint();
        }
        if(e.getSource() == patient){

            center.removeAll();

            JPanel up = new JPanel(new GridBagLayout());
            label = new JLabel("Add Imaging Test Information:");
            patientSearchBox = new JTextField();
            patientSearchBox.setPreferredSize(new Dimension(100,25));

            GridBagConstraints gbc = new GridBagConstraints();
            gbc.insets = new Insets(7,7,7,7);

            gbc.gridx = 0;
            gbc.gridy = 0;
            up.add(label, gbc);
//            gbc.gridx = 1;
//            gbc.gridy = 0;
//            up.add(patientSearchBox, gbc);
            gbc.gridx = 1;
            gbc.gridy = 0;
            up.add(add, gbc);

            center.add(up,BorderLayout.NORTH);
            center.validate();
            center.repaint();

        }
        if(e.getSource() == add){

            JPanel radioPanel = new JPanel();
            radioPanel.setLayout(null);

            id = new JLabel("Patient ID");
            id.setBounds(20,121, 125, 30);
            idT = new JTextField();
            idT.setBounds(130, 123, 325, 30);

            testName = new JLabel("Test Name");
            testName.setBounds(20,161, 125,30);

            testNameT = new JTextField();
            testNameT.setBounds(130, 163, 325, 30);

            testDate = new JLabel("Appointment Date");
            testDate.setBounds(20,201,125,30);
            testDateT = new  JTextField();
            testDateT.setBounds(130, 203, 325, 30);

            select.setBounds(333, 261, 67, 25);
            save.setBounds(411, 261, 67, 25);

            radioPanel.add(save);
            radioPanel.add(select);
            radioPanel.add(id);
            radioPanel.add(idT);
            radioPanel.add(testName);
            radioPanel.add(testNameT);
            radioPanel.add(testDate);
            radioPanel.add(testDateT);

            dialog = new JDialog(frame, "Imaging Test Information", true);

            ImageIcon icon = new ImageIcon("src/gui/pictures/MLogoWB1.png");
            dialog.setIconImage(icon.getImage());
            dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

            JLabel forImage = new JLabel();

            ImageIcon icon1 = new ImageIcon("src/gui/pictures/MorGenWB1.png");
            Image tempImage = icon1.getImage().getScaledInstance(179,45, Image.SCALE_DEFAULT);
            ImageIcon icon2 = new ImageIcon(tempImage);

            forImage.setIcon(icon2);
            forImage.setBorder(BorderFactory.createEtchedBorder());
            forImage.setBounds(183,50,179,45);

            dialog.setBackground(new Color(0xdadae3));
            dialog.add(forImage);
            dialog.add(radioPanel);
            dialog.setSize(555,355);
            dialog.setLocationRelativeTo(null);
            dialog.setVisible(true);
        }
        if(e.getSource() == select){

            jfc = new JFileChooser();
            int k = jfc.showOpenDialog(null);

            if(k == JFileChooser.APPROVE_OPTION){
               imgFile = jfc.getSelectedFile();
            }
        }
        if(e.getSource() == save){

            String pid = idT.getText();
            String tnm = testNameT.getText();
            String tdt = testDateT.getText();
            try{
                byte[] imgInBytes = Files.readAllBytes(imgFile.toPath());

                dbCon db_con = new dbCon();
                String q = "INSERT INTO RadiologyImages (user_id,test_name,image,test_date) VALUES (?,?,?,?)";
                PreparedStatement pst = db_con.con.prepareStatement(q);
                pst.setString(1, pid);
                pst.setString(2, tnm);
                pst.setBytes(3, imgInBytes);
                pst.setString(4, tdt);
                pst.executeUpdate();
            }
            catch (Exception ev){
                ev.printStackTrace();
            }
            dialog.dispose();
        }
    }
}
