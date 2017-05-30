package by.shatunov.groupchat.model;

public class Message {

    private User from;
    private Entity target;
    private String text;

    public Message(User from, Entity target, String text) {
        this.from = from;
        this.target = target;
        this.text = text;
    }

    public User getFrom() {
        return from;
    }

    public Entity getTarget() {
        return target;
    }

    public String getText() {
        return text;
    }
}
