package com.example.MCSite;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static Connection con = null;

    static
    {

        String dbUrl = "jdbc:mysql://localhost:3306/mcsite";
        String dbname = "root";
        String dbPassword = "";
        String dbDriver = "com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(dbDriver);
            con = DriverManager.getConnection(dbUrl, dbname, dbPassword);
        }
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
    public static Connection getConnection()
    {
        return con;
    }
}