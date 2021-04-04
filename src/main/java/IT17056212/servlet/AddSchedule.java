package IT17056212.servlet;

import IT17056212.dao.ScheduleDao;
import IT17056212.daoImpl.ScheduleDaoImpl;
import IT17056212.model.Schedule;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "AddSchedule")
public class AddSchedule extends HttpServlet {
    public static Logger log =Logger.getLogger(AddSchedule.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();


        Schedule schedule = new Schedule();
        /*set all the  details to setters */

        schedule.setBusNo(request.getParameter("busNo"));
        schedule.setRouteNo(request.getParameter("routeNo"));
        schedule.setConId(Integer.parseInt(request.getParameter("cid")));
        schedule.setsDate(request.getParameter("s_date"));
        schedule.setsTime(request.getParameter("s_time"));
        schedule.setAdd_uid(Integer.parseInt(session.getAttribute("uid").toString()));

        ScheduleDao sdao= new ScheduleDaoImpl();
        sdao.add(schedule);

        log.info("Add complete");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
