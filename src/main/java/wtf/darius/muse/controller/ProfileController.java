package wtf.darius.muse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import wtf.darius.muse.model.User;

@Controller
@RequestMapping(path = "api/v1/profile")
public class ProfileController {

    @GetMapping(path = "/{profileId}")
    public User getProfile(@PathVariable String profileId) {


        return null;
    }



}
