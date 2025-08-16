package database;

import java.sql.*;

public class dbCon {

    public Connection con;
    public Statement statement;

    public dbCon() {

        String url = "jdbc:mysql://localhost:3306/ehrs_db";
        String userName = "root", password = "LifeStore";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver"); //1. registered the Driver class
            con = DriverManager.getConnection(url, userName, password); //2. created connection
           // statement = con.createStatement(); //3. created statement
            /*
                ResultSet rs = statement.executeQuery("SELECT * FROM login"); //4. executed queries
                while (rs.next()) {
                    System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3));
                }
                con.close(); //5. close connection
            */
        }
        catch(Exception e){
            e.printStackTrace();
            //System.out.println(e); [Don't prints the line number and file info where exception occured]
            //sout prints only exception type and message
        }
    }

}


//5 steps to connect database
/*
    1. register the Driver class
    2. create connection
    3. create statement
    4. execute queries
    5. close connection
*/