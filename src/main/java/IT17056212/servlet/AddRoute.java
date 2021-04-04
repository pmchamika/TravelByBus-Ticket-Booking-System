package IT17056212.servlet;

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

@WebServlet(name = "AddRoute")
public class AddRoute extends HttpServlet {
    public static Logger log =Logger.getLogger(AddRoute.class.getName());

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();


        Route route = new Route();
        /*set all the  details to setters */

        route.setR_no(request.getParameter("routeNo"));
        route.setPrice(request.getParameter("price"));
        route.setPointA(request.getParameter("rStart"));
        route.setPointB(request.getParameter("rEnd"));
        route.setBusStops(request.getParameter("bStops"));
        route.setAdd_uid(Integer.parseInt(session.getAttribute("uid").toString()));


        log.info("Route: "+route.getR_no());

        RouteDao rdao= new RouteDaoImpl();
        rdao.add(route);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
