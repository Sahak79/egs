package com.egs.web.controller.user;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by SahakBabayan on 12/5/2017.
 */
@Controller
@PreAuthorize("hasRole('ROLE_USER')")
public class UserController {
    @RequestMapping("/user/home")
    public String homeManager(@AuthenticationPrincipal User user) {
        return "user/home";
    }
}
