package gui.mainpage.admin;

import gui.mainpage.admin.buttons.btn1;
import gui.mainpage.admin.buttons.btn2;
import gui.mainpage.admin.buttons.btn3;
import gui.mainpage.emerContacts;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class adminMainpage extends AdminMainpageParent implements ActionListener {

    JButton newAppointment, createBill, saveA, cancelA, saveP, cancelP;
    JComboBox deptSelection;
    JPanel ap, jp, mydocPanel, temp;
    AppointmentForm apf; PatientEntry pe2;
    JTextField wardt, roomt;
    JButton add, update,delete;
    InvoicesPrepare ip;
    getBillTable bill;

    public adminMainpage(){ //for Administration's Main Page

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
            center.removeAll();
            deptSelection = new JComboBox(depts);
            deptSelection.setEditable(true);
            deptSelection.addActionListener(this);

            JPanel temp = new JPanel();
            temp.setLayout(new BorderLayout());
            temp.add(deptSelection, BorderLayout.WEST);
            center.add(temp, BorderLayout.NORTH);

            mydocPanel = new JPanel();
            String selectedDept = (String)deptSelection.getSelectedItem();
            showDoctorListPage(selectedDept);
        }
        if(e.getSource() == newAppointment){
            addNewAppointment();
        }
        if(e.getSource() == saveA){
            saveAppointment();
        }
        if(e.getSource() == cancelA){
            dialog3.dispose();
        }
        if(e.getSource() == cancelP){
            dialog1.dispose();
        }
        if(e.getSource() == saveP){
            savePatientData();
        }
        if(e.getSource() == deptSelection){

            String selectedDept = (String)deptSelection.getSelectedItem();
            showDoctorListPage(selectedDept);
        }
        if(e.getSource() == add){
            bill = new getBillTable();
            //bill.addRow();
            String pid = ip.getID();
            String itm = ip.getItm();
            int quan = ip.getQuan();
            int pri = ip.getPri();
            bill.addItems(pid,itm,quan,pri);
        }
    }

    private void patientButton(){   //For Patient Entry

        center.removeAll();
        btn1 b1  = new btn1();
        addPat = b1.getButton();
        addPat.addActionListener(this);
        center.add(addPat, BorderLayout.PAGE_START);
        center.revalidate();
        center.repaint();
    }

    private void appointSchButton(){

        center.removeAll();
        Scheduling appoint = new Scheduling();
        temp = appoint.createCal();
        btn2 b2 = new btn2();
        newAppointment = b2.getButton();
        newAppointment.addActionListener(this);
        center.add(temp, BorderLayout.WEST);
        center.add(newAppointment, BorderLayout.NORTH);
        center.revalidate();
        center.repaint();
        //Solve the problem
    }

    private void addPatButton(){

        pe2 = new PatientEntry();
        jp = pe2.createJPanel();

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
        wardt = new JTextField();
        wardt.setBounds(450, 205 , 150, 30);
        JLabel room = new JLabel("Room");
        room.setBounds(450, 240, 150, 15);
        roomt = new JTextField();
        roomt.setBounds(450,255, 150, 30);

        createPatientFormButton();
        jp.add(saveP);
        jp.add(cancelP);

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

        ip = new InvoicesPrepare();
        temp = ip.invoiceForm();

        //Create table and interact with database!
        add = ip.getAdd();
        update = ip.getUpdate();
        delete = ip.getDelete();
        add.addActionListener(this);
        update.addActionListener(this);
        delete.addActionListener(this);

        temp.add(add);
        temp.add(update);
        temp.add(delete);

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

    private void showDoctorListPage(String selectedDept){

        if(mydocPanel != null){
            mydocPanel.removeAll();
        }

        DoctorList lis = new DoctorList();
        JScrollPane test = lis.myDoctorList(selectedDept);
        test.setPreferredSize(new Dimension(1271,591));
        mydocPanel.add(test);

        center.add(mydocPanel, BorderLayout.CENTER);

        center.revalidate();
        center.repaint();
    }


    private void addNewAppointment(){
        apf = new AppointmentForm();
        ap = apf.appointForm();

        dialog3 = new JDialog(frame, "Appointment Registration Form", true);
        dialog3.setLayout(null);
        ImageIcon icon = new ImageIcon("src/gui/pictures/MLogoWB1.png");
        dialog3.setIconImage(icon.getImage());
        dialog3.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        createAppointFormButtons();

        JLabel myLogo =  apf.getImage();
        myLogo.setBounds(195, 41, 171, 35);
        myLogo.setBorder(BorderFactory.createEtchedBorder());

        dialog3.add(myLogo);
        ap.add(saveA);
        ap.add(cancelA);
        dialog3.add(ap);
        dialog3.setSize(555,555);
        dialog3.setLocationRelativeTo(null);
        dialog3.setVisible(true);
    }

    private void createAppointFormButtons(){
            btn3 b3 = new btn3();
            cancelA = b3.getCancelA();
            saveA = b3.getSaveA();
            cancelA.addActionListener(this);
            saveA.addActionListener(this);
    }

    private void createPatientFormButton(){
            btn3 ob = new btn3();
            cancelP = ob.getCancelP();
            saveP = ob.getSaveP();
            cancelP.addActionListener(this);
            saveP.addActionListener(this);
    }

    private void saveAppointment(){
        //patID, appID, appDate, appTime, docInCharge
        String pid = apf.getID();
        String aid = apf.appointID();
        Date appo = apf.getAppointDate();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/YYYY");
        String adate = sdf.format(appo);
        String atime = apf.getAppointTime();
        String docInC = apf.getDocInCharge();
        //Date check!
        saveAppointmentData apd = new saveAppointmentData(dialog3,pid,aid,adate,atime,docInC);
    }

    private void savePatientData(){

        String pid = pe2.getPatID();
        String pnm = pe2.getPatName();
        String bdt = pe2.getBirthDate();
        String bgrp = pe2.getBloodGroup();
        String gndr = pe2.getGender();
        String pphn = pe2.getPatPhone();
        String gphn = pe2.getGurPhone();
        String addr = pe2.getAddress();
        String prf = pe2.getPrf();

        //notes, patType, ward, room
        String w = wardt.getText();
        String r = roomt.getText();
        String ptype;
        if(in.isSelected()) ptype = "Inpatient";
        else ptype = "Outpatient";

        String notes = pe2.getNotes();
        savePatData spd = new savePatData(dialog1,pid,pnm,bdt,bgrp,gndr,pphn,gphn,addr,prf,w,r,ptype,notes);
    }

    getDeptString obj = new getDeptString();
    String[] depts = obj.getDepts();
}
