package gui.mainpage.lab;

import database.dbCon;
import gui.mainpage.emerContacts;
import gui.mainpage.pharmacy.labEmergency;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.sql.PreparedStatement;

public class labMainpage extends LabMainpageParent implements ActionListener {

    JTextArea lNotes;
    JScrollPane scroll;
    JPanel viewTest, updateTest;
    JButton view, add, save;
    JLabel label, id, testName, testDate, testRes;
    JTextField patientSearchBox, idT, testDateT, testNameT, testResT;
    JDialog dialog;

    public labMainpage() {

        super("MorGen EHRs | Laboratory Portal");
        ecom.addActionListener(this);
        patient.addActionListener(this);
        view = new JButton("View");
        add = new JButton("Add");
        view.addActionListener(this);
        add.addActionListener(this);
        lNotes = new JTextArea();
        save = new JButton("Save");
        save.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == ecom) {
            center.removeAll();
            labEmergency ec = new labEmergency();
            JScrollPane jsp = ec.myEmer();
            jsp.setPreferredSize(new Dimension(1251, 551));
            center.add(jsp, BorderLayout.CENTER);
            center.revalidate();
            center.repaint();
        }
        if (e.getSource() == patient) {

            center.removeAll();
            viewTest = new JPanel(new BorderLayout());
            labNotes();
            updateTest = new JPanel(new BorderLayout());
            updateTest.add(add, BorderLayout.NORTH);

            JTabbedPane jtp = new JTabbedPane();
            jtp.add("View Tests", viewTest);
            jtp.add("Add Test Results", updateTest);

            center.add(jtp, BorderLayout.CENTER);
            center.revalidate();
            center.repaint();
        }
        if (e.getSource() == view) {
            viewTest.add(scroll, BorderLayout.CENTER);
            center.revalidate();
            center.repaint();
        }
        if (e.getSource() == add) {
            addTest();
        }
        if (e.getSource() == save) {

            String pid = idT.getText();
            String tnm = testNameT.getText();
            String tdt = testDateT.getText();
            String trs = testResT.getText();
            try {

                dbCon db_con = new dbCon();
                String q = "INSERT INTO LabTests (user_id,test_date,test_name,test_result) VALUES (?,?,?,?)";
                PreparedStatement pst = db_con.con.prepareStatement(q);
                pst.setString(1, pid);
                pst.setString(2, tdt);
                pst.setString(3, tnm);
                pst.setString(4, trs);
                pst.executeUpdate();
            } catch (Exception ev) {
                ev.printStackTrace();
            }
            dialog.dispose();
        }
    }

    private void labNotes() {

        lNotes.setLineWrap(true);
        lNotes.setWrapStyleWord(true);
        lNotes.setBackground(new Color(0xe3e8ea));

        scroll = new JScrollPane(lNotes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

        JPanel temp = new JPanel(new GridBagLayout());

        JLabel label = new JLabel("Lab Test Orders");
        label.setBackground(Color.LIGHT_GRAY);
        label.setFont(new Font("Verdana", Font.BOLD, 11));

        JTextField labPatient = new JTextField();
        labPatient.setPreferredSize(new Dimension(125, 25));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        temp.add(label, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        temp.add(labPatient, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        temp.add(view, gbc);

        viewTest.add(temp, BorderLayout.NORTH);
    }

    private void addTest() {

        JPanel labPanel = new JPanel();
        labPanel.setLayout(null);

        id = new JLabel("Patient ID");
        id.setBounds(20, 121, 125, 30);
        idT = new JTextField();
        idT.setBounds(130, 123, 325, 30);

        testName = new JLabel("Test Name");
        testName.setBounds(20, 161, 125, 30);

        testNameT = new JTextField();
        testNameT.setBounds(130, 163, 325, 30);

        testDate = new JLabel("Test Date");
        testDate.setBounds(20, 201, 125, 30);
        testDateT = new JTextField();
        testDateT.setBounds(130, 203, 325, 30);

        testRes = new JLabel("Test Result");
        testRes.setBounds(20, 241, 125, 30);
        testResT = new JTextField();
        testResT.setBounds(130, 243, 325, 30);

        save.setBounds(411, 297, 67, 25);
        save.setBackground(new Color(0x237fb7));
        save.setFont(new Font(null, Font.BOLD, 11));
        save.setForeground(Color.WHITE);

        labPanel.add(save);
        labPanel.add(id);
        labPanel.add(idT);
        labPanel.add(testName);
        labPanel.add(testNameT);
        labPanel.add(testDate);
        labPanel.add(testDateT);
        labPanel.add(testRes);
        labPanel.add(testResT);

        dialog = new JDialog(frame, "Lab Test Information", true);

        ImageIcon icon = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        dialog.setIconImage(icon.getImage());
        dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel forImage = new JLabel();

        ImageIcon icon1 = new ImageIcon("src/gui/pictures/MorGenWB1.png");
        Image tempImage = icon1.getImage().getScaledInstance(179, 45, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(tempImage);

        forImage.setIcon(icon2);
        forImage.setBorder(BorderFactory.createEtchedBorder());
        forImage.setBounds(183, 50, 179, 45);

        dialog.add(forImage);
        dialog.add(labPanel);
        dialog.setSize(555, 415);
        dialog.setLocationRelativeTo(null);
        dialog.setVisible(true);
    }
}

