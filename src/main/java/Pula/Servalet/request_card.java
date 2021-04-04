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


@WebServlet(name = "request_card")
public class request_card extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int cus_uid=1;

        PrintWriter out = response.getWriter();

        Request_Card requestcard = new Request_Card();
        /*set all the  details to setters */







        try {    /*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();


            /*get all the details through getters */


            double price=560.00;
            String approvalStatus="Pending";



            String query1 = "insert into card_request(cus_uid,price,approvalStatus) values ('"+cus_uid+"','"+price+"','"+approvalStatus+"')";
            int i1 = conn.insertAndUpdate(query1);


        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}




