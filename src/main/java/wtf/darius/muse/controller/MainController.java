package wtf.darius.muse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import wtf.darius.muse.service.UserService;

import java.security.Principal;
import java.util.logging.Logger;


@Controller
public class MainController {
    private final UserService userService;
    Logger logger = Logger.getLogger(MainController.class.getName());

    public MainController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ModelAndView showHomePage(Principal user) {
        if (user != null) {
            ModelAndView mav = new ModelAndView("loggedIndex");
            mav.addObject("users", userService.getUser(1));
            System.out.println("logged in index shown");
            return mav;
        }
        else {
            ModelAndView mav = new ModelAndView("index");
            System.out.println("logged out index shown");
            return mav;
        }
    }

    @GetMapping("/error")
    public String showErrorPage() { return "error"; }

    @GetMapping("/register")
    public String showRegisterPage() { return "registration"; }

    @GetMapping("/success")
    public String showRegisterSuccessPage() { return "success"; }

    @GetMapping("/logoutSuccess")
    public String logoutSuccess() { return "logoutSuccess"; }

    //just a test to see if the login & role assigning works
    @GetMapping("/authenticated")
    public String showSecretPage() { return "authenticated"; }

    @GetMapping ("/profile")
    public ModelAndView showProfilePage() {
        ModelAndView mav = new ModelAndView("profile");
        mav.addObject("users", userService.getUser(1));
        return mav;
    }

    @GetMapping ("/admin")
    public ModelAndView showStudentsPage() {
        ModelAndView mav = new ModelAndView("admin");
        mav.addObject("users", userService.getAllUsers());
        return mav;
    }

}
