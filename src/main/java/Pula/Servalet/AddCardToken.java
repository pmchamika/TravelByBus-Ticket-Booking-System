package Pula.Servalet;

import DBconnect.ConnectionMySql;
import IT17152938.md5_en;
import Pula.Model.TokenCard;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "AddCardToken")
public class AddCardToken extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int UID= Integer.parseInt(session.getAttribute("uid").toString());
        ;
        PrintWriter out = response.getWriter();

        TokenCard card = new TokenCard();
        /*set all the  details to setters */

        card.setCus_uid(request.getParameter("cusID"));
        card.setExpire(request.getParameter("book_off_date"));
        card.setrID(request.getParameter("rID"));



        // response.sendRedirect("TockenDetails.jsp");

        try {    /*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();


            /*get all the details through getters */
            String rID=card.getrID();
            String  cus_uid = card.getCus_uid();
            String expireD=card.getExpire();
            Date date=new SimpleDateFormat("MM/dd/yyyy").parse(expireD);;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            expireD = formatter.format(date)+" 00:00:00";

            double price=0.0;
            String token_hashID="Hash12";
            String t_type="Card";


            String query1 = "insert into token(t_type,price,t_ExpireDate,token_hashID,cus_uid,add_uid) values ('"+t_type+"','"+price+"','"+expireD+"','"+token_hashID+"','"+cus_uid+"','"+UID+"')";
            int i1 = conn.insertAndUpdate(query1);

            String query5 = "SELECT `t_ID` FROM `token` WHERE `t_type` = 'Card' AND `cus_uid` = '"+cus_uid+"' ORDER BY `t_ID` DESC LIMIT 1";
            ResultSet i2 = conn.selectQuery(query5);

            String newHash="";
            int t_id=0;

            if(i2.next()){
                t_id=i2.getInt("t_ID");
                newHash= md5_en.md5_con(String.valueOf(t_id));
            }

            String query6 = "UPDATE token SET token_hashID='"+newHash+"'  WHERE t_ID='"+t_id+"' ";
            int i6= conn.insertAndUpdate(query6);


//update the hash md5
          String query3 = "UPDATE card_request SET approvalStatus='Aceepted'  WHERE rID='"+rID+"' ";
          int i3= conn.insertAndUpdate(query3);


            out.println(newHash);

            //response.sendRedirect("TockenDetails.jsp");
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}




