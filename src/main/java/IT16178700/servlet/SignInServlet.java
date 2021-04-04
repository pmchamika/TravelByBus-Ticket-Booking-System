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
 * Servlet implementation class SignInServlet
 */

@WebServlet("/SignInServlet")
public class SignInServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;


    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServlet() {
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

            HttpSession session = request.getSession();

            String username = request.getParameter("username");
            String password = request.getParameter("signPassword");

            User user = new User();
            user.setUsername(username);
            user.setPassword(password);

            UserDAO userDao = new UserDAOImpl();
            boolean value = userDao.get(user);
            if (value) {

                String type = user.getUserType();
                String uid = user.getUsername();
                if(type.equals(null)) {
                    response.sendRedirect("SignIn.jsp");
                }else{
                    session.setAttribute("uid", uid);
                    session.setAttribute("type", type);
                    response.sendRedirect("Home.jsp");
                }
            } else {
                response.sendRedirect("SignIn.jsp");
            }
        }
    }
}
