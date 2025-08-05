package gui;

import gui.mainpage.admin.adminMainpage;
import gui.mainpage.doctor.doctorMainpage;
import gui.mainpage.helpdesk.helpdeskMainpage;
import gui.mainpage.lab.labMainpage;
import gui.mainpage.patient.*;
import gui.mainpage.pharmacy.pharmacyMainpage;
import gui.mainpage.radiology.radiologyMainpage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginPage implements ActionListener {

    JFrame frame;
    JButton lButton, rButton;
    JTextField userTextField;
    JPasswordField passwordField;

    public LoginPage(){

        frame = new JFrame();
        frame.setTitle("MorGen EHR System Login");
        ImageIcon iconLogo = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        frame.setIconImage(iconLogo.getImage());

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
        lButton.setBackground(Color.pink);

        Border border = BorderFactory.createRaisedSoftBevelBorder();
        lButton.setBorder(border);
        rButton.setBorder(border);

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
            if(userID.equals("232115314")){
                if(pass.equals("quesera")) {
                    frame.dispose();
                    adminMainpage amp = new adminMainpage();
                    //patientMainpage pmp = new patientMainpage();
                    //doctorMainpage dmp = new doctorMainpage();
                    //pharmacyMainpage pmp = new pharmacyMainpage();
                    //labMainpage lmp = new labMainpage();
                    //radiologyMainpage rmp = new radiologyMainpage();
                    //helpdeskMainpage hdmp = new helpdeskMainpage();
                }
                else if(pass.equals("")){
                    JOptionPane message1 = new JOptionPane();
                    message1.showMessageDialog(null, "Enter password!", "Error", JOptionPane.INFORMATION_MESSAGE);
                }
                else{
                    JOptionPane message2 = new JOptionPane();
                    message2.showMessageDialog(null, "Wrong Password", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(userID.equals("")){
                JOptionPane message3 = new JOptionPane();
                message3.showMessageDialog(null, "Enter user name!", "Error", JOptionPane.INFORMATION_MESSAGE);
            }
            else {
                JOptionPane message4 = new JOptionPane();
                message4.showMessageDialog(null, "Wrong User ID", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        if(e.getSource() == rButton){
            userTextField.setText("");
            passwordField.setText("");
        }
    }
}
