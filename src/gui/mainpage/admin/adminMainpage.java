package gui.mainpage.admin;

import javax.swing.*;
import java.awt.*;

public class adminMainpage {

    JPanel side,top,center;
    public adminMainpage(){

        JFrame frame = new JFrame("MorGen EHRs | Admin Portal");
        ImageIcon iconLogo = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(iconLogo.getImage());
        frame.setLayout(new BorderLayout());

        createPanels();
        createButtons();

        frame.add(side, BorderLayout.WEST);
        frame.add(top, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);

        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(windowSize.width, windowSize.height);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void createPanels(){
        //JPanel instantiate
        side = new JPanel();
        top = new JPanel();
        center = new JPanel();

        //JPanel color
        side.setBackground(new Color(0xefeff2));
        top.setBackground(new Color(0xe56a6a));
        center.setBackground(Color.WHITE);

        //JPanel Size
        side.setPreferredSize(new Dimension(200,200));
        top.setPreferredSize(new Dimension(150,150));
        center.setPreferredSize(new Dimension(200,200));
    }

    private void createButtons(){

        JButton appointSch = new JButton("Appointment Schedule");
        JButton patient = new JButton("Patient Entry and Info");
        JButton billingInfo = new JButton("Billing");
        JButton doctor = new JButton("Doctor List and Schedule");
        JButton emer = new JButton("Emergency contacts");

        appointSch.setPreferredSize(new Dimension(200, 35));
        patient.setPreferredSize(new Dimension(200, 35));
        billingInfo.setPreferredSize(new Dimension(200, 35));
        doctor.setPreferredSize(new Dimension(200, 35));
        emer.setPreferredSize(new Dimension(200, 35));

        appointSch.setFocusable(false);
        doctor.setFocusable(false);
        billingInfo.setFocusable(false);
        patient.setFocusable(false);
        emer.setFocusable(false);

        appointSch.setBackground(new Color(0xefeff2));
        doctor.setBackground(new Color(0xefeff2));
        billingInfo.setBackground(new Color(0xefeff2));
        emer.setBackground(new Color(0xefeff2));
        patient.setBackground(new Color(0xefeff2));

        appointSch.setBorder(BorderFactory.createEtchedBorder());
        doctor.setBorder(BorderFactory.createEtchedBorder());
        billingInfo.setBorder(BorderFactory.createEtchedBorder());
        emer.setBorder(BorderFactory.createEtchedBorder());
        patient.setBorder(BorderFactory.createEtchedBorder());

        side.add(appointSch);
        side.add(patient);
        side.add(doctor);
        side.add(billingInfo);
        side.add(emer);
    }
}
