package IT17056212.servlet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

@WebServlet(name = "UpdateSchedule")
public class UpdateSchedule extends HttpServlet {
    public static Logger log =Logger.getLogger(UpdateSchedule.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        Schedule schedule = new Schedule();
        ScheduleDao scheduleDao = new ScheduleDaoImpl();
        /*set all the  details to setters */

        schedule.setsId(Integer.parseInt(request.getParameter("scheduleId")));
        String status=request.getParameter("query");
        System.out.println(status);

            if(status.equalsIgnoreCase("selectQ")) {

                JsonArray array=new JsonArray();
                for (Schedule schedule1 : scheduleDao.getScheduleBySid(Integer.parseInt(request.getParameter("scheduleId")))) {
                    JsonObject item=new JsonObject();

                    item.addProperty("b_No",schedule1.getBusNo());
                    item.addProperty("r_No",schedule1.getRouteNo());
                    item.addProperty("con_u_ID",schedule1.getConId());
                    item.addProperty("s_date",schedule1.getsDate());
                    item.addProperty("s_time",schedule1.getsTime());
                    item.addProperty("add_uid",schedule1.getAdd_uid());

                    array.add(item);
                }

                log.info("Array:"+array.toString());
                out.println(array.toString());
            }else if(status.equalsIgnoreCase("updateQ")){
                System.out.println("cccccc");
                schedule.setBusNo(request.getParameter("b_No"));
                schedule.setRouteNo(request.getParameter("r_No"));
                schedule.setConId(Integer.parseInt(request.getParameter("con_u_ID")));
                schedule.setsDate(request.getParameter("s_date"));
                schedule.setsTime(request.getParameter("s_time"));
                schedule.setAdd_uid(Integer.parseInt(session.getAttribute("uid").toString()));



                ScheduleDao sdao= new ScheduleDaoImpl();
                sdao.update(schedule);
            }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
