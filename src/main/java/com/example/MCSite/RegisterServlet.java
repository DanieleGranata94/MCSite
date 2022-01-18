package com.example.MCSite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

import static java.sql.Types.NULL;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    private HttpSession session;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.err.println("Errore");

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        ResultSet resultSet = null;
        session = request.getSession();
        String username,password,email;
        username=request.getParameter("username");
        password=request.getParameter("password");
        email=request.getParameter("email");
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

            PreparedStatement st = connection
                    .prepareStatement("insert into utente values(?, ?, ?, ?)");

            st.setInt(1,NULL);
            st.setString(2,username);
            st.setString(3,email);
            st.setString(4,password);

            st.executeUpdate();
            st.close();
            PrintWriter out = response.getWriter();


            out.println("<html><body><b>Successfully Inserted"
                    + "</b></body></html>");


            request.getRequestDispatcher("/login.jsp").forward(request,response);


            } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    public void destroy() {
    }
}