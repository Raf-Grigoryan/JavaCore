package bank.service;

import bank.model.user.User;

public interface UserService {

    User addUser(User user);

    boolean deleteUserById(String id);


    void linkACard(String cardId);

    User getUserById(String id);

    User loginUser(String login, String password);


    User getUserByLogin(String login);

}
