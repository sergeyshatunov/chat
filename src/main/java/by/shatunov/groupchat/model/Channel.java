package by.shatunov.groupchat.model;

public class Channel extends Entity{

    public Channel(String name, String channelID) {
        super.name = name;
        super.id = channelID;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return super.getId();
    }
}
