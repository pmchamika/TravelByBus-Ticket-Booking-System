package IT16178700.daoImple;

import DBconnect.ConnectionMySql;
import IT16178700.dao.UserDAO;
import IT16178700.model.User;
import IT16178700.servlet.dbconnecter.DBConnect;

import javax.servlet.http.HttpSession;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;



public class UserDAOImpl implements UserDAO {
    private final static Logger LOGGER = Logger.getLogger(UserDAOImpl.class.getName());
//
//    @Override
//    public boolean update(Doctor doctor) {
//
//        String sql = "UPDATE doctor "
//                + "SET " + "Doctor_ID = '" + doctor.getDID()
//                + "',Name = '" + doctor.getName()
//                + " ',Status = '" + doctor.getStatus()
//                + "',Email = '" + doctor.getEmail()
//                + "', NIC_Number = '" + doctor.getNIC()
//                + "',Telephone_Number = '" + doctor.getTelephoneNumber()
//                + "', Password = '" + doctor.getPassword()
//                + "',MC_Registration_Number = '" + doctor.getMcRegistrationNumber()
//                + "',Qualification = '" + doctor.getQualification()
//                + "',Specialization = '" + doctor.getSpecialization()
//                + "',Working_experience = '" + doctor.getWorkingExperience()
//                + "'WHERE Doctor_ID = '" + doctor.getDID()+"'";
//
//        try {
//            Connection con = Connection_DB.getInstance().getConnection();
//            Statement st2 = con.createStatement();
//            st2.executeUpdate(sql);
//
//        } catch (SQLException ex) {
//            Logger.getLogger(DoctorDAOImpl.class.getName()).log(Level.SEVERE, "Error updating a record to the DB", ex);
//            return false;
//        }
//
//
//        return true;
//
//    }
//
//    @Override
//    public boolean delete(Doctor doctor) {
//
//        String sql = "DELETE FROM doctor WHERE Doctor_ID = '" + doctor.getDID()+"'";
//
//        try {
//            Connection con = Connection_DB.getInstance().getConnection();
//            Statement st = con.createStatement();
//            st.executeUpdate(sql);
//        } catch (SQLException ex) {
//            Logger.getLogger(DoctorDAOImpl.class.getName()).log(Level.SEVERE, "Error deleting a record to the DB", ex);
//            return false;
//        }
//
//        return true;
//    }


    @Override
    public List<User> getAllUserDetails() {
        ArrayList<User> list = new ArrayList<User>();

        String sql = "SELECT * FROM doctor";

        try {
            Connection con = DBConnect.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                String uid = rs.getString("u_ID");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String uname = rs.getString("uname");
                String password = rs.getString("password");
                String type = rs.getString("type");
                String add_date = rs.getString("add_date");

                User user = new User();
                user.setFname(fname);
                user.setFname(lname);
                user.setUsername(uname);
                user.setPassword(password);
                user.setUserType(type);
                user.setAddDate(add_date);
                list.add(user);


            }
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, "Error reading records from the DB", ex);
        }

        return list;
    }

    @Override
    public boolean add(User user) {

        String sql =  "INSERT INTO `user`"
                + "(`fname`, `lname`, `uname`, `password`, `type`, `add_date`) "
                + "VALUES('"+user.getFname()+"','"+user.getLname()+"','"+user.getUsername()+"','"+user.getPassword()+"','"+user.getUserType()+"','"+user.getAddDate()+"')";

        try {
            ConnectionMySql db = ConnectionMySql.getCon();

            int i = db.insertAndUpdate(sql);

        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, "Error adding a record to the DB", e);
            return false;
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public boolean get(User user){
        String uname = user.getUsername();
        String password = user.getPassword();
        String sql = "Select uname,type from user where uname=? and password=?";
        try {
            ConnectionMySql db = ConnectionMySql.getCon();
            PreparedStatement pst = db.selectResult(sql);
            pst.setString(1, user.getUsername());
            pst.setString(2, user.getPassword());

            ResultSet res = pst.executeQuery();

            while (res.next()) {
                String username = res.getString("uname");
                String type = res.getString("type");

                user.setUsername(username);
                user.setUserType(type);
                LOGGER.info("Logger Name: " + LOGGER.getName()+" logging "+ user.getUsername()+ user.getPassword());

                return  true;
            }

        } catch (SQLException e) {
            Logger.getLogger(UserDAOImpl.class.getName()).log(Level.SEVERE, "Error selecting user record on the DB", e);
            return false;
        }

        return true;
    }
}
