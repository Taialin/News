package com.example.news.controllers;

import com.example.news.dob.User;
import com.example.news.repository.UserRepository;
import com.example.news.services.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MainController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @GetMapping("")
    public String firstPage() {
        return "index";
    }


    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "registrationPage";
    }

    @PostMapping("/registrationProcess")
    public String registrationProcess(User user) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodePassword = encoder.encode(user.getPassword());
        user.setPassword(encodePassword);
        userRepository.save(user);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showloginForm(Model model) {
        model.addAttribute("user", new User());
        return "loginPage";
    }

    @PostMapping("/isExist")
    public String checkData(String userName) throws UsernameNotFoundException {
        UserDetails user = userService.loadUserByUsername(userName);
        if (user == null) {
            throw new UsernameNotFoundException("no user with such name");
        }
        return "news";
    }
}
