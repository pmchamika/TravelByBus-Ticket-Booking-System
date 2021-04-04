package IT17056212.daoImpl;

import DBconnect.ConnectionMySql;
import IT17056212.dao.ScheduleDao;
import IT17056212.model.Schedule;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ScheduleDaoImpl implements ScheduleDao {
    public static Logger log =Logger.getLogger(ScheduleDaoImpl.class.getName());
    /*
     *
     * add schedule to the database
     *
     * */
    @Override
    public boolean add(Schedule schedule) {
        try {    /*calling the mysql connection class*/

            ConnectionMySql conn = ConnectionMySql.getCon();

            /*get all the details through getters */
            String busNo = schedule.getBusNo();
            String routeNo = schedule.getRouteNo();
            int conId = schedule.getConId();
            String sDate = schedule.getsDate();
            String sTime = schedule.getsTime();
            String uid="1";
            String datas="";

            if(busNo!=null) {

                String query2 = "insert into schedule(b_No,r_No,con_u_ID,s_date,s_time,add_uid) values ('" + busNo + "','" + routeNo + "','" + conId + "','" + sDate + "','" + sTime + "','" + uid + "')";
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
     * update all schedule the details
     *
     * */
    @Override
    public boolean update(Schedule schedule) {
        try {    /*calling the mysql connection class*/

            ConnectionMySql conn = ConnectionMySql.getCon();
            int scheduleId=schedule.getsId();
            /*get all the details through getters */
            String routeNo = schedule.getRouteNo();
            String busNo = schedule.getBusNo();
            int conId = schedule.getConId();
            String sDate = schedule.getsDate();
            String sTime = schedule.getsTime();


            String uid="1";

            String query = "UPDATE schedule SET b_No='"+busNo+"',r_No='"+routeNo+"',con_u_ID='"+conId+"',s_date='"+sDate+"',s_time='"+sTime+"',add_uid='"+uid+"'  WHERE s_ID='"+scheduleId+"'";
            int i= conn.insertAndUpdate(query);

            return true;

        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());
            return false;
        }
    }
    /*
     *
     *delete an specific schedule
     *
     * */
    @Override
    public boolean delete(Schedule schedule) {
        try {	/*calling the mysql connection class*/
            ConnectionMySql conn = ConnectionMySql.getCon();

            int sId=schedule.getsId();


            String query = "Delete FROM schedule Where s_ID='"+sId+"'";
            int i= conn.insertAndUpdate(query);

            return true;


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());
            return false;
        }
    }
    /*
     *
     * Get all the schedule details
     *
     * */
    @Override
    public List<Schedule> getScheduleList() {
        List<Schedule> listSchedule = new ArrayList<>();

        try {
            ConnectionMySql conn = ConnectionMySql.getCon();


            String query = "select s_ID,b_No,r_No,con_u_ID,s_date,s_time,add_uid from schedule";
            ResultSet r= conn.selectQuery(query);


            while (r.next()) {
                int sid = r.getInt("s_ID");
                String b_No = r.getString("b_No");
                String r_No = r.getString("r_No");
                int con_u_ID = r.getInt("con_u_ID");
                String s_date = r.getString("s_date");
                String s_time = r.getString("s_time");
                int add_uid = r.getInt("add_uid");

                Schedule schedule = new Schedule();

                schedule.setsId(sid);
                schedule.setBusNo(b_No);
                schedule.setRouteNo(r_No);
                schedule.setConId(con_u_ID);
                schedule.setsDate(s_date);
                schedule.setsTime(s_time);
                schedule.setAdd_uid(add_uid);



                listSchedule.add(schedule);
            }


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());

        }
        return listSchedule;
    }
    /*
     *
     * Get all the schedule details by sending current date
     *
     * */
    @Override
    public List<Schedule> getScheduleByCurrentDateList(String currentDate) {
        List<Schedule> listSchedule = new ArrayList<>();

        try {
            ConnectionMySql conn = ConnectionMySql.getCon();


            String query = "select s_ID,b_No,r_No,con_u_ID,s_date,s_time,add_uid from schedule where s_date='"+currentDate+"'";
            ResultSet r= conn.selectQuery(query);


            while (r.next()) {
                int sid = r.getInt("s_ID");
                String b_No = r.getString("b_No");
                String r_No = r.getString("r_No");
                int con_u_ID = r.getInt("con_u_ID");
                String s_date = r.getString("s_date");
                String s_time = r.getString("s_time");
                int add_uid = r.getInt("add_uid");

                Schedule schedule = new Schedule();

                schedule.setsId(sid);
                schedule.setBusNo(b_No);
                schedule.setRouteNo(r_No);
                schedule.setConId(con_u_ID);
                schedule.setsDate(s_date);
                schedule.setsTime(s_time);
                schedule.setAdd_uid(add_uid);



                listSchedule.add(schedule);
            }


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());

        }
        return listSchedule;
    }
    /*
     *
     * Get all the schedule details by sending schedule id
     *
     * */
    @Override
    public List<Schedule> getScheduleBySid(int sId) {
        List<Schedule> listSchedule = new ArrayList<>();

        try {
            ConnectionMySql conn = ConnectionMySql.getCon();

            String query3 = "select b_No,r_No,con_u_ID,s_date,s_time,add_uid  from schedule where s_ID='" + sId + "' ";
            ResultSet r = conn.selectQuery(query3);

            while (r.next()) {

                String b_No = r.getString("b_No");
                String r_No = r.getString("r_No");
                int con_u_ID = r.getInt("con_u_ID");
                String s_date = r.getString("s_date");
                String s_time = r.getString("s_time");
                int add_uid = r.getInt("add_uid");

                Schedule schedule = new Schedule();

                schedule.setBusNo(b_No);
                schedule.setRouteNo(r_No);
                schedule.setConId(con_u_ID);
                schedule.setsDate(s_date);
                schedule.setsTime(s_time);
                schedule.setAdd_uid(add_uid);

                listSchedule.add(schedule);
            }


        } catch (Exception e) {
            log.log(Level.SEVERE,e.getMessage());

        }
        return listSchedule;
    }
}
