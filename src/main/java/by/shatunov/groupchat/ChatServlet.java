package by.shatunov.groupchat;

import by.shatunov.groupchat.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

@WebServlet(name = "ChatServlet", urlPatterns = {"/chat"})
public class ChatServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        User user = UsersData.findUser(request.getSession().getId());
        if (user == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if (message != null && !Objects.equals(message, "")) {
            MessagesData.addMessage(user, message);
        }
        request.getRequestDispatcher("chat.jsp").forward(request, response);
    }
}
