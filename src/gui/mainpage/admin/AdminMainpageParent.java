package gui.mainpage.admin;

import javax.swing.*;
import java.awt.*;

public class AdminMainpageParent {

    JFrame frame;
    JPanel side,top,center, temp, ap;
    JButton appointScheduling, patientRegistration, billingInfo, doctorList, emerContacts, addPat;
    JButton newAppointment, createBill, saveA, cancelA;
    JRadioButton in, out;
    JDialog dialog1, dialog2, dialog3;
    JComboBox deptSelection;
    AppointmentForm apf;

    protected AdminMainpageParent(String titleName) {

        frame = new JFrame();
        frame.setTitle(titleName);
        ImageIcon iconLogo = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage(iconLogo.getImage());
        frame.setLayout(new BorderLayout(7,7));

        createPanels();
        createButtons();


        frame.add(side, BorderLayout.WEST);
        frame.add(top, BorderLayout.NORTH);
        frame.add(center, BorderLayout.CENTER);
        out = new JRadioButton("Outpatient");
        in = new JRadioButton("Inpatient");


        Dimension windowSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(windowSize.width, windowSize.height);
        frame.setLocationRelativeTo(null);;
        frame.setVisible(true);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        //frame.setResizable(false);
    }

    private void createPanels(){
        //JPanel instantiate
        side = new JPanel();
        top = new JPanel();
        center = new JPanel();

        //JPanel color
        side.setBackground(new Color(0xefeff2)); //(0xF5F4F0)); //0xbbb6cf)); //
        top.setBackground(new Color(0x2664A6)); //0x273b5a)); //(0xe56a6a));
        //top.setBackground(Color.lightGray);
        center.setBackground(Color.WHITE);

        //JPanel Size
        side.setPreferredSize(new Dimension(200,200));
        top.setPreferredSize(new Dimension(150,150));
        center.setPreferredSize(new Dimension(200,200));

        //set layout
        center.setLayout(new BorderLayout());

    }

    private void createButtons(){

        appointScheduling = new JButton("Appointment Schedule");
        patientRegistration = new JButton("Patient Entry and Info");
        billingInfo = new JButton("Billing");
        doctorList = new JButton("Doctor List and Schedule");
        emerContacts = new JButton("Emergency contacts");

        appointScheduling.setPreferredSize(new Dimension(200, 35));
        patientRegistration.setPreferredSize(new Dimension(200, 35));
        billingInfo.setPreferredSize(new Dimension(200, 35));
        doctorList.setPreferredSize(new Dimension(200, 35));
        emerContacts.setPreferredSize(new Dimension(200, 35));

        appointScheduling.setFocusable(false);
        doctorList.setFocusable(false);
        billingInfo.setFocusable(false);
        patientRegistration.setFocusable(false);
        emerContacts.setFocusable(false);

        appointScheduling.setBackground(new Color(0xefeff2)); //(0xefeff2));
        doctorList.setBackground(new Color(0xefeff2));
        billingInfo.setBackground(new Color(0xefeff2));
        emerContacts.setBackground(new Color(0xefeff2));
        patientRegistration.setBackground(new Color(0xefeff2));

        side.add(appointScheduling);
        side.add(patientRegistration);
        side.add(doctorList);
        side.add(billingInfo);
        side.add(emerContacts);
    }
}

