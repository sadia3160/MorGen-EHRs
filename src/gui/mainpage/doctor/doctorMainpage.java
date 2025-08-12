package gui.mainpage.doctor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class doctorMainpage extends DoctorMainpageParent implements ActionListener {

    String currentSideBar = "", currentSubButton = "";
    JLabel label;
    JScrollPane scroll;
    JTextArea docNotes;

    public doctorMainpage(){

        super("MorGen EHRs | Doctor Portal");

        //add action listener
        patientCharts.addActionListener(this);
        home.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == patientCharts){
            sideBarCheck("patientCharts");
        }
        if(e.getSource() == history){
            buttonCheck("history");
        }
        if(e.getSource() == digno){
            buttonCheck("digno");
        }
        if(e.getSource() == medi){
            buttonCheck("medi");
        }
        if(e.getSource() == immu){
            buttonCheck("immu");
        }
        if(e.getSource() == aller){
            buttonCheck("aller");
        }
        if(e.getSource() == pres){
            buttonCheck("pres");
        }
        if(e.getSource() == vSign){
            buttonCheck("vSign");
        }
        if(e.getSource() == notes){
            buttonCheck("notes");
        }
        if(e.getSource() == home){
            sideBarCheck("home");
        }
    }

    private void sideBarCheck(String sidebar){
        if(currentSideBar.equals(sidebar)){ //if clicked on the same sidebar
            return;                         //then don't repaint and return
        }
        currentSideBar = sidebar;           //otherwise repaint the center
        center.removeAll();

        if(currentSideBar.equals("patientCharts")) {
            patientChartsPage();
        }
        if(currentSideBar.equals("home")){
            showHomeContent();
        }
        center.revalidate();
        center.repaint();
    }

    private void buttonCheck(String button){
        if(currentSubButton.equals(button)){
            return;
        }
        if(bottomOfCenterArea != null) {
            bottomOfCenterArea.removeAll();
            //center.remove(bottomOfCenterArea); don't remove from center, remove the contents of panel
        }
        currentSubButton = button;
        showContent(currentSubButton);
        center.revalidate();
        center.repaint();
    }

    private void patientChartsPage(){

        createSubButtons();
        setSubButtonsPositions();
        bottomOfCenterArea = new JPanel();
        bottomOfCenterArea.setLayout(new BorderLayout());
    }

    private void createSubButtons(){
        history = new JButton("Medical History");
        digno = new JButton("Diagnosis");
        medi = new JButton("Medications");
        immu = new JButton("Immunization Records");
        aller = new JButton("Allergies");
        pres = new JButton("E-prescription");
        vSign = new JButton("Vital Signs");
        notes = new JButton("Notes");
        save = new JButton("Save");
        save.setBackground(new Color(0x237fb7));
        save.setForeground(Color.WHITE);

        history.addActionListener(this);
        digno.addActionListener(this);
        medi.addActionListener(this);
        immu.addActionListener(this);
        aller.addActionListener(this);
        pres.addActionListener(this);
        vSign.addActionListener(this);
        notes.addActionListener(this);
        save.addActionListener(this);
    }

    private void setSubButtonsPositions(){
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7,7,7,7);

        searchBox = new JTextField();
        searchBox.setPreferredSize(new Dimension(100, 23));
        gbc.gridx = 0;
        gbc.gridy = 0;
        center.add(searchBox, gbc);
        gbc.gridx = 1;
        gbc.gridy = 0;
        center.add(history, gbc);
        gbc.gridx = 2;
        gbc.gridy = 0;
        center.add(digno, gbc);
        gbc.gridx = 3;
        gbc.gridy = 0;
        center.add(medi, gbc);
        gbc.gridx = 4;
        gbc.gridy = 0;
        center.add(immu, gbc);
        gbc.gridx = 5;
        gbc.gridy = 0;
        center.add(aller, gbc);
        gbc.gridx = 6;
        gbc.gridy = 0;
        center.add(pres, gbc);
        gbc.gridx = 7;
        gbc.gridy = 0;
        center.add(vSign, gbc);
        gbc.gridx = 8;
        gbc.gridy = 0;
        center.add(notes, gbc);
        gbc.gridx = 9;
        gbc.gridy = 0;
        center.add(save, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 9;
        gbc.weighty = 0.2;
        gbc.fill = GridBagConstraints.VERTICAL;
        center.add(Box.createVerticalGlue(), gbc);
    }

    private void showContent(String button){

        switch (button){
            case "history":
                createNotesArea("Medical History");
                break;
            case "digno":
                createNotesArea("Diagnosis");
                break;
            case "medi":
                createNotesArea("Medications");
                break;
            case "immu":
                createNotesArea("Immunization Dates");
                break;
            case "aller":
                createNotesArea("Allergy");
                break;
            case "pres":
                createNotesArea("E-prescription");
                break;
            case "vSign":
                createNotesArea("Vital Signs");
                break;
            case "notes":
                createNotesArea("Notes");
                break;
        }
    }


    private void createNotesArea(String labelText){
        docNotes = new JTextArea();
        docNotes.setLineWrap(true);
        docNotes.setWrapStyleWord(true);
        docNotes.setBackground(new Color(0xe3e8ea));

        scroll = new JScrollPane(docNotes, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
       // scroll.setPreferredSize(new Dimension(500,500));

        label = new JLabel();
        label.setText(labelText);
        label.setBackground(Color.LIGHT_GRAY);
        label.setFont(new Font("Verdana", Font.BOLD, 11));

        bottomOfCenterArea.add(label, BorderLayout.NORTH);
        bottomOfCenterArea.add(scroll, BorderLayout.CENTER);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7,7,7,7);
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 10;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        center.add(bottomOfCenterArea, gbc);
    }

    private void showHomeContent(){

        JPanel homePanel = new JPanel();
        homePanel.setLayout(new GridLayout(1,3,11,11));

        JPanel p1 = new JPanel();
        JLabel todo = new JLabel("To-Do List");
        todo.setBackground(Color.LIGHT_GRAY);
        todo.setFont(new Font("Verdana", Font.BOLD, 11));
        p1.add(todo);
        p1.setBorder(BorderFactory.createEtchedBorder());

        JPanel p2 = new JPanel();
        JLabel timer = new JLabel("Timer | Take a break!");
       // timer.setBounds(150,200, 100, 35);
        timer.setBackground(Color.LIGHT_GRAY);
        timer.setFont(new Font("Verdana", Font.BOLD, 11));
        p2.add(timer);
        p2.setBorder(BorderFactory.createEtchedBorder());

        JPanel p3 = new JPanel();
        JLabel note = new JLabel("Take Notes");
        //note.setBounds(250, 200, 100, 35);
        note.setFont(new Font("Verdana", Font.BOLD, 11));
        note.setBackground(Color.LIGHT_GRAY);
        p3.add(note);
        p3.setBorder(BorderFactory.createEtchedBorder());

        homePanel.add(p1);
        homePanel.add(p2);
        homePanel.add(p3);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;

        center.add(homePanel,gbc);
    }
}