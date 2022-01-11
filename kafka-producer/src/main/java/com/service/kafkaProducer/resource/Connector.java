package com.service.kafkaProducer.resource;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Connector {

    String url = "jdbc:mysql://localhost/kafka_events";
    String user = "root";
    String pass = "";
    Connection con;

    public void makeConnection() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.jdbc.Driver");
        con= DriverManager.getConnection(url , user ,pass);
    }

    public void storeData(String msg){

        try {
            makeConnection();
            System.out.println("in store data method2:" + msg);
            //String QUERY = "INSERT INTO event_data VALUES ('1',msg)";
            Statement stmt=con.createStatement();
            stmt.executeUpdate("INSERT INTO `event_data2`(siNo,data) VALUE ('"+1+"','"+msg+"')");
            System.out.println("Done2");
            con.close();
        }
        catch (Exception e){

        }

    }
}
