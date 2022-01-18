package com.example.MCSite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private HttpSession session;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.err.println("Errore");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        ResultSet resultSet = null;
        session = request.getSession();
        String username,password;
        username=request.getParameter("username");
        password=request.getParameter("password");
        session.setAttribute("username",username);


        String dbUrl="jdbc:mysql://localhost:3306/mcsite";
        String dbname="root";
        String dbPassword="";
        String dbDriver="com.mysql.cj.jdbc.Driver";

        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        try {
            Connection connection= DriverManager.getConnection(dbUrl,dbname,dbPassword);
            Statement statement=connection.createStatement();
            String query="SELECT username,password from utente where utente.username = '"+username+"'";
            resultSet=statement.executeQuery(query);
            resultSet.next();

            if(username.equals(resultSet.getString(1)) && password.equals(resultSet.getString(2)))
            {
                request.getRequestDispatcher("/map.jsp").forward(request,response);
                System.out.println("accesso valido");
            }
            else
            {
                request.getRequestDispatcher("/login.jsp").forward(request,response);
                System.out.println("errore username o password");

            }
        } catch (SQLException throwables) {
            System.out.println("Eccezione");

            throwables.printStackTrace();
        }


    }


    public void destroy() {
    }
}