package by.shatunov.groupchat.model;

public class User extends Entity {

    private String sessionID;

    public User(String name, String sessionID, String userID) {
        super.name = name;
        super.id = userID;
        this.sessionID = sessionID;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return super.getId();
    }

    public String getSessionID() {
        return sessionID;
    }
}
