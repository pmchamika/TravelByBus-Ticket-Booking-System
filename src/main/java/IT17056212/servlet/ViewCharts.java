package IT17056212.servlet;

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

@WebServlet(name = "ViewCharts")
public class ViewCharts extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        try {    /*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();
            int stat=0;
            String query = "select s_ID,add_date,count(s_ID) from payment where p_status='"+stat+"' group by s_ID";
            ResultSet r= conn.selectQuery(query);



            JsonArray array=new JsonArray();
            while(r.next()){
                JsonObject item=new JsonObject();
                item.addProperty("s_ID",r.getInt("s_ID"));
                int sid=r.getInt("s_ID");
                String query2 = "select r_No,b_No from schedule where s_ID='"+sid+"'";

                ResultSet r2= conn.selectQuery(query2);
                while(r2.next()){
                    item.addProperty("r_No",r2.getString("r_No"));
                }

                item.addProperty("add_date",r.getString("add_date"));
                item.addProperty("countSid",r.getString("count(s_ID)"));

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
