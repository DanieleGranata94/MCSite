<%@ page import="java.util.Iterator" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.Citta" %>
<%@ page import="Model.Quiz" %>
<%@ page import="Model.Question" %>
<%@ page import="Model.Reply" %>


<!DOCTYPE html>

<html>

<body>

<jsp:include page="base.jsp"></jsp:include>






<br>




<form id="risposta"  method="POST" action="valutazione">

    <h1>Cominciamo il quiz  ${username}! Per la citta  ${citta}</h1>

    <input type="hidden" name="citta" value="${citta}">



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



          <%
            Question qvalue = iterator.next(); //assign individual employee record to the employee class object

            Iterator<Reply> iteratorReply = qvalue.getReplies().iterator();  // Iterator interface
            %>
                <td style="padding: 10px;" width="55%">
                  <a name ="domanda"<%=qvalue.getId()%> value="<%=qvalue.getQuestion()%>"></a><b><%=qvalue.getQuestion()%></b></td>



                <table style="width: 100%;">
                <%
            while(iteratorReply.hasNext())  // iterate through all the data until the last record
            {
               Reply qreply = iteratorReply.next();
                %>
                  <tr>

                    <td>
                      <input type="checkbox"  value='<%=qvalue.getQuestion()%>:<%=qreply.getReply()%>:<%=qreply.isEsatto()%>' name="check">
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




