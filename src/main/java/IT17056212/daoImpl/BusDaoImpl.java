package IT17056212.daoImpl;

import DBconnect.ConnectionMySql;
import IT17056212.dao.BusDao;
import IT17056212.model.Bus;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BusDaoImpl implements BusDao {
    public static Logger log =Logger.getLogger(BusDaoImpl.class.getName());
    /*
     *
     * Add a bus to the database
     *
     * */
    @Override
    public boolean add(Bus bus) {
        try {    /*calling the mysql connection class*/

            ConnectionMySql conn = ConnectionMySql.getCon();

            /*get all the details through getters */
            String busNo = bus.getBusNo();
            String model = bus.getModel();
            String noSeats = bus.getNoSeats();
            int uid=bus.getAdd_uid();


            if(busNo!=null) {

                String query2 = "insert into bus(b_No,b_model,No_BSeats,add_uid) values ('" + busNo + "','" + model + "','" + noSeats + "','" + uid + "')";
                int i= conn.insertAndUpdate(query2);

            }
            return true;

        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());
            return false;
        }

    }
    /*
     *
     * Update an specific bus
     *
     * */
    @Override
    public boolean update(Bus bus) {
        try {    /*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();

        int busID=bus.getbId();
        String busNo = bus.getBusNo();
        String model = bus.getModel();
        String noSeats = bus.getNoSeats();
        String uid="1";

        String query = "UPDATE bus SET b_no='"+busNo+"',b_model='"+model+"',No_Bseats='"+noSeats+"',add_uid='"+uid+"'  WHERE b_ID='"+busID+"' ";
        int i= conn.insertAndUpdate(query);


        return true;

    } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());
        return false;
    }
    }
    /*
     *
     * Delete an specifc bus
     *
     * */
    @Override
    public boolean delete(Bus bus) {
        try {	/*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();
            int bId=bus.getbId();


            String query = "Delete FROM bus Where b_ID='"+bId+"'";
            int i= conn.insertAndUpdate(query);


            return true;

        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());
            return false;
        }
    }
    /*
     *
     * Get all the bus details
     *
     * */
    @Override
    public List<Bus> getBusList() {


        List<Bus> listBus = new ArrayList<>();

        try {
                ConnectionMySql conn = ConnectionMySql.getCon();

                String query3 = "select b_ID,b_no,b_Model,No_BSeats,add_uid from bus ";
                ResultSet result= conn.selectQuery(query3);


            while (result.next()) {
                int bid = result.getInt("b_ID");
                String bno = result.getString("b_no");
                String modal = result.getString("b_Model");
                String bseats = result.getString("No_BSeats");
                int add_uid = result.getInt("add_uid");
                Bus bus = new Bus();

                bus.setbId(bid);
                bus.setBusNo(bno);
                bus.setModel(modal);
                bus.setNoSeats(bseats);
                bus.setAdd_uid(add_uid);

                listBus.add(bus);
            }


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());

        }
        return listBus;
    }
/*
*
* Get all the bus details by sending bus id
*
* */
    @Override
    public List<Bus> getBusById(int bId) {


        List<Bus> listBus = new ArrayList<>();

        try {
            ConnectionMySql conn = ConnectionMySql.getCon();

            String query3 = "select b_No,b_Model,No_BSeats,add_uid from bus where b_ID='" + bId + "' ";
            ResultSet r = conn.selectQuery(query3);


            while (r.next()) {

                String bno = r.getString("b_No");
                String modal = r.getString("b_Model");
                String bseats = r.getString("No_BSeats");
                int add_uid = r.getInt("add_uid");
                Bus bus = new Bus();


                bus.setBusNo(bno);
                bus.setModel(modal);
                bus.setNoSeats(bseats);
                bus.setAdd_uid(add_uid);

                listBus.add(bus);
            }


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());

        }
        return listBus;
    }


}
