package wtf.darius.muse.service;

import org.springframework.stereotype.Service;
import wtf.darius.muse.model.User;
import wtf.darius.muse.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImplementation implements UserService {

    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void saveUser(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public List<User> getAllUsers() {
        try {
            return userRepository.findAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public User getUserById(int id) {
        //return user or null if not found
        try {
            return userRepository.findById(id).orElse(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


    @Override
    public void deleteUser(int id) {
        try {
            User userToBeDeleted = userRepository.getReferenceById(id);
            userRepository.delete(userToBeDeleted);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
    @Override
    public void updateUser(int id) {
        try {
            if (userRepository.existsById(id)){
                User userToBeUpdated = userRepository.getReferenceById(id);
                userRepository.save(userToBeUpdated);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}

