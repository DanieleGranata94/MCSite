package com.example.MCSite;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "Classifica", value = "/classifica")
public class ClassificaServlet extends HttpServlet {
    private HttpSession session;



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        System.out.println("Classifica");
        request.getRequestDispatcher("/classifica.jsp").forward(request,response);


    }


    public void destroy() {
    }
}