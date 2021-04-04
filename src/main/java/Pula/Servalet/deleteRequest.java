package Pula.Servalet;

import DBconnect.ConnectionMySql;
import Pula.Model.Request_Card;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "deleteRequest")
public class deleteRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();


        Request_Card requestCard = new Request_Card();
        /*set all the  details to setters */

        requestCard.setrID(Integer.parseInt(request.getParameter("rID")));
        try {	/*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();
            /*get the customer nic from getters */
            int rID=requestCard.getrID();


            /*when no of customers equal to one*/
            String query = "Delete FROM card_request Where rID='"+rID+"'";
            int i= conn.insertAndUpdate(query);




        } catch (Exception e) {
            System.err.println(e);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
