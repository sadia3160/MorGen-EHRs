package gui.mainpage.admin.buttons;

import javax.swing.*;
import java.awt.*;

public class btn1 {

    public JButton getButton(){
        JButton addPat = new JButton("Add Patient");
        addPat.setLayout(new BorderLayout());
        addPat.setPreferredSize(new Dimension(100, 31));
        addPat.setFocusable(false);
        addPat.setBackground(Color.LIGHT_GRAY); //(new Color(0x237fb7));
        addPat.setForeground(Color.WHITE);
        addPat.setFont(new Font(null, Font.BOLD, 13));
        return addPat;
    }
}
