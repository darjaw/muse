package wtf.darius.muse.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import wtf.darius.muse.model.User;
import wtf.darius.muse.repository.UserRepository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUser(int userId) {
        return userRepository.findById(userId).orElse(null);
    }

    public void registerUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        } else {
            userRepository.save(user);
        }
    }

    public void deleteUser(int userId) {
        boolean exists = userRepository.existsById(userId);
        if (exists) {
            userRepository.deleteById(userId);
        } else {
            throw new IllegalArgumentException("User with id " + userId + " does not exist");
        }
    }

    @Transactional
    public void updateUserBio(int userId,
                              String bio) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("User with id " + userId + " does not exist"));

        user.setBio(bio);
        System.out.println(user.getBio());
        userRepository.save(user);
    }

}
