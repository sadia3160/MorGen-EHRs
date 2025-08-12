package gui.mainpage.admin;

import gui.mainpage.emerContacts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class adminMainpage extends AdminMainpageParent implements ActionListener {

    JButton newAppointment, createBill;
    JComboBox deptSelection;

    public adminMainpage(){

        super("MorGen EHRs | Admin Portal");

        in.addActionListener(this);
        appointScheduling.addActionListener(this);
        patientRegistration.addActionListener(this);
        billingInfo.addActionListener(this);
        emerContacts.addActionListener(this);
        doctorList.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == patientRegistration){
            patientButton();
        }
        if(e.getSource() == appointScheduling){
            appointSchButton();
        }
        if(e.getSource() == addPat){
           addPatButton();
        }
        if(e.getSource() == billingInfo){
            billingInfoButton();
        }
        if(e.getSource() == emerContacts){
            center.removeAll();
            emerContacts ec = new emerContacts();
            JScrollPane jsp = ec.myEmer();
            center.add(jsp, BorderLayout.CENTER);
            center.revalidate();
            center.repaint();
        }
        if(e.getSource() == createBill){
            showBillForm();
        }
        if(e.getSource() == doctorList){
            showDoctorListPage();
        }
        if(e.getSource() == newAppointment){
            addNewAppointment();
        }
    }

    private void patientButton(){

        center.removeAll();

        addPat = new JButton("Add Patient");
        addPat.addActionListener(this);
        addPat.setLayout(new BorderLayout());
        addPat.setPreferredSize(new Dimension(100, 31));
        addPat.setFocusable(false);
        addPat.setBackground(Color.LIGHT_GRAY); //(new Color(0x237fb7));
        addPat.setForeground(Color.WHITE);
        addPat.setFont(new Font(null, Font.BOLD, 13));
        center.add(addPat, BorderLayout.PAGE_START);

        center.revalidate();
        center.repaint();
    }

    private void appointSchButton(){

        center.removeAll();

        Scheduling appoint = new Scheduling();
        temp = appoint.createCal();


        newAppointment = new JButton("New Appointment");
        newAppointment.setBackground(Color.LIGHT_GRAY); //(new Color(0x237fb7));
        newAppointment.setForeground(Color.WHITE);
        newAppointment.addActionListener(this);
        newAppointment.setLayout(new BorderLayout());
        newAppointment.setPreferredSize(new Dimension(100, 31));
        newAppointment.setFocusable(false);
        newAppointment.setFont(new Font(null, Font.BOLD, 13));

        center.add(temp, BorderLayout.WEST);
        center.add(newAppointment, BorderLayout.NORTH);

        center.revalidate();
        center.repaint();
        //Solve the problem
    }

    private void addPatButton(){

        PatientEntry pe2 = new PatientEntry();
        JPanel jp = pe2.createJPanel();

        dialog1 = new JDialog(frame, "Patient Registration Form", true);
        dialog1.setLayout(null);
        ImageIcon icon = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        dialog1.setIconImage(icon.getImage());
        dialog1.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        ButtonGroup group = new ButtonGroup(); group.add(in); group.add(out);

        out.setBounds(450,103, 150, 30);
        in.setBounds(450, 143, 150, 30);

        JLabel ward = new JLabel("Ward");
        ward.setBounds(450, 190, 150, 15);
        JTextField wardt = new JTextField();
        wardt.setBounds(450, 205 , 150, 30);
        JLabel room = new JLabel("Room");
        room.setBounds(450, 240, 150, 15);
        JTextField roomt = new JTextField();
        roomt.setBounds(450,255, 150, 30);

        dialog1.add(ward);
        dialog1.add(wardt);
        dialog1.add(room);
        dialog1.add(roomt);

        out.setFocusable(false);
        in.setFocusable(false);
        dialog1.add(out);
        dialog1.add(in);
        dialog1.add(jp);
        dialog1.setSize(700,750);
        dialog1.setLocationRelativeTo(null);
        dialog1.setVisible(true);
    }

    private void billingInfoButton(){

        center.removeAll();

        JPanel billPanel = new JPanel();
        billPanel.setLayout(new GridBagLayout());

        createBill = new JButton("Create");
        JButton sendBill = new JButton("Send");
        createBill.addActionListener(this);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7,7,7,7);

        //gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 0;
        billPanel.add(createBill, gbc);
        //gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 1;
        gbc.gridy = 0;
        //gbc.weightx = 1.0;
        billPanel.add(sendBill, gbc);

        center.add(billPanel, BorderLayout.NORTH);

        center.revalidate();
        center.repaint();
    }

    private void showBillForm(){

        InvoicesPrepare ip = new InvoicesPrepare();
        JPanel temp = ip.invoiceForm();

        dialog2 = new JDialog(frame, "Invoices Form", true);
        dialog2.setLayout(null);
        ImageIcon icon = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        dialog2.setIconImage(icon.getImage());
        dialog2.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        dialog2.add(temp);
        dialog2.setSize(700,750);
        dialog2.setLocationRelativeTo(null);

        dialog2.setVisible(true);
//        center.add(dialog2, BorderLayout.CENTER);
//        center.revalidate();
//        center.repaint();
    }

    private void showDoctorListPage(){

        center.removeAll();

        String[] depts = { "Anesthesiology Specialist",
                "Burn Trauma Plastic & General Surgery",
                "Cancer Specialist",
                "Cardiology Specialist",
                "Cardiovascular & Thoracic Surgeon",
                "Chest Lung & Esophagus Surgeon",
                "Child Specialist",
                "Colorectal Surgery Specialist",
                "Dental Specialist",
                "Dermatology Specialist",
                "Diabetes & Hormone Specialist",
                "Endocrinology Department",
                "Eye Specialist",
                "Gastroenterology Specialist",
                "General & Laparoscopic Surgery Specialist",
                "General Practitioner",
                "Gynecology & Obstetrics Specialist",
                "Hematology (Blood) Specialist",
                "Hepatobiliary & Pancreatic Surgery",
                "Infertility Specialist",
                "Kidney Specialist",
                "Liver Specialist",
                "Medicine Specialist",
                "Neonatology",
                "Nephrology Department",
                "Neurology/Neuromedicine Specialist",
                "Neurosurgery Specialist",
                "Oncology Specialist",
                "Oncology Surgery",
                "Orthopedics Specialists & Trauma Surgeon",
                "Pediatric Surgery Specialist",
                "Physical Medicine Specialist",
                "Plastic Surgery Specialist",
                "Psychiatry (Mental) Specialist",
                "Rheumatology Specialist",
                "Urology Specialist",
                "Vascular Surgery Specialist" };

        deptSelection = new JComboBox(depts);
        deptSelection.setEditable(true);

        JPanel temp = new JPanel();
        temp.setLayout(new BorderLayout());
        temp.add(deptSelection, BorderLayout.WEST);

        center.add(temp, BorderLayout.NORTH);

        center.revalidate();
        center.repaint();
    }

    private void addNewAppointment(){
        AppointmentForm apf = new AppointmentForm();
        JPanel ap = apf.appointForm();

        dialog3 = new JDialog(frame, "Appointment Registration Form", true);
        dialog3.setLayout(null);
        ImageIcon icon = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        dialog3.setIconImage(icon.getImage());
        dialog3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        JLabel myLogo =  apf.getImage();
        myLogo.setBounds(205, 51, 251, 41);
        myLogo.setBorder(BorderFactory.createEtchedBorder());

        dialog3.add(myLogo);
        dialog3.add(ap);
        dialog3.setSize(700,750);
        dialog3.setLocationRelativeTo(null);
        dialog3.setVisible(true);
    }
}
