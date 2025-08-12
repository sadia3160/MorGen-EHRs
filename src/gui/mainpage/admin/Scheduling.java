package gui.mainpage.admin;

import com.toedter.calendar.JCalendar;

import javax.swing.*;
import java.awt.*;

public class Scheduling {

    JCalendar adminCal = new JCalendar();
    protected JPanel createCal() {
        JPanel tmp = new JPanel();
        tmp.setLayout(new BorderLayout());
        //adminCal.setPreferredSize(new Dimension(1330,200));
        adminCal.setDecorationBackgroundColor(new Color(0xf3f1ea));
        adminCal.setBackground(new Color(0xf3f1ea));

        tmp.add(adminCal, BorderLayout.NORTH);
        return tmp;
    }
}
