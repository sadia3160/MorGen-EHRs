package gui.mainpage.lab;

import gui.mainpage.emerContacts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class labMainpage extends LabMainpageParent implements ActionListener {

    public labMainpage(){

        super("MorGen EHRs | Laboratory Portal");
        ecom.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == ecom){
            center.removeAll();
            emerContacts ec = new emerContacts();
            JScrollPane jsp = ec.myEmer();
            center.add(jsp, BorderLayout.CENTER);
            center.revalidate();
            center.repaint();
        }
    }
}
