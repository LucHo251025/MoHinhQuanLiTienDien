package com.example.mohinhquanlitiendien.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionUtil {
    Connection con = null;

    public static Connection conDB() {
        try {
            String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=qltd;encrypt=true;trustServerCertificate=true";
            Connection connect = DriverManager.getConnection(connectionUrl, "sa","Hothanhluc25@");
            return connect;
        } catch ( SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

}
