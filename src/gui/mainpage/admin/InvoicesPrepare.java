package gui.mainpage.admin;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InvoicesPrepare {

        JPanel panel = new JPanel();
        JLabel id, admitDate, relDate, docInCharge;
        JTextField idT;
        JDateChooser admitT, relT;
        JComboBox docT;
        JButton cancel, add, update, delete;
        JComboBox decide;
        getBillTable gbt;

        protected JPanel invoiceForm(){
            panel = new JPanel();
            panel.setLayout(null);
            panel.setBackground(new Color(0xf0f0f0));

            createLabels();

            gbt = new getBillTable(); //fetch item, quantity, price
            JScrollPane billScroll = gbt.getBillScroll();
            //billScroll.setLayout(null);
            billScroll.setBounds(30,270,611,350);

            panel.add(billScroll);

            panel.add(id);
            panel.add(idT);
            panel.add(admitDate);
            panel.add(admitT);
            panel.add(relDate);
            panel.add(relT);
            panel.add(docInCharge);
            panel.add(docT);

            createButton();
            panel.add(cancel);
            panel.add(decide);

            panel.setSize(700,750);
            return panel;

        }
        private void createLabels(){
            id = new JLabel("Patient ID");
            id.setBounds(20,100, 100, 30);
            idT = new JTextField();
            idT.setBounds(130, 103, 300, 30);

            admitDate = new JLabel("Admit Date");
            admitDate.setBounds(20,140, 100,30);

            admitT = new JDateChooser();
            admitT.setBounds(130, 143, 300, 30);
            admitT.setBorder(BorderFactory.createEtchedBorder());

            relDate = new JLabel("Release Date");
            relDate.setBounds(20,180,100,30);
            relT = new JDateChooser();
            relT.setBounds(130, 183, 300, 30);
            relT.setBorder(BorderFactory.createEtchedBorder());

            docInCharge = new JLabel("Doctor in Charge");
            docInCharge.setBounds(20, 220, 100, 30);
            String[] opt = {"Naima Choudhury", "Mariyama Islam", "Zakia Imam", "Inaiya Mim", "Takrima Begum"};
            docT = new JComboBox(opt);
            docT.setBounds(130, 223, 300, 30);
            docT.setBackground(new Color(0xe4e3e1));
            docT.setEditable(true);
        }

        private void createButton(){

            cancel = new JButton("Save");
            cancel.setBounds(580,665,75,28);
            cancel.setFocusable(false);
            cancel.setBackground(new Color(0x237fb7)); //(0x4d6466));
            cancel.setForeground(Color.WHITE);
            cancel.setFont(new Font(null, Font.BOLD, 13));

            String[] options = {"All", "Create", "Send"};
            decide = new JComboBox(options);

            decide.setBounds(490,667,77,25);
            decide.setFocusable(false);
            decide.setBackground(Color.LIGHT_GRAY);
            decide.setForeground(Color.DARK_GRAY);
            decide.setFont(new Font(null, Font.BOLD, 13));
        }

        public JButton getAdd() {
            add = new JButton("Add");
            add.setBounds(445, 229, 55, 21);
            add.setFont(new Font("Open Sans", Font.BOLD, 9));
            return add;
        }
        public JButton getUpdate() {
            update = new JButton("Update");
            update.setBounds(505, 229, 60, 21);
            update.setFont(new Font("Open Sans", Font.BOLD, 9));
            return update;
        }
        public JButton getDelete() {
            delete = new JButton("Delete");
            delete.setBounds(570, 229, 60, 21);
            delete.setFont(new Font("Open Sans", Font.BOLD, 9));
            return delete;
        }

//            String patientID = patID;
//            String item = it;
//            int quantity = quan;
//            int price = pr;

        public String getID(){
            return idT.getText();
        }
        public String getItm(){
            return gbt.getItem();
        }
        public int getQuan(){
            return gbt.getQuantity();
        }
        public int getPri(){
            return gbt.getPrice();
        }
}
