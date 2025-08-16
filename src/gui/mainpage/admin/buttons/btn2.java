package gui.mainpage.admin.buttons;

import javax.swing.*;
import java.awt.*;

public class btn2 {

    public JButton getButton(){
        JButton newAppointment = new JButton("New Appointment");
        newAppointment.setBackground(Color.LIGHT_GRAY); //(new Color(0x237fb7));
        newAppointment.setForeground(Color.WHITE);
        newAppointment.setLayout(new BorderLayout());
        newAppointment.setPreferredSize(new Dimension(100, 31));
        newAppointment.setFocusable(false);
        newAppointment.setFont(new Font(null, Font.BOLD, 13));
        return newAppointment;
    }
}
