package by.shatunov.groupchat;

import by.shatunov.groupchat.model.User;

import java.util.ArrayList;
import java.util.UUID;

public class UsersData {

    private static ArrayList<User> users = new ArrayList<>();

    public static void addUser(String name, String sessionID, String userID) {
        users.add(new User(name, sessionID, userID));
    }

    public static void removeUser(String sessionID) {
        users.remove(findUser(sessionID));
    }

    public static User findUser(String sessionID) {
        for (User user: users) {
            if (user.getSessionID().equals(sessionID)) {
                return user;
            }
        }
        return null;
    }
    public static User findUser(UUID userID) {
        for (User user: users) {
            if (user.getId().equals(userID.toString())) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
