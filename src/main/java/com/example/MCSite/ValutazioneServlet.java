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
        String[] replies =request.getParameterValues("check");

        int punteggio=0;
        int punteggiocomplessivo=0;
        ArrayList<GivenReply> risposte_sbagliate=new ArrayList<>();

        for(String reply:replies)
        {
            String[] replyparts = reply.split(":");
            String question = replyparts[0];
            String replyString = replyparts[1];
            String esatto = replyparts[2];
            if(Boolean.parseBoolean(esatto))
            {
                punteggio++;
            }
            else
            {
                GivenReply gr=new GivenReply(question,replyString,Boolean.parseBoolean(esatto));
                risposte_sbagliate.add(gr);
            }

        }
        punteggiocomplessivo=(int)(((float)punteggio/(float)replies.length)*10);

        request.setAttribute("score",punteggiocomplessivo);

        System.out.println("Punteggio complessivo: "+punteggiocomplessivo +"/10");

        // query che ottiene le risposte giuste e metto a confronto le risposte date con quelle giuste creano un
        // array di coppie. Dal lato frontend se sono uguali allora la dò come esatta se sono svagliate allora
        // mostro la risposta data e quella esatta
        //+ punteggio


        request.getRequestDispatcher("/risultati.jsp").forward(request,response);

    }


    public void destroy() {
    }
}