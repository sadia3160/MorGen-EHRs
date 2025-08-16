package gui.mainpage.admin;

import database.dbCon;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class getBillTable {

    String item, patientID;
    int quantity, price;
    DefaultTableModel tableModel;
    JTable billTable;

    getBillTable(){

        //Items, Quantity, Price
        tableModel = new DefaultTableModel();
        billTable = new JTable(tableModel);
        billTable.setEnabled(true);
        billTable.setShowGrid(true);
        tableModel.addColumn("Items");
        tableModel.addColumn("Quantity");
        tableModel.addColumn("Price");
        int rows = tableModel.getRowCount();
        tableModel.setNumRows(rows+1);
    }
    protected JScrollPane getBillScroll(){
        JScrollPane scroll = new JScrollPane(billTable);
        //scroll.setLayout(null);
        //scroll.setBounds(30,300,300,350);
        scroll.setEnabled(true);
        return scroll;
    }

//    void addRow(){
//        //Object[] rec = {"",0,0};
//
//    }

    void addItems(String patID, String it, int quan, int pr){

        patientID = patID;
        item = it;
        quantity = quan;
        price = pr;

        try{
            dbCon dbconn = new dbCon();
            String query = "INSERT INTO BillTable (user_id,items,quantity,price,priceSum) VALUES (?,?,?,?,?)";
            PreparedStatement pst = dbconn.con.prepareStatement(query);
            pst.setString(1,patientID);
            pst.setString(2,item);
            pst.setInt(3,quantity);
            pst.setInt(4,price);
            pst.setInt(5,0);
            pst.executeUpdate();

            query = "SELECT (sum)price FROM BillTable where user_id = '"+patientID+"'";
            pst = dbconn.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            int totalBill = rs.getInt(4);
            System.out.println(totalBill);
            query = "INSERT INTO BillTable (priceSum) VALUES (?) WHERE user_id = '"+patientID+"'";
            pst = dbconn.con.prepareStatement(query);
            pst.setInt(4, totalBill);
            pst.executeUpdate();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public int getBill(String ud){
        String uid = ud;
        int totalBill = 0;
        try{
            dbCon dbconn = new dbCon();
            String query = "SELECT priceSum FROM BillTable where user_id = \""+uid+"\"";
            PreparedStatement pst = dbconn.con.prepareStatement(query);
            ResultSet rs = pst.executeQuery();
            totalBill = rs.getInt(4);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return totalBill;
    }

    public String getItem(){
        return item;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
