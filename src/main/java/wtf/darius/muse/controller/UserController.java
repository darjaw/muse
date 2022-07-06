package wtf.darius.muse.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import wtf.darius.muse.model.User;
import wtf.darius.muse.service.UserService;

import java.net.URL;
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
    @ResponseBody
    public ResponseEntity<String> updateUserBio(@PathVariable("userId") int userId,
                                        @RequestParam(required = false) String bio)
    {
        userService.updateUserBio(userId,bio);
        return new ResponseEntity<>("Bio updated", HttpStatus.OK);
    }

    @PutMapping(path = "/{userId}/youtube")
    @ResponseBody
    public ResponseEntity<String> updateUserYoutube(@PathVariable("userId") int userId,
                                                @RequestParam(required = false) URL youtubeLink)
    {
        userService.updateUserYoutube(userId,youtubeLink);
        return new ResponseEntity<>("YouTube link updated", HttpStatus.OK);
    }

    @DeleteMapping(path = "{userId}")
    public void deleteUser(@PathVariable("userId") int userId) {
        userService.deleteUser(userId);

    }



}

