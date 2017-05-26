package by.shatunov.groupchat.model;

public class Message {

    private User from;
    private String message;

    public Message(User from, String message) {
        this.from = from;
        this.message = message;
    }

    @Override
    public String toString() {
        return "<strong>" + from.getNick() + "</strong>:" + message;
    }
}
