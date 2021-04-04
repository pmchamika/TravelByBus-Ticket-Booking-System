package IT17056212.servlet;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import IT17056212.dao.RouteDao;
import IT17056212.daoImpl.RouteDaoImpl;
import IT17056212.model.Route;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;

@WebServlet(name = "UpdateRoute")
public class UpdateRoute extends HttpServlet {
    public static Logger log =Logger.getLogger(UpdateRoute.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();
        Route route = new Route();
        RouteDao routeDao = new RouteDaoImpl();
        /*set all the  details to setters */

        route.setrId(Integer.parseInt(request.getParameter("routeId")));

        String status=request.getParameter("query");


            if(status.equalsIgnoreCase("selectQ")) {

                JsonArray array = new JsonArray();
                for (Route route1 : routeDao.getRouteById(Integer.parseInt(request.getParameter("routeId")))) {
                    JsonObject item = new JsonObject();

                    item.addProperty("r_No", route1.getR_no());
                    item.addProperty("point_A", route1.getPointA());
                    item.addProperty("point_B", route1.getPointB());
                    item.addProperty("bus_Stop", route1.getBusStops());
                    item.addProperty("price_per_point", route1.getPrice());
                    item.addProperty("add_uid", route1.getAdd_uid());

                    array.add(item);
                }

                log.info("Array:"+array.toString());
                out.println(array.toString());
            }else if(status.equalsIgnoreCase("updateQ")){

                route.setR_no(request.getParameter("routeNo"));
                route.setPointA(request.getParameter("rStart"));
                route.setPointB(request.getParameter("rEnd"));
                route.setBusStops(request.getParameter("bStops"));
                route.setPrice(request.getParameter("price"));
                route.setAdd_uid(Integer.parseInt(session.getAttribute("uid").toString()));

                RouteDao rdao= new RouteDaoImpl();
                rdao.update(route);
            }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
