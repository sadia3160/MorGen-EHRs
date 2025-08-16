package gui.mainpage.radiology;

import javax.swing.*;
import java.awt.*;

public class RadiologyMainpageParent {

        JFrame frame;
        JPanel side,top,center, tempr;
        JButton ecom, patient;

        RadiologyMainpageParent(){
            frame = new JFrame("MorGen EHRs | Radiology Portal");
            ImageIcon iconLogo = new ImageIcon("src/gui/pictures/MLogoWB1.png");
            frame.setIconImage(iconLogo.getImage());
            frame.setLayout(new BorderLayout(5,1));

            tempr = new JPanel(new BorderLayout());
            JLabel hello = new JLabel("Welcome to MorGen EHRs! Click on the options to navigate.");
            hello.setForeground(Color.LIGHT_GRAY);
            hello.setFont(new Font("Helvetica", Font.CENTER_BASELINE, 13));
            hello.setBounds(100,300,100,35);
            tempr.add(hello, BorderLayout.NORTH);

            createPanels();
            createButtons();

            frame.add(side, BorderLayout.WEST);
            frame.add(top, BorderLayout.NORTH);
            frame.add(center, BorderLayout.CENTER);

            Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
            frame.setSize(windowSize.width, windowSize.height);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
            frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }

    private void createPanels(){
        side = new JPanel();
        top = new JPanel();
        center = new JPanel();

        side.setBackground(new Color(0xe7e9eb));
        top.setBackground(new Color(0xb8bcb3));
        center.setBackground(Color.WHITE);

        side.setPreferredSize(new Dimension(200,200));
        top.setPreferredSize(new Dimension(150,150));
        center.setPreferredSize(new Dimension(200,200));

        //layout
        center.setLayout(new BorderLayout());
        center.add(tempr, BorderLayout.CENTER);
    }

    private void createButtons(){
        patient = new JButton("Patient Info");
        ecom = new JButton("Emergency Contacts");

        patient.setPreferredSize(new Dimension(200,35));
        ecom.setPreferredSize(new Dimension(200,35));

        patient.setFocusable(false);
        ecom.setFocusable(false);

        patient.setBackground(new Color(0xe7e9eb));
        ecom.setBackground(new Color(0xe7e9eb));

        side.add(patient);
        side.add(ecom);

    }
}
