package IT17056212.servlet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
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

@WebServlet(name = "ViewBus")
public class ViewBus extends HttpServlet {
    public static Logger log =Logger.getLogger(ViewBus.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        BusDao busDao = new BusDaoImpl();

        JsonArray array=new JsonArray();
        for (Bus bus : busDao.getBusList()) {

            JsonObject item=new JsonObject();
            item.addProperty("b_ID",bus.getbId());
            item.addProperty("b_no",bus.getBusNo());
            item.addProperty("b_Model",bus.getModel());
            item.addProperty("No_BSeats",bus.getNoSeats());
            item.addProperty("add_uid",bus.getAdd_uid());

            array.add(item);
        }
       ;
        log.info("Array:"+array.toString());
        out.println(array.toString() );

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
