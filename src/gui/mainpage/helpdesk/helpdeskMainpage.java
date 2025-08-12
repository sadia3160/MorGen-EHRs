package gui.mainpage.helpdesk;

import gui.mainpage.emerContacts;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class helpdeskMainpage extends HelpdeskMainpageParent implements ActionListener {

    public helpdeskMainpage(){

        super("MorGen EHRs | Help Desk");

        emcon.addActionListener(this);
        message.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == emcon){
            center.removeAll();
            emerContacts ec = new emerContacts();
            JScrollPane jsp = ec.myEmer();
            center.add(jsp);
            center.revalidate();
            center.repaint();
        }
        if(e.getSource() == message){
            center.removeAll();

            center.revalidate();
            center.repaint();
        }
    }
}
