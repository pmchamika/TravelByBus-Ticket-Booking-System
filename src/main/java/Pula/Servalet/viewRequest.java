package Pula.Servalet;

import DBconnect.ConnectionMySql;
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

@WebServlet(name = "viewRequest")
public class viewRequest extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        try {    /*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();

            String query3 = "select rID,cus_uid,price,approvalStatus,add_date from card_request ";
            ResultSet r= conn.selectQuery(query3);



            JsonArray array=new JsonArray();
            while(r.next()){
                JsonObject item=new JsonObject();
                item.addProperty("rID",r.getInt("rID"));
                item.addProperty("cus_uid",r.getString("cus_uid"));
                item.addProperty("price",r.getString("price"));
                item.addProperty("approvalStatus",r.getString("approvalStatus"));
                item.addProperty("add_date",r.getString("add_date"));

                array.add(item);
            }

//            gson.add("datas",array);
            System.out.println("Array:"+array.toString());
            out.println(array.toString() );

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
