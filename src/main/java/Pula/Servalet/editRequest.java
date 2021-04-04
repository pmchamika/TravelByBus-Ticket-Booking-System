package Pula.Servalet;

import DBconnect.ConnectionMySql;
import Pula.Model.Request_Card;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "editRequest")
public class editRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        Request_Card requestCard = new Request_Card();
        /*set all the  details to setters */

        requestCard.setrID(Integer.parseInt(request.getParameter("rID")));
        String status=request.getParameter("query");

        try {    /*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();

            if(status.equalsIgnoreCase("selectQ")) {
                int rID = requestCard.getrID();
                String query3 = "select rID,cus_uid,price,approvalStatus from card_request where rID='" + rID + "' ";
                ResultSet r = conn.selectQuery(query3);


                JsonArray array = new JsonArray();
                while (r.next()) {
                    JsonObject item = new JsonObject();
                    item.addProperty("rID", r.getString("rID"));
                    item.addProperty("cus_uid", r.getString("cus_uid"));

                    array.add(item);
                }

//            gson.add("datas",array);
                System.out.println("Array:" + array.toString());
                out.println(array.toString());
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
