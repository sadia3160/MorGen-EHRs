package gui.mainpage.admin;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class PatientEntry {

    JButton save, cancel;
    JLabel name, birthDate, bGroup, gender, patientPhone, guardianPhone, address, profession, notes;
    JTextField namet, pt, gt, addi, prf;
    JTextArea notesT;
    JDateChooser jdc;
    JComboBox jcb1, jcb2;
    JPanel panel;
    JScrollPane scroll;

    protected JPanel createJPanel() {

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0xf1f9ff));

        createLabels();

        panel.add(name);
        panel.add(birthDate);
        panel.add(jcb1);
        panel.add(jdc);
        panel.add(bGroup);
        panel.add(gender);
        panel.add(jcb2);
        panel.add(patientPhone);
        panel.add(guardianPhone);
        panel.add(address);
        panel.add(profession);
        panel.add(notes);
        panel.add(namet);
        panel.add(pt);
        panel.add(gt);
        panel.add(addi);
        panel.add(prf);
        panel.add(scroll);

        createButton();
        panel.add(cancel);
        panel.add(save);

        panel.setSize(700,750);

        return panel;
    }

    private void createLabels(){

        name = new JLabel("Name");
        name.setBounds(20,100, 100, 30);
        namet = new JTextField();
        namet.setBounds(130, 103, 300, 30);

        birthDate = new JLabel("Date of Birth");
        birthDate.setBounds(20,140, 100,30);

        jdc = new JDateChooser();
        jdc.setBounds(130, 143, 300, 30);
        jdc.setBorder(BorderFactory.createEtchedBorder());

        bGroup = new JLabel("Blood Group");
        bGroup.setBounds(20,180,100,30);
        String[] options = {"O+", "O-", "A+", "A-", "B+", "B-", "AB+", "AB-"};
        jcb1 = new JComboBox(options);
        jcb1.setBounds(130, 183, 300, 30);
        jcb1.setBackground(new Color(0xe4e3e1));
        jcb1.setEditable(true);

        gender = new JLabel("Gender");
        gender.setBounds(20, 220, 100, 30);
        String[] opt = {"Female", "Male"};
        jcb2 = new JComboBox(opt);
        jcb2.setBounds(130, 223, 300, 30);
        jcb2.setBackground(new Color(0xe4e3e1));

        patientPhone = new JLabel("Patient Phone");
        patientPhone.setBounds(20, 260, 100, 30);
        pt = new JTextField();
        pt.setBounds(130, 263, 300, 30);

        guardianPhone = new JLabel("Guardian Phone");
        guardianPhone.setBounds(20, 300, 100, 30);
        gt = new JTextField();
        gt.setBounds(130, 303, 300, 30);

        address = new JLabel("Address");
        address.setBounds(20,340, 100, 30);
        addi = new JTextField();
        addi.setBounds(130, 343, 300, 30);

        profession = new JLabel("Profession");
        profession.setBounds(20,380,100,30);
        prf = new JTextField();
        prf.setBounds(130, 383, 300, 30);

        notes = new JLabel("Notes");
        notes.setBounds(20,420,100,30);
        notesT = new JTextArea();
        notesT.setLineWrap(true); //for line
        notesT.setWrapStyleWord(true); //for word

        scroll = new JScrollPane(notesT, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scroll.setBounds(130, 423, 300, 100);
    }

    private void createButton(){

        cancel = new JButton("Cancel");
        cancel.setBounds(490,667,75,25);
        cancel.setFocusable(false);
        cancel.setBackground(Color.lightGray);
        cancel.setForeground(Color.DARK_GRAY);
        cancel.setFont(new Font(null, Font.BOLD, 13));

        save = new JButton("Save");
        save.setBounds(580,667,75,25);
        save.setFocusable(false);
        save.setBackground(new Color(0x237fb7));
        save.setForeground(Color.WHITE);
        save.setFont(new Font(null, Font.BOLD, 13));
    }
}





