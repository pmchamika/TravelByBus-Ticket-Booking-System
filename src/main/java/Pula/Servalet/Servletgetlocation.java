package Pula.Servalet;

import DBconnect.ConnectionMySql;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

@WebServlet(name = "Servletgetlocation")
public class Servletgetlocation extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String id=request.getParameter("rou");
        ConnectionMySql conn = ConnectionMySql.getCon();
        String sql="SELECT `bus_Stop` FROM `route` WHERE `r_No` = '"+id+"'";
        System.out.println(sql);
        try {
            ResultSet re=conn.selectQuery(sql);
            if (re.next()){
                out.println(re.getString("bus_Stop"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
