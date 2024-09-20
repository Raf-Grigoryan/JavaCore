package homework.market.service;


import homework.market.model.user.User;

public interface UserService {

    User addUser(User user);


    User loginUser(String login, String password);


    boolean getUserByLogin(String login);

    void printUsers();

}
