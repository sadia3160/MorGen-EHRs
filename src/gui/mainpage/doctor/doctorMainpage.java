package gui.mainpage.doctor;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class doctorMainpage {
    JPanel side,top,center;
    public doctorMainpage(){

        JFrame frame = new JFrame("MorGen EHRs | Doctor Portal");
        ImageIcon iconLogo = new ImageIcon("src/gui/pictures/MLogoWB1.png");
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
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    }

    private void createPanels(){

        side = new JPanel();
        top = new JPanel();
        center = new JPanel();


        side.setBackground(new Color(0xcccccc));
        top.setBackground(new Color(0x4b7a9f));
        center.setBackground(Color.WHITE);


        side.setPreferredSize(new Dimension(200,200));
        top.setPreferredSize(new Dimension(150,150));
        center.setPreferredSize(new Dimension(200,200));
    }

    private void createButtons(){
        JButton home = new JButton("Home");
        JButton patient = new JButton("Patient Charts");
        JButton lab = new JButton("Laboratory");
        JButton radiology = new JButton("Radiology");
        JButton pharma = new JButton("Pharmacy");

        home.setPreferredSize(new Dimension(200,35));
        patient.setPreferredSize(new Dimension(200,35));
        lab.setPreferredSize(new Dimension(200,35));
        radiology.setPreferredSize(new Dimension(200,35));
        pharma.setPreferredSize(new Dimension(200,35));

        home.setFocusable(false);
        patient.setFocusable(false);
        lab.setFocusable(false);
        radiology.setFocusable(false);
        pharma.setFocusable(false);

        home.setBorder(BorderFactory.createEtchedBorder());
        patient.setBorder(BorderFactory.createEtchedBorder());
        lab.setBorder(BorderFactory.createEtchedBorder());
        radiology.setBorder(BorderFactory.createEtchedBorder());
        pharma.setBorder(BorderFactory.createEtchedBorder());

        home.setBackground(new Color(0xcccccc));
        patient.setBackground(new Color(0xcccccc));
        lab.setBackground(new Color(0xcccccc));
        radiology.setBackground(new Color(0xcccccc));
        pharma.setBackground(new Color(0xcccccc));

        side.add(home);
        side.add(patient);
        side.add(lab);
        side.add(radiology);
        side.add(pharma);
    }
}
