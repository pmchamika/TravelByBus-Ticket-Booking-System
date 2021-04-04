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

@WebServlet(name = "UpdateBus")
public class UpdateBus extends HttpServlet {
    public static Logger log =Logger.getLogger(UpdateBus.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        Bus bus = new Bus();
        /*set all the  details to setters */

         bus.setbId(Integer.parseInt(request.getParameter("busId")));
         String status=request.getParameter("query");

            if(status.equalsIgnoreCase("selectQ")) {
                BusDao busDao = new BusDaoImpl();

                JsonArray array=new JsonArray();
                for (Bus bus1 : busDao.getBusById(Integer.parseInt(request.getParameter("busId")))) {

                    JsonObject item=new JsonObject();

                    item.addProperty("b_no",bus1.getBusNo());
                    item.addProperty("b_Model",bus1.getModel());
                    item.addProperty("No_BSeats",bus1.getNoSeats());
                    item.addProperty("add_uid",bus1.getAdd_uid());

                    array.add(item);
                }

                log.info("Array:"+array.toString());
                out.println(array.toString());
            }else if(status.equalsIgnoreCase("updateQ")){

                bus.setBusNo(request.getParameter("busNo"));
                bus.setModel(request.getParameter("model"));
                bus.setNoSeats(request.getParameter("No_BSeats"));
                bus.setAdd_uid(Integer.parseInt(session.getAttribute("uid").toString()));

                BusDao bdao= new BusDaoImpl();
                bdao.update(bus);

            }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
