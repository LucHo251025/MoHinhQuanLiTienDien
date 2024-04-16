package com.example.mohinhquanlitiendien.Util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MethodHelper {
    public Connection getConnection() throws SQLException {
        String connectionUrl = "jdbc:sqlserver://127.0.0.1:1433;databaseName=LibraryManagement;encrypt=true;trustServerCertificate=true;";
        Connection con = DriverManager.getConnection(connectionUrl, "sa","Hothanhluc25#");
        return con;
    }

}

