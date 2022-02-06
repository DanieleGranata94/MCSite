package com.example.MCSite;

import Model.Citta;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;

@WebServlet(name = "Play", value = "/play")
public class PlayServlet extends HttpServlet {
    private HttpSession session;
    static Connection connection= DatabaseConnection.getConnection();




    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        session = request.getSession();
        String contextPath = request.getContextPath();
        String servletPath = request.getServletPath();
        ResultSet resultSet = null;


        String username = request.getParameter("username");
        request.setAttribute("username", username);





            Connection connection = null;
            try {
                Statement statement = connection.createStatement();
                String query="SELECT citta from quiz";
                resultSet=statement.executeQuery(query);


                ArrayList<Citta> citta=new ArrayList<Citta>();



                ResultSetMetaData rsmd = resultSet.getMetaData();
                //scorro il resultset e metto le citta in un array
                int columnsNumber = rsmd.getColumnCount();
                while (resultSet.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        if (i > 1) System.out.print(",  ");
                        String columnValue = resultSet.getString(i);
                        citta.add(new Citta(columnValue));
                    }
                }



                request.setAttribute("citta",citta);





                request.getRequestDispatcher("/play.jsp").forward(request,response);


            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }



    }


    public void destroy() {
    }



}