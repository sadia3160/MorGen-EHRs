package gui.mainpage.admin;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AppointmentForm {

    JPanel panel = new JPanel();
    JLabel id, appointID, appointDate, docInCharge, appointTime;
    JTextField idT, aidT;
    JDateChooser appointDateT;
    JComboBox docT, timeSelection;

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
        panel.add(timeSelection);
        panel.add(appointTime);

        panel.setSize(555,555);
        return panel;
    }

    private void createLabels(){
        id = new JLabel("Patient ID");
        id.setBounds(20,130, 125, 30);
        idT = new JTextField();
        idT.setBounds(130, 133, 325, 30);

        appointID = new JLabel("Appointment ID");
        appointID.setBounds(20,170, 125,30);

        aidT = new JTextField();
        aidT.setBounds(130, 173, 325, 30);

        appointDate = new JLabel("Appointment Date");
        appointDate.setBounds(20,210,125,30);
        appointDateT = new JDateChooser();
        appointDateT.setBounds(130, 210, 325, 30);
        appointDateT.setBorder(BorderFactory.createEtchedBorder());

        appointTime = new JLabel("Appointment Time");
        appointTime.setBounds(20, 250, 125, 30);
        String[] time = {"5:00", "6:00", "7:00",
                         "8:00", "9:00", "10:00", "11:00","12:00","13:00","14:00","15:00","16:00",
                         "17:00","18:00","19:00","20:00","21:00","22:00","23:00","00:00", "1:00", "2:00", "3:00", "4:00"
        };
        timeSelection = new JComboBox(time);
        timeSelection.setBounds(130, 253, 325, 30);


        docInCharge = new JLabel("Doctor in Charge");
        docInCharge.setBounds(20, 290, 125, 30);
        String[] opt = {"Naima Choudhury", "Mariyama Islam", "Zakia Imam", "Inaiya Mim", "Takrima Begum"};
        docT = new JComboBox(opt);
        docT.setBounds(130, 293, 325, 30);
        docT.setBackground(new Color(0xe4e3e1));
        docT.setEditable(true);


    }

    public JLabel getImage(){

        JLabel forImage = new JLabel();

        ImageIcon icon1 = new ImageIcon("src/gui/pictures/MorGenWB1.png");
        Image tempImage = icon1.getImage().getScaledInstance(171,35, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(tempImage);

        forImage.setIcon(icon2);
        return forImage;
    }

    //patID, appID, appDate, appTime, docInCharge
    public String getID(){
        String i = idT.getText();
        return i;
    }
    public String appointID(){
        String a = aidT.getText();
        return a;
    }
    public Date getAppointDate(){
        Date dt = appointDateT.getDate();
        return dt;
    }
    public String getAppointTime(){
        String ts = (String)timeSelection.getSelectedItem();
        return ts;
    }
    public String getDocInCharge(){
        String doch = (String)docT.getSelectedItem();
        return doch;
    }

}
