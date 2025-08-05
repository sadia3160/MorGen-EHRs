package gui.mainpage.patient;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

public class patientMainpage {

    JPanel side,top,center;
    public patientMainpage(){

        JFrame frame = new JFrame("MorGen EHRs | Patient Portal");
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
        frame.setSize(windowSize.width,windowSize.height);
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
        side.setBackground(new Color(0xeafffe));
        top.setBackground(new Color(0x80c2b4));
        center.setBackground(Color.WHITE);

        //JPanel Size
        side.setPreferredSize(new Dimension(200,200));
        top.setPreferredSize(new Dimension(150,150));
        center.setPreferredSize(new Dimension(200,200));
    }

    private void createButtons(){

        JButton appointOverview = new JButton("Appointment Overview");
        JButton doctorInfo = new JButton("Doctor Lists and Contact");
        JButton billingInfo = new JButton("Billing Information");
        JButton messageHelpdesk = new JButton("Message");
        JButton notification = new JButton("Notifications");


        appointOverview.setPreferredSize(new Dimension(200, 35));
        doctorInfo.setPreferredSize(new Dimension(200, 35));
        billingInfo.setPreferredSize(new Dimension(200, 35));
        messageHelpdesk.setPreferredSize(new Dimension(200, 35));
        notification.setPreferredSize(new Dimension(200, 35));

        appointOverview.setFocusable(false);
        doctorInfo.setFocusable(false);
        billingInfo.setFocusable(false);
        messageHelpdesk.setFocusable(false);
        notification.setFocusable(false);

        appointOverview.setBackground(new Color(0xeafffe));
        doctorInfo.setBackground(new Color(0xeafffe));
        billingInfo.setBackground(new Color(0xeafffe));
        messageHelpdesk.setBackground(new Color(0xeafffe));
        notification.setBackground(new Color(0xeafffe));

        appointOverview.setBorder(BorderFactory.createEtchedBorder());
        doctorInfo.setBorder(BorderFactory.createEtchedBorder());
        billingInfo.setBorder(BorderFactory.createEtchedBorder());
        messageHelpdesk.setBorder(BorderFactory.createEtchedBorder());
        notification.setBorder(BorderFactory.createEtchedBorder());


        side.add(appointOverview);
        side.add(doctorInfo);
        side.add(billingInfo);
        side.add(notification);
        side.add(messageHelpdesk);
    }
}
