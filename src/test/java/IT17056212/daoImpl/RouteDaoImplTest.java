package IT17056212.daoImpl;

import IT17056212.dao.RouteDao;
import IT17056212.model.Route;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RouteDaoImplTest {

    @Test
    void getRouteByRno() {
        RouteDao routeDao = new RouteDaoImpl();
        for (Route route : routeDao.getRouteByRno("145")) {

            assertEquals("asd,asdas,asdsd,erwr,fgrthf", route.getBusStops());
            assertEquals("Kaduwela", route.getPointA());
            assertEquals("Kollupitya", route.getPointB());
            assertEquals("30", route.getPrice());
        }
    }
    @Test
    void getRouteByRno2() {
        RouteDao routeDao = new RouteDaoImpl();
        for (Route route : routeDao.getRouteByRno("145")) {

            assertEquals("asd,asdas,asdsd,erwr,fgrthf", route.getBusStops());
            assertEquals("Kaduwela", route.getPointA());
            assertEquals("Kollupitya", route.getPointB());
            assertEquals("30", route.getPrice());
        }
    }
    @Test
    void getRouteByRno3() {
        RouteDao routeDao = new RouteDaoImpl();
        for (Route route : routeDao.getRouteByRno("145")) {

            assertEquals("yuyu,fgfg,fgfgfg,fgfgfg,fgfgfgg", route.getBusStops());
            assertEquals("Colombo", route.getPointA());
            assertEquals("Moratuwa", route.getPointB());
            assertEquals("99", route.getPrice());
        }
    }

    @Test
    void add() {
        Route route = new Route();

        route.setR_no("IK1478");
        route.setPrice("5");
        route.setBusStops("jhkj,sdfsd");
        route.setPointA("sdf");
        route.setPointA("nbvnb");
        route.setPrice("77");
        RouteDao rdao= new RouteDaoImpl();

        assertEquals(true, rdao.add(route));
    }

    @Test
    void delete() {
        Route route = new Route();

        route.setrId(5);
        RouteDao rdao= new RouteDaoImpl();
        rdao.delete(route);
        assertEquals(true, rdao.delete(route));
    }
}