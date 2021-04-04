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

@WebServlet(name = "DeleteRoute")
public class DeleteRoute extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        PrintWriter out = response.getWriter();


        Route route = new Route();
        /*set all the  details to setters */

        route.setrId(Integer.parseInt(request.getParameter("routeId")));

        RouteDao rdao= new RouteDaoImpl();
        rdao.delete(route);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
