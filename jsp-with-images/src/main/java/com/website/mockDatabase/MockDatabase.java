package com.website.mockDatabase;

import com.website.entities.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class MockDatabase {
    private final ArrayList<User> allUsers = new ArrayList<User>();

    // constructor starts with test data
    public MockDatabase() {
        addUserToMockDatabase(new User("daniel", "dan0196@pm.me", 1231231234L, "/images/daniel.jpg"));
        addUserToMockDatabase(new User("lexy", "lexy@email.com", 1541231234L, "/images/lexy.jpg"));
    }

    public void addUserToMockDatabase(User user) {
        user.setId(allUsers.size() + 1);
        System.out.println(user.getId());
        allUsers.add(user);
    }

    public User findUserById(int idToSearch) {
        for (User loopedUser : allUsers) {
            if (loopedUser.getId() == idToSearch) {
                return loopedUser;
            }
        }

        return null;
    }

    public ArrayList<User> findAllUsers() {
        return allUsers;
    }
}
