package wtf.darius.muse.service;

import wtf.darius.muse.model.User;

import java.util.List;

public interface UserService {

    void saveUser(User user);
    List<User> getAllUsers();
    User getUserById(int id);

    void deleteUser(int id);
    void updateUser(int id);
}
