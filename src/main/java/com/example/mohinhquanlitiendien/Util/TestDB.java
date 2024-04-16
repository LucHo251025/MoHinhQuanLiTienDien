package com.example.mohinhquanlitiendien.Util;


import java.sql.*;

import static java.sql.DriverManager.getConnection;

public class TestDB {


public static void main(String[] args){
    try (Connection con = getConnection();
         Statement statement = con.createStatement();){
        String SQL = "SELECT * FROM dangnhap ";
        System.out.println(SQL);
        ResultSet rs = statement.executeQuery(SQL);
        while (rs.next()) {
            System.out.println(rs.getString(1) +" "+ rs.getString(2) );

        }
    }
    catch (SQLException e) {

        e.printStackTrace();

    }


}

        public static Connection getConnection() throws SQLException {
            String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=qltd;encrypt=true;trustServerCertificate=true";
            Connection con = DriverManager.getConnection(connectionUrl, "sa","Hothanhluc25@");
            return con;
        }


}
