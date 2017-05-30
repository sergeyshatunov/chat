package by.shatunov.groupchat;

import by.shatunov.groupchat.model.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;
import java.util.UUID;

@WebServlet(name = "ChatServlet", urlPatterns = {"/chat"})
public class ChatServlet extends HttpServlet {

    String target;
    String entity;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String message = request.getParameter("message");
        User user = UsersData.findUser(request.getSession().getId());
        target = request.getParameter("target");
        entity = request.getParameter("entity");
        if (user == null) {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        if (message != null && !Objects.equals(message, "")) {
            if (Objects.equals(request.getParameter("entity"), "channel")) {
                MessagesData.addMessage(user, ChannelsData.findChannel(UUID.fromString(target)), message);
            } else {
                MessagesData.addMessage(user, UsersData.findUser(UUID.fromString(target)), message);
            }
        }
        getServletContext().setAttribute("currentUserID", user.getId());
        response.sendRedirect(getServletContext().getContextPath() + "/chat");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (target == null) {
            target = Setup.DEFAULT_CHANNEL_ID.toString();
        }
        if (entity == null) {
            entity = "channel";
        }
        getServletContext().setAttribute("target", target);
        getServletContext().setAttribute("entity", entity);
        getServletContext().setAttribute("messages", MessagesData.getMessages());
        getServletContext().setAttribute("users", UsersData.getUsers());
        request.getRequestDispatcher("chat.jsp").forward(request, response);
    }
}
