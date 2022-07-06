package wtf.darius.muse.service;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.authentication.UserServiceBeanDefinitionParser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import wtf.darius.muse.model.Role;
import wtf.darius.muse.model.User;
import wtf.darius.muse.repository.UserRepository;

import java.net.URL;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserService implements UserDetailsService {

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

    public User getUserByUsername(String userName) {
        return userRepository.findUserByUserName(userName).orElse(null);
    }

    public void registerUser(User user) {
        Optional<User> userOptional = userRepository.findUserByEmail(user.getEmail());
        if (userOptional.isPresent()) {
            throw new IllegalArgumentException("User with email " + user.getEmail() + " already exists");
        } else {
            user.setRoles(List.of(new Role("ROLE_USER")));
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

    @Transactional
    public void updateUserYoutube(int userId,
                              URL youtubeLink) {
        User user = userRepository.findById(userId).orElseThrow(() ->
                new IllegalArgumentException("User with id " + userId + " does not exist"));

        user.setYoutubeLink(youtubeLink);
        System.out.println(user.getYoutubeLink());
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = this.getUserByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(),
                user.getPassword(),
                mapRolesToAuthorities(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles) {
        return roles.stream()
                .map(role -> new SimpleGrantedAuthority(role.getName()))
                .collect(Collectors.toList());

    }
}
