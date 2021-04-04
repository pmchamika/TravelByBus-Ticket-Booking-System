package IT16178700.servlet;

import IT16178700.dao.UserDAO;
import IT16178700.daoImple.UserDAOImpl;
import IT16178700.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author kaushirajapakshe
 */

/**
 * Servlet implementation class RegisterServlet
 */

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub

        try (PrintWriter out = response.getWriter()) {


            String fname = request.getParameter("fname");
            String lname = request.getParameter("lname");
            String userType = request.getParameter("userType");
            String username = request.getParameter("username");
            String password = request.getParameter("password");

            User user = new User();
            user.setFname(fname);
            user.setLname(lname);
            user.setUserType(userType);
            user.setUsername(username);
            user.setPassword(password);
            user.setAddDate(getDate());

            UserDAO userDao = new UserDAOImpl();
            userDao.add(user);
            response.sendRedirect("SignIn.jsp");

        } catch (Exception ex) {
            System.out.println("Error : " + ex);
        }
    }

    public String getDate() {
        Date date= new Date();

        long time = date.getTime();
        Timestamp ts = new Timestamp(time);
        String d = new SimpleDateFormat("YYYY-MM-dd hh:mm:ss").format(ts);
        return d;
    }
}


