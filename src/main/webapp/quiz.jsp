<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Classes.Citta" %>
<%@ page import="Classes.Quiz" %>
<%@ page import="Classes.Question" %>
<%@ page import="Classes.Reply" %>


<!DOCTYPE html>

<html>

<body>

<jsp:include page="base.jsp"></jsp:include>






<br>

  <h1>Cominciamo il quiz  ${username}! Per la citta ${citta}</h1>



<form id="risposta"  method="POST" action="valutazione">

  <table border="1" style="width: 99%; ">



  <% Quiz q = (Quiz) request.getAttribute("quiz"); %>
  <%

    if(request.getAttribute("quiz") != null)  // Null check for the object
    {
        Iterator<Question> iterator = q.getQuestions().iterator();  // Iterator interface

        while(iterator.hasNext())  // iterate through all the data until the last record
        {
          %>
              <tr style="border-bottom: 1px solid #ddd" >

        <br>

          <%
            Question qvalue = iterator.next(); //assign individual employee record to the employee class object

            Iterator<Reply> iteratorReply = qvalue.getReplies().iterator();  // Iterator interface
            %>
                <td style="padding: 10px;" width="55%"><br>
                  <a name ="domanda"<%=qvalue.getId()%> value="<%=qvalue.getQuestion()%>"></a><b><%=qvalue.getQuestion()%></b></td>

                <br>

                <table style="width: 100%;">
                <%
            while(iteratorReply.hasNext())  // iterate through all the data until the last record
            {
               Reply qreply = iteratorReply.next();
                %>
                  <tr>
                    <br>
                    <td>

                      <input type="checkbox"  value='<%=qreply.getReply()%>' name="check" >
                      <a><%=qreply.getReply()%></a>
                      </input>

                    </td>
                  </tr>


              <%
            }

                %>

  <%
        }
    }
%>
                </table>
                <input style="margin-left: 300px" type="submit" value="Invia le risposte!">



</form>




