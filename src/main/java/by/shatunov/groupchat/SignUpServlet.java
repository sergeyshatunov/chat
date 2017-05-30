package by.shatunov.groupchat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.UUID;

@WebServlet(name = "SignUpServlet", urlPatterns = {"/signup"})
public class SignUpServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String name = request.getParameter("name");
        String sessionID = session.getId();
        UUID userID = UUID.randomUUID();

        if (name.isEmpty()) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        } else {
            if (UsersData.findUser(userID) == null) {
                UsersData.addUser(name, sessionID, userID.toString());
            }
            response.sendRedirect(getServletContext().getContextPath() + "/chat");
        }
    }
}
