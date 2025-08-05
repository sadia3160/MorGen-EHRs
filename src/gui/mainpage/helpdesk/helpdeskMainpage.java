package gui.mainpage.helpdesk;

import javax.swing.*;
import java.awt.*;

public class helpdeskMainpage {
    JPanel side,top,center;
    public helpdeskMainpage(){

        JFrame frame = new JFrame("MorGen EHRs | Help Desk");
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

        side.setBackground(new Color(0xf3f1ea));
        top.setBackground(new Color(0xfbc15d));
        center.setBackground(Color.WHITE);

        side.setPreferredSize(new Dimension(200,200));
        top.setPreferredSize(new Dimension(150,150));
        center.setPreferredSize(new Dimension(200,200));
    }

    private void createButtons(){
        JButton doctor = new JButton("Doctor Lists");
        JButton cabin = new JButton("Available Cabins");
        JButton amb = new JButton("Ambulance");
        JButton message = new JButton("Message");
        JButton emcon = new JButton("Emergency Contacts");

        doctor.setPreferredSize(new Dimension(200,35));
        cabin.setPreferredSize(new Dimension(200,35));
        amb.setPreferredSize(new Dimension(200,35));
        message.setPreferredSize(new Dimension(200,35));
        emcon.setPreferredSize(new Dimension(200,35));

        doctor.setFocusable(false);
        cabin.setFocusable(false);
        amb.setFocusable(false);
        message.setFocusable(false);
        emcon.setFocusable(false);

        doctor.setBorder(BorderFactory.createEtchedBorder());
        cabin.setBorder(BorderFactory.createEtchedBorder());
        amb.setBorder(BorderFactory.createEtchedBorder());
        message.setBorder(BorderFactory.createEtchedBorder());
        emcon.setBorder(BorderFactory.createEtchedBorder());

        doctor.setBackground(new Color(0xf3f1ea));
        cabin.setBackground(new Color(0xf3f1ea));
        amb.setBackground(new Color(0xf3f1ea));
        message.setBackground(new Color(0xf3f1ea));
        emcon.setBackground(new Color(0xf3f1ea));

        side.add(doctor);
        side.add(cabin);
        side.add(amb);
        side.add(message);
        side.add(emcon);
    }
}
