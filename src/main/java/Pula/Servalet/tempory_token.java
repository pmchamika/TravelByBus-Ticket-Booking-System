package Pula.Servalet;

import DBconnect.ConnectionMySql;
import IT17152938.md5_en;
import Pula.Model.Tempory_token;

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

@WebServlet(name = "tempory_token")
public class tempory_token extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        int UID=Integer.parseInt(session.getAttribute("uid").toString());
        PrintWriter out = response.getWriter();

        Tempory_token temporyToken = new Tempory_token();
        /*set all the  details to setters */

        temporyToken.setTemp_spoint(request.getParameter("temp_spoint"));
        temporyToken.setTemp_epoint(request.getParameter("temp_epoint"));
        temporyToken.setTemp_qty(request.getParameter("temp_qty"));
        temporyToken.setTemp_date(request.getParameter("temp_date"));


        System.out.println(temporyToken.temp_spoint);
        // response.sendRedirect("TockenDetails.jsp");

        try {    /*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();


            /*get all the details through getters */
            int routid=Integer.valueOf(request.getParameter("rou"));
            String temp_spoint = temporyToken.getTemp_spoint();
            String temp_epoint = temporyToken.getTemp_epoint();
            String temp_qty = temporyToken.getTemp_qty();
            String temp_date= temporyToken.getTemp_date();
            int s_ID=1;


            double temp_price=10.00;
            double price=10.00;
            String sql ="SELECT `bus_Stop`,`price_per_point` FROM `route` WHERE `r_No` = '"+routid+"'";
            ResultSet rs1=conn.selectQuery(sql);
            if (rs1.next()){
                price=rs1.getDouble("price_per_point");
                String li=rs1.getString("bus_Stop");
                String liarr[]=li.split(",");
                int stp=0,enp=0;
                for (int i=0;i<liarr.length;i++){
                    if (temp_spoint.equalsIgnoreCase(liarr[i])){
                        stp=i;
                    }
                    if (temp_epoint.equalsIgnoreCase(liarr[i])){
                        enp=i;
                    }
                }

                int k=enp-stp;
                if(k<0){
                    k=k*(-1);
                }

                System.out.println(k+","+price+","+Double.valueOf(temp_qty));
                temp_price=k*price*Double.valueOf(temp_qty);
            }

            sql = "SELECT s_ID FROM `schedule` WHERE `r_No` = '"+routid+"'";
            rs1=conn.selectQuery(sql);

            if(rs1.next()){
                s_ID=rs1.getInt("s_ID");
            }

            String token_hashID="Hash";
            int cus_uid=Integer.valueOf(request.getParameter("tempuid"));


            Date date=new SimpleDateFormat("dd/MM/yyyy").parse(temp_date);;
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
            temp_date = formatter.format(date);
            String t_IssueDate=temp_date+" 00:00:00";
            String t_ExpireDate=temp_date+" 23:59:59";
            String t_type="Token";


            String query1 = "insert into token(t_type,price,t_IssueDate,t_ExpireDate,token_hashID,cus_uid,add_uid) values ('"+t_type+"','"+temp_price+"','"+t_IssueDate+"','"+t_ExpireDate+"','"+token_hashID+"','"+cus_uid+"','"+UID+"')";
            int i1 = conn.insertAndUpdate(query1);

            String query5 = "SELECT `t_ID` FROM `token` WHERE `t_type` = 'Token' AND `cus_uid` = '"+cus_uid+"' ORDER BY `t_ID` DESC LIMIT 1";
            ResultSet i2 = conn.selectQuery(query5);

            String newHash="";
            int t_id=0;

            if(i2.next()){
                t_id=i2.getInt("t_ID");
                newHash= md5_en.md5_con(String.valueOf(t_id));
            }


//update the hash md5
            String query3 = "UPDATE token SET token_hashID='"+newHash+"'  WHERE t_ID='"+t_id+"' ";
            int i3= conn.insertAndUpdate(query3);



            String query2 = "insert into tempory_token(s_ID,temp_spoint,temp_epoint,temp_qty,temp_date,temp_price,token_hashID,add_uid) values ('"+s_ID+"','"+temp_spoint+"','"+temp_epoint+"','"+temp_qty+"','"+temp_date+" 00:00:00','"+temp_price+"','"+newHash+"','"+UID+"')";
            int i = conn.insertAndUpdate(query2);

            out.println(newHash+","+temp_price);
        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}




