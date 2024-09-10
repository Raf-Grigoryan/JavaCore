package bank.service;

import bank.model.user.User;

public interface UserService {

    User addUser(User user);

    boolean deleteUserById(String id);

   // User updateUser(User user);

    void linkACard(String cardId);

    User getUserById(String id);

    User loginUser(String login, String password);

    // void changeUserType(UserType userType);
    User getUserByLogin(String login);
    User getUserByUsername(String login);
}
