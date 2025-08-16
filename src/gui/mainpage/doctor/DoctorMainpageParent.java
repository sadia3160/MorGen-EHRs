package gui.mainpage.doctor;

import javax.swing.*;
import java.awt.*;

public class DoctorMainpageParent {

    JFrame frame;
    protected JPanel side,top,center;
    protected JPanel topOfCenterArea, bottomOfCenterArea, myMedicinePanel, mediButtonsPanel;
    protected JTextField searchBox;
    protected JButton home, patientCharts, lab, radiology, pharma; //doctor's
    protected  JButton history, digno, medi, immu, aller, pres, vSign , notes, save;

    protected DoctorMainpageParent(String titleName){

        frame = new JFrame();
        frame.setTitle(titleName);
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


        side.setBackground(new Color(0xE8EDEE));
        top.setBackground(new Color(0x4b7a9f));
        center.setBackground(Color.WHITE);


        side.setPreferredSize(new Dimension(200,200));
        top.setPreferredSize(new Dimension(150,150));
        center.setPreferredSize(new Dimension(200,200));

        //Layouts
        center.setLayout(new GridBagLayout());

    }

    private void createButtons(){

        home = new JButton("Home");
        patientCharts = new JButton("Patient Charts");
        lab = new JButton("Laboratory");
        radiology = new JButton("Radiology");
        pharma = new JButton("Pharmacy");

        home.setPreferredSize(new Dimension(200,35));
        patientCharts.setPreferredSize(new Dimension(200,35));
        lab.setPreferredSize(new Dimension(200,35));
        radiology.setPreferredSize(new Dimension(200,35));
        pharma.setPreferredSize(new Dimension(200,35));

        home.setFocusable(false);
        patientCharts.setFocusable(false);
        lab.setFocusable(false);
        radiology.setFocusable(false);
        pharma.setFocusable(false);


        home.setBackground(new Color(0xE8EDEE));
        patientCharts.setBackground(new Color(0xE8EDEE));
        lab.setBackground(new Color(0xE8EDEE));
        radiology.setBackground(new Color(0xE8EDEE));
        pharma.setBackground(new Color(0xE8EDEE)); //0xcccccc));


        side.add(home);
        side.add(patientCharts);
        side.add(lab);
        side.add(radiology);
        side.add(pharma);
    }
}


