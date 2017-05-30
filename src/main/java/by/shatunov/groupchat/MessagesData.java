package by.shatunov.groupchat;

import by.shatunov.groupchat.model.Channel;
import by.shatunov.groupchat.model.Message;
import by.shatunov.groupchat.model.User;

import java.util.ArrayList;

public class MessagesData {

    private static ArrayList<Message> messages = new ArrayList<>();

    public static void addMessage(User user, User targetUser, String message) {
        messages.add(new Message(user, targetUser, message));
    }

    public static void addMessage(User user, Channel channel, String message) {
        messages.add(new Message(user, channel, message));
    }

    public static ArrayList<Message> getMessages() {
        return messages;
    }
}
