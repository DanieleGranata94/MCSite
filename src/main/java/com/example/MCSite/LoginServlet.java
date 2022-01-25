package com.example.MCSite;

import Classes.Email;
import Classes.User;

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
        String username,password,email,checkedUsername,checkedEmail;
        username=request.getParameter("username");
        email=request.getParameter("email");
        password=request.getParameter("password");
        checkedUsername=request.getParameter("userUsed");
        checkedEmail=request.getParameter("emailUsed");



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

            if(checkedEmail!=null)
            {
                Email e1=new Email(email);
                User user1= new User.UserBuilder(e1,password).buildEmail(e1,password);
                System.out.println(user1.getEmail().getEmail());
                String Useremail=user1.getEmail().getEmail();

                System.out.println(Useremail+" "+user1.getPassword());

                String query="SELECT email,password from utente where utente.email = '"+Useremail+"'";
                resultSet=statement.executeQuery(query);
                resultSet.next();

                System.out.println(resultSet.getString(1));
                System.out.println(resultSet.getString(2));


                if(Useremail.equals(resultSet.getString(1)) && user1.getPassword().equals(resultSet.getString(2)))
                {
                    request.getRequestDispatcher("/play.jsp").forward(request,response);
                    System.out.println("accesso valido");
                }
                else
                {
                    request.setAttribute("error","Errore, Riprova!");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                    System.out.println("errore username o password");

                }
            }
            else if(checkedUsername!=null)
            {
                User user1= new User.UserBuilder(username,password).buildUser(username,password);

                String query="SELECT username,password from utente where utente.username = '"+user1.getUsername()+"'";
                System.out.println(query);
                resultSet=statement.executeQuery(query);
                resultSet.next();

                if(user1.getUsername().equals(resultSet.getString(1)) && user1.getPassword().equals(resultSet.getString(2)))
                {
                    request.getRequestDispatcher("/play.jsp").forward(request,response);
                    System.out.println("accesso valido");
                }
                else
                {
                    request.setAttribute("error","Errore, Riprova!");
                    request.getRequestDispatcher("/login.jsp").forward(request,response);
                    System.out.println("errore username o password");

                }

            }



        } catch (SQLException throwables) {
            System.out.println("Eccezione");

            throwables.printStackTrace();
        }


    }


    public void destroy() {
    }
}