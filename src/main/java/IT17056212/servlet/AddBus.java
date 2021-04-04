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

import java.util.logging.Logger;

@WebServlet(name = "bus")
public class AddBus extends HttpServlet {
    public static Logger log =Logger.getLogger(AddBus.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();


        Bus bus = new Bus();
        /*set all the  details to setters */

        bus.setBusNo(request.getParameter("busNo"));
        bus.setModel(request.getParameter("model"));
        bus.setNoSeats(request.getParameter("No_BSeats"));
        try {
            bus.setAdd_uid(Integer.parseInt(session.getAttribute("uid").toString()));
        }catch (Exception e){
            e.printStackTrace();
        }


        BusDao bdao= new BusDaoImpl();
        bdao.add(bus);
        log.info("Add Complete");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
