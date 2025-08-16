package gui.mainpage.admin;

import database.dbCon;

import javax.swing.*;
import java.sql.PreparedStatement;

public class savePatData {

    savePatData(JDialog dialog1, String pid, String pnm, String bdt, String bgrp, String gndr, String pphn, String gphn, String addr, String prf, String w, String r, String ptype, String notes) {
        int k = 0;
        dbCon connection = new dbCon(); // patID, patName, birthDate, bloodGroup, gender, patientPhone, guardianPhone,address,
        try {
            String query = "INSERT INTO PatientForm (patID,patName,birthDate,bloodGroup,gender,patientPhone,guardianPhone,address,profession,notes,patType,ward,room) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pst = connection.con.prepareStatement(query);
            pst.setString(1, pid);
            pst.setString(2, pnm);
            pst.setString(3, bdt);
            pst.setString(4, bgrp);
            pst.setString(5, gndr);
            pst.setString(6, pphn);
            pst.setString(7, gphn);
            pst.setString(8, addr);
            pst.setString(9, prf);
            pst.setString(10, notes);
            pst.setString(11, ptype);
            pst.setString(12, w);
            pst.setString(13, r);
            k = pst.executeUpdate();

        } catch (Exception e) {
            e.printStackTrace();
        }
        if (k > 0) {
            JOptionPane.showMessageDialog(null, "Data saved successfully!", "Message", JOptionPane.INFORMATION_MESSAGE, null);
            dialog1.dispose();
        }
    }
}
