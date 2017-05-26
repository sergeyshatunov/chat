package by.shatunov.groupchat;

import by.shatunov.groupchat.model.Message;
import by.shatunov.groupchat.model.User;

import java.util.ArrayList;

public class MessagesData {

    private static ArrayList<Message> messages = new ArrayList<>();

    public static void addMessage(User user, String message) {
        messages.add(new Message(user, message));
    }

    public static ArrayList<Message> getMessages() {
        return messages;
    }
}
