package by.shatunov.groupchat;

import by.shatunov.groupchat.model.User;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.UUID;

@WebListener
public class Setup implements ServletContextListener{
    final static UUID DEFAULT_CHANNEL_ID = UUID.randomUUID();

    @Override
    public void contextInitialized(ServletContextEvent event) {

        ChannelsData.addChannel("General", DEFAULT_CHANNEL_ID.toString());
        ChannelsData.addChannel("General2", UUID.randomUUID().toString());
        MessagesData.addMessage(new User("Doorkeeper", "0", UUID.randomUUID().toString()), ChannelsData.findChannel(DEFAULT_CHANNEL_ID), "Welcome to chat");
        event.getServletContext().setAttribute("channels", ChannelsData.getChannels());
        event.getServletContext().setAttribute("messages", MessagesData.getMessages());
    }
}
