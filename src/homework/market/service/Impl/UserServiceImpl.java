package homework.market.service.Impl;


import homework.market.model.user.User;
import homework.market.model.user.UserType;
import homework.market.service.UserService;


public class UserServiceImpl implements UserService {
    private User[] users = new User[10];
    private int size = -1;


    @Override
    public User addUser(User user) {
        if (size == users.length) {
            extend();
        }
        return users[++size] = user;
    }

    private void extend() {
        User[] tmp = new User[users.length + 10];
        System.arraycopy(users, 0, tmp, 0, size);
        users = tmp;
    }

    @Override
    public User loginUser(String login, String password) {
        for (int i = 0; i <= size; i++) {
            if (users[i].getEmail().equals(login) && users[i].getPassword().equals(password)) {
                return users[i];
            }
        }
        return null;
    }

    @Override
    public boolean getUserByLogin(String email) {

        for (int i = 0; i <= size; i++) {
            if (users[i].getEmail().equals(email)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void printUsers() {
        for (int i = 0; i <= size; i++) {
            if (users[i].getUserType() == UserType.USER) {
                System.out.println(users[i]);
            }
        }
    }

}
