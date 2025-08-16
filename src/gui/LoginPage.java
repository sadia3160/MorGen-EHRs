package gui;

import database.dbCon;
import gui.mainpage.admin.*;
import gui.mainpage.doctor.*;
import gui.mainpage.helpdesk.*;
import gui.mainpage.lab.*;
import gui.mainpage.patient.*;
import gui.mainpage.pharmacy.*;
import gui.mainpage.radiology.*;

import com.formdev.flatlaf.FlatDarculaLaf;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginPage implements ActionListener {

    JFrame frame;
    JButton lButton, rButton;
    JTextField userTextField;
    JPasswordField passwordField;

    public LoginPage(){

        UIManager.put("Button.arc", 21);
        frame = new JFrame();
        frame.setTitle("MorGen EHR System Login");
        ImageIcon iconLogo = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        frame.setIconImage(iconLogo.getImage());
        frame.getContentPane().setBackground(new Color(0xe2e8ef));

        JLabel userLabel = new JLabel("User ID");
        userLabel.setBounds(35,50,100,25);
        JLabel passLabel = new JLabel("Password");
        passLabel.setBounds(35,85,100,50);

        userTextField = new JTextField();
        userTextField.setBounds(145,50,270,25);
        passwordField = new JPasswordField();
        passwordField.setBounds(145,100,270,25);

        lButton = new JButton("Login");
        rButton = new JButton("Reset");

        lButton.setBounds(145, 150, 75, 25);
        rButton.setBounds(250, 150, 75, 25);
        lButton.setFocusable(false);
        rButton.setFocusable(false);
        lButton.addActionListener(this);
        rButton.addActionListener(this);
        lButton.setBackground(new Color(0x4682b4));
        lButton.setForeground(Color.WHITE);
        rButton.setBackground(Color.lightGray);


//        Border border = BorderFactory.createRaisedSoftBevelBorder();
//        lButton.setBorder(border);
//        rButton.setBorder(border);

        frame.setSize(470,270);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(userLabel);
        frame.add(passLabel);
        frame.add(userTextField);
        frame.add(passwordField);
        frame.add(lButton);
        frame.add(rButton);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == lButton){
            String userID = userTextField.getText();
            String pass = passwordField.getText();

            if(userID.equals("")){
                JOptionPane message1 = new JOptionPane();
                message1.showMessageDialog(null, "Enter User ID!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else if(pass.equals("")){
                JOptionPane message2 = new JOptionPane();
                message2.showMessageDialog(null, "Enter Password!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                try {
                    dbCon cl = new dbCon();
                    String q = "SELECT * FROM login WHERE user_id = \"" + userID + "\" AND user_pass = \"" +pass+ "\"";
                    PreparedStatement pst = cl.con.prepareStatement(q);
                    ResultSet resultSet = pst.executeQuery();

                    if (resultSet.next()) {
                        frame.dispose();
                        String role = resultSet.getString(3);
                        if(role.equals("Admin")) {
                            new adminMainpage();
                        }
                        else if(role.equals("Patient")) {
                            new patientMainpage();
                        }
                        else if(role.equals("Doctor")) {
                            new doctorMainpage();
                        }
                        else if(role.equals("Pharmacist")) {
                            new pharmacyMainpage(userID);
                        }
                        else if(role.equals("Lab Technician")) {
                            new labMainpage();
                        }
                        else if(role.equals("Radiologist")) {
                            new radiologyMainpage();
                        }
                        else{
                            new helpdeskMainpage();
                        }
                    } else {
                        JOptionPane message3 = new JOptionPane();
                        message3.showMessageDialog(null, "Invalid User ID or Password", "Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
                catch (Exception ev) {
                    ev.printStackTrace();
                }
            }
        }
        else if (e.getSource() == rButton){
            userTextField.setText("");
            passwordField.setText("");
        }
    }
}






