package wtf.darius.muse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import wtf.darius.muse.model.User;
import wtf.darius.muse.service.UserService;

import java.util.List;



@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{userId}")
    public User getUser(@PathVariable int userId) {

        return userService.getUser(userId);
    }

    @PostMapping
    public void registerUser(@RequestBody User user) {
        userService.registerUser(user);
    }


    @PutMapping(path = "/{userId}/bio")
    public void updateUserBio(@PathVariable("userId") int userId,
                              @RequestParam(required = false) String bio)
    {
        userService.updateUserBio(userId,bio);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);

    }

}

