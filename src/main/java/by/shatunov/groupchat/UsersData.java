package by.shatunov.groupchat;

import by.shatunov.groupchat.model.User;

import java.util.ArrayList;

public class UsersData {

    private static ArrayList<User> users = new ArrayList<>();

    public static void addUser(String name, String sessionID) {
        users.add(new User(name, sessionID));
    }

    public static void removeUser(String sessionID) {
        users.remove(findUser(sessionID));
    }

    public static User findUser(String sessionID) {
        for (User user: users) {
            if (user.getUserID().equals(sessionID)) {
                return user;
            }
        }
        return null;
    }

    public static ArrayList<User> getUsers() {
        return users;
    }
}
