package org.TeamDream.NaumenShop.controllers;

import org.TeamDream.NaumenShop.DB.models.User;
import org.TeamDream.NaumenShop.services.SecurityService;
import org.TeamDream.NaumenShop.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AuthController {
    @Autowired
    private SecurityService securityService;

    @GetMapping("/login")
    public String login() {
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        return "login.html";
    }

//    @PostMapping("/login")
//    public String loginSubmit(Model model, @ModelAttribute("logUser") User logUser){
//
//        if (!userService.saveUser(logUser)){
//            model.addAttribute("usernameError", "Пользователь с таким именем не существует");
//            return "registration.html";
//        }
//
//        return "redirect:/";
//    }

    @GetMapping("/registration")
    public String registrationForm(Model model){
        if (securityService.isAuthenticated()) {
            return "redirect:/";
        }

        model.addAttribute("regUser", new User());

        return "registration.html";
    }

    @Autowired
    private UserService userService;

    @PostMapping("/registration")
    public String registrationSubmit(Model model,//
                                     @ModelAttribute("regUser") User regUser){

        if (!userService.saveUser(regUser)){
            model.addAttribute("usernameError", "Пользователь с таким именем уже существует");
            return "registration.html";
        }

        return "redirect:/login";
    }


    @RequestMapping(value="/403")
    public String Error403(){
        return "403.html";
    }
}
