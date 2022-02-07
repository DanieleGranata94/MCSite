package com.example.MCSite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection con = null;
    public static final String dbUrl = "jdbc:mysql://localhost:3306/mcsite";
    public static final String dbname = "root";
    public static final String dbPassword = "";
    public static final String dbDriver = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection()
    {
        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl, dbname, dbPassword);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}