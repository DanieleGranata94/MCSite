package com.example.MCSite;

import Classes.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;

import static java.sql.Types.NULL;

@WebServlet(name = "valutazione", value = "/valutazione")
public class ValutazioneServlet extends HttpServlet {
    private HttpSession session;



    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        doPost(request,response);

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        Enumeration<String> check=request.getParameterNames();

        System.out.println(java.util.Arrays.asList(check.nextElement()));


        System.out.println(check);
        request.getRequestDispatcher("/risultati.jsp").forward(request,response);

    }


    public void destroy() {
    }
}