package gui.mainpage.admin.buttons;

import javax.swing.*;
import java.awt.*;

public class btn3 {
    JButton cancelA, saveA, cancelP, saveP;
    public JButton getCancelA(){
        cancelA = new JButton("Cancel");
        cancelA.setBounds(339,453,77,25);
        cancelA.setFocusable(false);
        cancelA.setBackground(Color.LIGHT_GRAY); //(new Color(0x4d6466));
        cancelA.setForeground(Color.DARK_GRAY);
        cancelA.setFont(new Font(null, Font.BOLD, 13));
        return cancelA;
    }
    public  JButton getSaveA(){
        saveA = new JButton("Save");
        saveA.setBounds(427,453,77,25);
        saveA.setFocusable(false);
        saveA.setBackground(new Color(0x237fb7)); //(0x4d6466));
        saveA.setForeground(Color.WHITE);
        saveA.setFont(new Font(null, Font.BOLD, 13));
        return saveA;
    }
    public JButton getCancelP(){
        cancelP = new JButton("Cancel");
        cancelP.setBounds(490,667,75,25);
        cancelP.setFocusable(false);
        cancelP.setBackground(Color.lightGray);
        cancelP.setForeground(Color.DARK_GRAY);
        cancelP.setFont(new Font(null, Font.BOLD, 13));
        return cancelP;
    }

    public JButton getSaveP() {
        saveP = new JButton("Save");
        saveP.setBounds(580,667,75,25);
        saveP.setFocusable(false);
        saveP.setBackground(new Color(0x237fb7));
        saveP.setForeground(Color.WHITE);
        saveP.setFont(new Font(null, Font.BOLD, 13));
        return saveP;
    }
}
