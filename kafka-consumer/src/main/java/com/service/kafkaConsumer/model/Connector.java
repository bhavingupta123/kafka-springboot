package com.service.kafkaConsumer.model;

import java.sql.*;
import java.util.Properties;

public class Connector {

    Connection con ;

    public void makeConnection() throws ClassNotFoundException, SQLException {
        try {
            con = DriverManager.getConnection(
                    "jdbc:postgresql://127.0.0.1:5432/events", "postgres", "root");

            if (con != null) {
                System.out.println("Connected to the database!");
            } else {
                System.out.println("Failed to make connection!");
            }

        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void storeData(String msg){

        try {
            makeConnection();
            System.out.println("in store data method 2:" + msg);
            Statement stmt=con.createStatement();
            stmt.executeUpdate("INSERT INTO service2 (data) VALUES ('"+msg+"') ");
            System.out.println("Done");
            con.close();
        }
        catch (Exception e){
            System.out.println("method 2 exception:" + e);
        }

    }
}

