package by.shatunov.groupchat;

import by.shatunov.groupchat.model.Channel;

import java.util.ArrayList;
import java.util.UUID;

public class ChannelsData {

    private static ArrayList<Channel> channels = new ArrayList<>();

    public static void addChannel(String name, String id) {
        channels.add(new Channel(name, id));
    }

    public static Channel findChannel(UUID uuid) {
        for (Channel channel:channels) {
            if (channel.getId().equals(uuid.toString())) {
                return channel;
            }
        }
        return null;
    }

    public static ArrayList<Channel> getChannels() {
        return channels;
    }
}
