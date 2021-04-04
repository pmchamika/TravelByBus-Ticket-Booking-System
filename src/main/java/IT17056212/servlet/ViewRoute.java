package IT17056212.servlet;

import DBconnect.ConnectionMySql;
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

@WebServlet(name = "ViewRoute")
public class ViewRoute extends HttpServlet {
    public static Logger log =Logger.getLogger(ViewRoute.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        RouteDao routeDao = new RouteDaoImpl();

        PrintWriter out = response.getWriter();
        Route route=new Route();
        String status="noConditionSelect";
        if(request.getParameter("rNo")!=null) {
            status=request.getParameter("query");
            route.setR_no(request.getParameter("rNo"));
        }


        try {    /*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();

            if(status.equalsIgnoreCase("conSelect")) {


                JsonArray array = new JsonArray();
                for (Route route1 : routeDao.getRouteByRno(request.getParameter("rNo"))) {
                    JsonObject item = new JsonObject();
                    item.addProperty("r_ID", route1.getrId());
                    item.addProperty("r_No", route1.getR_no());
                    item.addProperty("point_A", route1.getPointA());
                    item.addProperty("point_B", route1.getPointB());
                    item.addProperty("bus_Stop", route1.getBusStops());
                    item.addProperty("price_per_point", route1.getPrice());
                    item.addProperty("add_uid", route1.getAdd_uid());

                    array.add(item);
                }

//            gson.add("datas",array);
                System.out.println("Array:" + array.toString());
                out.println(array.toString());
            }else if(status.equalsIgnoreCase("noConditionSelect")){


                JsonArray array = new JsonArray();
                for (Route route1 : routeDao.getRouteList()) {
                    JsonObject item = new JsonObject();
                    item.addProperty("r_ID", route1.getrId());
                    item.addProperty("r_No", route1.getR_no());
                    item.addProperty("point_A", route1.getPointA());
                    item.addProperty("point_B", route1.getPointB());
                    item.addProperty("bus_Stop", route1.getBusStops());
                    item.addProperty("price_per_point", route1.getPrice());
                    item.addProperty("add_uid", route1.getAdd_uid());

                    array.add(item);
                }

//            gson.add("datas",array);
                log.info("Array:"+array.toString());
                out.println(array.toString());
            }

        } catch (Exception e) {
            System.err.println(e);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
