package gui.mainpage.admin;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;

public class AppointmentForm {

    JPanel panel = new JPanel();
    JLabel id, appointID, appointDate, docInCharge;
    JTextField idT, aidT;
    JDateChooser appointDateT;
    JComboBox docT;
    JButton cancel, save;

    protected JPanel appointForm() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0xf1f9ff)); //0xf0f0f0));

        createLabels();

        panel.add(id);
        panel.add(idT);
        panel.add(appointID);
        panel.add(appointDateT);
        panel.add(appointDate);
        panel.add(aidT);
        panel.add(docInCharge);
        panel.add(docT);

        createButton();
        panel.add(cancel);
        panel.add(save);

        panel.setSize(700,750);
        return panel;
    }

    private void createLabels(){
        id = new JLabel("Patient ID");
        id.setBounds(20,130, 100, 30);
        idT = new JTextField();
        idT.setBounds(130, 133, 300, 30);

        appointID = new JLabel("Appointment ID");
        appointID.setBounds(20,170, 100,30);

        aidT = new JTextField();
        aidT.setBounds(130, 173, 300, 30);

        appointDate = new JLabel("Appointment Date");
        appointDate.setBounds(20,210,100,30);
        appointDateT = new JDateChooser();
        appointDateT.setBounds(130, 210, 300, 30);
        appointDateT.setBorder(BorderFactory.createEtchedBorder());

        docInCharge = new JLabel("Doctor in Charge");
        docInCharge.setBounds(20, 250, 100, 30);
        String[] opt = {"Naima Choudhury", "Mariyama Islam", "Zakia Imam", "Inaiya Mim", "Takrima Begum"};
        docT = new JComboBox(opt);
        docT.setBounds(130, 253, 300, 30);
        docT.setBackground(new Color(0xe4e3e1));
        docT.setEditable(true);
    }

    private void createButton(){

        cancel = new JButton("Cancel");
        cancel.setBounds(490,667,77,25);
        cancel.setFocusable(false);
        cancel.setBackground(new Color(0x4d6466));
        cancel.setForeground(Color.WHITE);
        cancel.setFont(new Font(null, Font.BOLD, 13));


        save = new JButton("Save");
        save.setBounds(580,667,77,25);
        save.setFocusable(false);
        save.setBackground(new Color(0x237fb7)); //(0x4d6466));
        save.setForeground(Color.WHITE);
        save.setFont(new Font(null, Font.BOLD, 13));
    }

    public JLabel getImage(){

        JLabel forImage = new JLabel();

        ImageIcon icon1 = new ImageIcon("src/gui/pictures/MorGenWB1.png");
        Image tempImage = icon1.getImage().getScaledInstance(251,41, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(tempImage);

        forImage.setIcon(icon2);
        return forImage;
    }
}
