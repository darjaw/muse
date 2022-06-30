package wtf.darius.muse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.logging.Logger;


@Controller
public class MainController {

    Logger logger = Logger.getLogger(MainController.class.getName());

    @GetMapping("/")
    public String showHomePage() {
        return "index";
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
    @GetMapping("/secret")
    public String showSecretPage() { return "secret"; }

    @GetMapping ("/profile")
    public String showProfilePage() { return "profile"; }

}
