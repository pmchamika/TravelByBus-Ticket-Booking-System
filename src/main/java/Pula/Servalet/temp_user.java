package Pula.Servalet;


import DBconnect.ConnectionMySql;
import Pula.Model.Temp_user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;

@WebServlet(name = "temp_user")
public class temp_user extends HttpServlet {


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();

        Temp_user temp_user = new Temp_user();
        /*set all the  details to setters */

        System.out.println(request.getParameter("temp_Fname"));
        temp_user.setTemp_Fname(request.getParameter("temp_Fname"));
        temp_user.setTemp_Address(request.getParameter("temp_Address"));
        temp_user.setTemp_mobile(request.getParameter("temp_mobile"));
        temp_user.setTemp_nic(request.getParameter("temp_nic"));


        System.out.println(temp_user.getTemp_Fname());
        // response.sendRedirect("TockenDetails.jsp");

        try {    /*calling the mysql connection class*/

            ConnectionMySql conn = ConnectionMySql.getCon();


            /*get all the details through getters */
            String temp_Fname="";
            temp_Fname = temp_user.getTemp_Fname();
            String temp_Address = temp_user.getTemp_Address();
            String temp_mobile = temp_user.getTemp_mobile();
            String temp_nic= temp_user.getTemp_nic();
            System.out.println(temp_Fname);

            if(!"".equalsIgnoreCase(temp_Address)) {

                String query2 = "insert into temp_user(temp_Fname,temp_Address,temp_mobile,temp_nic) values ('" + temp_Fname + "','" + temp_Address + "','" + temp_mobile + "','" + temp_nic + "')";
                System.out.println(query2);
                conn.insertAndUpdate(query2);
                String q3="SELECT `temp_UserID` FROM `temp_user` WHERE `temp_Fname` = '"+temp_Fname+"' AND `temp_Address` = '"+temp_Address+"' AND `temp_mobile` = '"+temp_mobile+"' AND `temp_nic` = '"+temp_nic+"' ORDER BY `temp_UserID` DESC LIMIT 1";
                ResultSet re=conn.selectQuery(q3);
                if(re.next()){
                    out.println(re.getInt("temp_UserID"));
                }
            }
            //response.sendRedirect("TockenDetails.jsp");
        } catch (Exception e) {
//            System.err.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}