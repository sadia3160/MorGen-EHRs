package gui.mainpage.admin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class DoctorList {

    String dept; JTable table;
    public JScrollPane myDoctorList(String selectedDept){

        dept = selectedDept;

        DefaultTableModel tableModel = new DefaultTableModel();
        table = new JTable(tableModel);
        tableModel.addColumn("Doctor Name");
        tableModel.addColumn("Degree");
        tableModel.addColumn("Contact");

        switch (selectedDept){
            case "Anesthesiology Specialist":
                Object[] rec1 = {"Md. Shahnewaz Chowdhury", "MBBS, DA(DU),MCPS (Anesthesiology)", "01842995065"};
                tableModel.addRow(rec1);
                break;
            case "Burn Trauma Plastic & General Surgery":
                Object[] rec2 = {"Md. Abdul Mannan", "MBBS, MCPS, FCPS(Surgery), FCPS(Plastic and Reconstructive Surgery)", "01737-3826485"};
                tableModel.addRow(rec2);
                break;
            case "Cancer Specialist":
                Object[] rec3 = {" Dr.M.Kamal Uddin", "MBBS, DMRT, Fellow Oncology (IN, SG, UK)", "01737-3826485"};
                tableModel.addRow(rec3);
                break;

//            case "Cardiology Specialist":
//
//                break;
//            case "Cardiovascular & Thoracic Surgeon":
//
//                break;
//            case "Chest Lung & Esophagus Surgeon":
//
//                break;
//            case "Child Specialist":
//
//                break;
//            case "Colorectal Surgery Specialist":
//
//                break;
//            case "Dental Specialist":
//
//                break;
//            case "Dermatology Specialist":
//
//                break;
//            case "Diabetes & Hormone Specialist":
//
//                break;
//            case "Endocrinology Department":
//
//                break;
//            case "Eye Specialist":
//
//                break;
//            case "Gastroenterology Specialist":
//
//                break;
//            case "General & Laparoscopic Surgery Specialist":
//
//                break;
//            case "General Practitioner":
//
//                break;
//            case "Gynecology & Obstetrics Specialist":
//
//                break;
//            case "Hematology (Blood) Specialist":
//
//                break;
//            case "Hepatobiliary & Pancreatic Surgery":
//
//                break;
//            case "Infertility Specialist":
//
//                break;
//            case "Kidney Specialist":
//
//                break;
//            case "Liver Specialist":
//
//                break;
//            case "Medicine Specialist":
//
//                break;
//            case "Neonatology":
//
//                break;
//            case "Nephrology Department":
//
//                break;
//            case "Neurology/Neuromedicine Specialist":
//
//                break;
//            case "Neurosurgery Specialist":
//
//                break;
//            case "Oncology Specialist":
//
//                break;
//            case "Oncology Surgery":
//
//                break;
//            case "Orthopedics Specialists & Trauma Surgeon":
//
//                break;
//            case "Pediatric Surgery Specialist":
//
//                break;
//            case "Physical Medicine Specialist":
//
//                break;
//            case "Plastic Surgery Specialist":
//
//                break;
//            case "Psychiatry (Mental) Specialist":
//
//                break;
//            case "Rheumatology Specialist":
//
//                break;
//            case "Urology Specialist":
//
//                break;
//            case "Vascular Surgery Specialist":
//
//                break;
        }
        JScrollPane scroll = new JScrollPane(table);
        return scroll;
    }

}
