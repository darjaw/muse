package wtf.darius.muse.controller;

import org.springframework.web.bind.annotation.*;
import wtf.darius.muse.model.User;
import wtf.darius.muse.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public String add(@RequestBody User user) {
        userService.saveUser(user);
        return "New user added";
    }

    @GetMapping("/getAll")
    public List<User> getAll() {

        return userService.getAllUsers();
    }
    @GetMapping("/getById/{id}")
    public User getById(@PathVariable int id) {
        return userService.getUserById(id);
    }
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        userService.deleteUser(id);
        return "User deleted";
    }

//    @PutMapping("/update/{id}")
//    public String update(@PathVariable int id, @RequestBody User user) {
//        userService.updateUser(id, user);
//        return "User updated";
//    }
}

