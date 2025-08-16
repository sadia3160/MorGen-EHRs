package gui.mainpage.admin;

import com.mysql.cj.util.StringUtils;
import database.dbCon;

import javax.swing.*;
import java.sql.PreparedStatement;

public class saveAppointmentData {

    saveAppointmentData(JDialog dialog3, String pid,String aid,String adate,String atime,String docInC){
        if(!StringUtils.isEmptyOrWhitespaceOnly(pid) && !StringUtils.isEmptyOrWhitespaceOnly(aid) &&
                !StringUtils.isNullOrEmpty(pid) && !StringUtils.isNullOrEmpty(aid)) {
            int k = 0;
            dbCon dbConnect = new dbCon();
            try {
                String que = "INSERT INTO AppointmentForm (patID, appID, appDate, appTime, docInCharge) VALUES (?,?,?,?,?)";
                PreparedStatement pst = dbConnect.con.prepareStatement(que);
                pst.setString(1, pid);
                pst.setString(2, aid);
                pst.setString(3, adate);
                pst.setString(4, atime);
                pst.setString(5, docInC);
                k = pst.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (k > 0) {
                JOptionPane.showMessageDialog(null, "Data saved successfully!", "Message", JOptionPane.INFORMATION_MESSAGE, null);
                dialog3.dispose();
            }
        }
        else{
            JOptionPane.showMessageDialog(null, "Enter All Data", "Error", JOptionPane.ERROR_MESSAGE, null);
        }
    }
}
