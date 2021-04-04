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

@WebServlet(name = "DeleteSchedule")
public class DeleteSchedule extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();


        Schedule schedule = new Schedule();
        /*set all the  details to setters */

        schedule.setsId(Integer.parseInt(request.getParameter("scheduleId")));

        ScheduleDao sdao= new ScheduleDaoImpl();
        sdao.delete(schedule);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
