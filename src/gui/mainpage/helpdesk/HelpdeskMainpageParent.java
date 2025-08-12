package gui.mainpage.helpdesk;

import javax.swing.*;
import java.awt.*;

public class HelpdeskMainpageParent {

    JPanel side,top,center;
    JButton emcon, message;
    JFrame frame;

    protected HelpdeskMainpageParent(String titleName){
        frame = new JFrame();
        frame.setTitle(titleName);
        ImageIcon iconLogo = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        frame.setIconImage(iconLogo.getImage());
        frame.setLayout(new BorderLayout(5,5));

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

        center.setLayout(new GridBagLayout());
    }

    private void createButtons(){
        JButton doctor = new JButton("Doctor Lists");
        JButton cabin = new JButton("Available Cabins");
        JButton amb = new JButton("Ambulance");
        message = new JButton("Message");
        emcon = new JButton("Emergency Contacts");

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

        doctor.setBackground(new Color(0xf3f1ea));
        cabin.setBackground(new Color(0xf3f1ea));
        amb.setBackground(new Color(0xf3f1ea));
        message.setBackground(new Color(0xf3f1ea));
        emcon.setBackground(new Color(0xf3f1ea));

        side.add(doctor);
        side.add(cabin);
        side.add(amb);
        side.add(emcon);
        side.add(message);
    }
}
