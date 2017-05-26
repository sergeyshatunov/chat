package by.shatunov.groupchat.model;

public class User {

    private String nick;
    private String userID;

    public User(String nick, String userID) {
        this.nick = nick;
        this.userID = userID;
    }

    public String getNick() {
        return nick;
    }

    public String getUserID() {
        return userID;
    }
}
