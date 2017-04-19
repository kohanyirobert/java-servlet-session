package service;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {

    private static final List<User> USERS = new ArrayList<>();

    static {
        USERS.add(new User("admin@admin", "admin"));
        USERS.add(new User("user@user", "user"));
    }

    public static boolean hasUser(User user) {
        return USERS.contains(user);
    }
}
