package wtf.darius.muse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;
import java.util.logging.Logger;


@Controller
public class MainController {

    Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String showHomePage(Principal user) {
        if (user != null) {
            System.out.println("logged in index shown");
            return "loggedindex";
        }
        else {
            System.out.println("logged out index shown");
            return "index";
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
    public String showProfilePage() { return "profile"; }

}
