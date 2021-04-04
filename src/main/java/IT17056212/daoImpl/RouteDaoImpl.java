package IT17056212.daoImpl;

import DBconnect.ConnectionMySql;
import IT17056212.dao.RouteDao;
import IT17056212.model.Route;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RouteDaoImpl implements RouteDao {
    public static Logger log =Logger.getLogger(RouteDaoImpl.class.getName());

    @Override
    public boolean add(Route route) {
        /*
         *
         * Add a route to database
         *
         * */
        try {    /*calling the mysql connection class*/

            ConnectionMySql conn = ConnectionMySql.getCon();

            /*get all the details through getters */
            String routeNo = route.getR_no();
            String price = route.getPrice();
            String rStart = route.getPointA();
            String rEnd = route.getPointB();
            String busStops = route.getBusStops();
            busStops=rStart+","+busStops+","+rEnd;

            String uid="1";

            if(routeNo!=null) {

                String query = "insert into route(r_No,point_A,point_B,bus_Stop,price_per_point,add_uid) values ('" + routeNo + "','" + rStart + "','" + rEnd + "','" + busStops + "','" + price + "','" + uid + "')";
                int i= conn.insertAndUpdate(query);

            }

            return true;


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());
            return false;
        }
    }
    /*
     *
     * Update an specfic route
     *
     * */
    @Override
    public boolean update(Route route) {
        try {    /*calling the mysql connection class*/

            ConnectionMySql conn = ConnectionMySql.getCon();
            int routeID=route.getrId();
            /*get all the details through getters */
            String routeNo = route.getR_no();
            String price = route.getPrice();
            String rStart = route.getPointA();
            String rEnd = route.getPointB();
            String busStops = route.getBusStops();

            String uid="1";

            String query = "UPDATE route SET r_No='"+routeNo+"',point_A='"+rStart+"',point_B='"+rEnd+"',bus_Stop='"+busStops+"',price_per_point='"+price+"',add_uid='"+uid+"'  WHERE r_ID='"+routeID+"'";
            int i= conn.insertAndUpdate(query);

            return true;

        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());
            return false;
        }
    }
    /*
     *
     * delete an specific route
     *
     * */
    @Override
    public boolean delete(Route route) {
        try {	/*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();

            int rId=route.getrId();



            String query = "Delete FROM route Where r_ID='"+rId+"'";
            int i= conn.insertAndUpdate(query);

            return true;


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());
            return false;
        }
    }
    /*
     *
     * Get all the route details
     *
     * */
    @Override
    public List<Route> getRouteList() {

        List<Route> listRoute = new ArrayList<>();

        try {
            ConnectionMySql conn = ConnectionMySql.getCon();

            String query3 = "select r_ID,r_No,point_A,point_B,bus_stop,price_per_point,add_uid from route";
            ResultSet result= conn.selectQuery(query3);


            while (result.next()) {
                int rid = result.getInt("r_ID");
                String rno = result.getString("r_no");
                String point_A = result.getString("point_A");
                String point_B = result.getString("point_B");
                String bus_stop = result.getString("bus_stop");
                String price_per_point = result.getString("price_per_point");
                int add_uid = result.getInt("add_uid");

                Route route = new Route();

                route.setrId(rid);
                route.setR_no(rno);
                route.setPointA(point_A);
                route.setPointB(point_B);
                route.setPrice(price_per_point);
                route.setBusStops(bus_stop);
                route.setAdd_uid(add_uid);



                listRoute.add(route);
            }


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());

        }
        return listRoute;
    }
    /*
     *
     * Get all the route details by sending route no
     *
     * */
    @Override
    public List<Route> getRouteByRno(String routeNo) {
        List<Route> listRoute = new ArrayList<>();

        try {
            ConnectionMySql conn = ConnectionMySql.getCon();
            String rNo=routeNo;
            String query = "select r_ID,r_No,point_A,point_B,bus_stop,price_per_point,add_uid from route where r_No='"+rNo+"'";
            ResultSet r = conn.selectQuery(query);


            while (r.next()) {
                int rid = r.getInt("r_ID");
                String rno = r.getString("r_no");
                String point_A = r.getString("point_A");
                String point_B = r.getString("point_B");
                String bus_stop = r.getString("bus_stop");
                String price_per_point = r.getString("price_per_point");
                int add_uid = r.getInt("add_uid");

                Route route = new Route();

                route.setrId(rid);
                route.setR_no(rno);
                route.setPointA(point_A);
                route.setPointB(point_B);
                route.setPrice(price_per_point);
                route.setBusStops(bus_stop);
                route.setAdd_uid(add_uid);



                listRoute.add(route);
            }


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());

        }
        return listRoute;
    }
    /*
     *
     * Get all the route details by sending route id
     *
     * */
    @Override
    public List<Route> getRouteById(int rId) {
        List<Route> listRoute = new ArrayList<>();

        try {
            ConnectionMySql conn = ConnectionMySql.getCon();

            String query = "select r_No,point_A,point_B,bus_stop,price_per_point,add_uid from route where r_ID='"+rId+"'";
            ResultSet r = conn.selectQuery(query);


            while (r.next()) {

                String rno = r.getString("r_no");
                String point_A = r.getString("point_A");
                String point_B = r.getString("point_B");
                String bus_stop = r.getString("bus_stop");
                String price_per_point = r.getString("price_per_point");
                int add_uid = r.getInt("add_uid");

                Route route = new Route();

                route.setR_no(rno);
                route.setPointA(point_A);
                route.setPointB(point_B);
                route.setPrice(price_per_point);
                route.setBusStops(bus_stop);
                route.setAdd_uid(add_uid);



                listRoute.add(route);
            }


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());

        }
        return listRoute;
    }
}
