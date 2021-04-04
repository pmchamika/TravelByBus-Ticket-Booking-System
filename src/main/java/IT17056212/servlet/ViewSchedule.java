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

@WebServlet(name = "ViewSchedule")
public class ViewSchedule extends HttpServlet {
    public static Logger log =Logger.getLogger(ViewSchedule.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        ScheduleDao scheduleDao = new ScheduleDaoImpl();

        JsonArray array=new JsonArray();
        for (Schedule schedule : scheduleDao.getScheduleList()) {
                JsonObject item=new JsonObject();
                item.addProperty("s_ID",schedule.getsId());
                item.addProperty("b_No",schedule.getBusNo());
                item.addProperty("r_No",schedule.getRouteNo());
                item.addProperty("con_u_ID",schedule.getConId());
                item.addProperty("s_date",schedule.getsDate());
                item.addProperty("s_time",schedule.getsTime());
                item.addProperty("add_uid",schedule.getAdd_uid());

                array.add(item);
            }

//            gson.add("datas",array);
        log.info("Array:"+array.toString());
            out.println(array.toString() );


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
