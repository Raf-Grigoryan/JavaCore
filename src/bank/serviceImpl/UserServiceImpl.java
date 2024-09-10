package bank.serviceImpl;

import bank.model.user.User;
import bank.service.UserService;
import bank.util.PasswordService;


import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class UserServiceImpl implements UserService {
    private final List<User> users = new ArrayList<>();
    private final AtomicInteger idNumber = new AtomicInteger(100); // Потокобезопасный счётчик

    @Override
    public User addUser(User user) {
        user.setId("A" + idNumber.getAndIncrement());
        String password = PasswordService.encode(user.getPassword());
        user.setPassword(password);
        users.add(user);
        return user;
    }

    @Override
    public boolean deleteUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return true;
            }

        }
        return false;
    }

    @Override
    public void linkACard(String cardId) {

    }

    @Override
    public User getUserById(String id) {
        for (User user : users) {
            if (user.getId().equals(id)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User loginUser(String login, String password) {
        for (User user : users) {
            if (user.getLogin().equals(login) && PasswordService.login(password, user.getPassword())) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByLogin(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User getUserByUsername(String login) {
        for (User user : users) {
            if (user.getLogin().equals(login)) {
                return user;
            }
        }
        return null;
    }
}
