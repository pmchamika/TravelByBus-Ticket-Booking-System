package IT17056212.servlet;

import IT17056212.dao.BusDao;
import IT17056212.daoImpl.BusDaoImpl;
import IT17056212.model.Bus;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "DeleteBus")
public class DeleteBus extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();


        Bus bus = new Bus();
        /*set all the  details to setters */

        bus.setbId(Integer.parseInt(request.getParameter("busId")));

        BusDao bdao= new BusDaoImpl();
        bdao.delete(bus);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
