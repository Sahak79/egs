package com.egs.web.controller.general;

import com.egs.common.data.model.User;
import com.egs.common.data.model.lcp.UserProfile;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import java.util.Optional;

/**
 * Created by SahakBabayan on 12/5/2017.
 */
@Controller
public class LoginController {
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView getLoginPage(@RequestParam Optional<String> error) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (!(auth instanceof AnonymousAuthenticationToken)) {
    	    /* User is already logged in :) */
            return new ModelAndView("redirect:/home", "error", error);
        }

        return new ModelAndView("login", "error", error);
    }

    @PreAuthorize("hasRole('ROLE_ADMINISTRATOR') or hasRole('ROLE_USER')")
    @RequestMapping("/home")
    public String home(@AuthenticationPrincipal User user) {
        System.out.println(user.getFiles());
        if (user.getProfile() == UserProfile.ADMINISTRATOR) {
            return "redirect:administrator/home";
        }
        return "redirect:user/home";
    }
}
