package IT17056212.dao;

import IT17056212.model.Route;

import java.util.List;

public interface RouteDao {

    boolean add(Route route);
    boolean update(Route route);
    boolean delete(Route route);
    List<Route> getRouteList();
    List<Route> getRouteByRno(String routeNo);
    List<Route> getRouteById(int rId);
}
