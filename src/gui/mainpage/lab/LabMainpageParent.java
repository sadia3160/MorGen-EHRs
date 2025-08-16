package gui.mainpage.lab;

import javax.swing.*;
import java.awt.*;

public class LabMainpageParent {

    JFrame frame;
    JPanel side,top,center;
    JButton ecom, patient;
    protected LabMainpageParent(String titleName) {
        frame = new JFrame(titleName);
        ImageIcon iconLogo = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        frame.setIconImage(iconLogo.getImage());
        frame.setLayout(new BorderLayout(5,1));

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

        side.setBackground(new Color(0xe7e9eb)); //0xf1f9ff));
        top.setBackground(new Color(0x179aaf)); //0xb8bcb3));
        center.setBackground(Color.WHITE);

        side.setPreferredSize(new Dimension(200,200));
        top.setPreferredSize(new Dimension(150,150));
        center.setPreferredSize(new Dimension(200,200));

        center.setLayout(new BorderLayout());
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
