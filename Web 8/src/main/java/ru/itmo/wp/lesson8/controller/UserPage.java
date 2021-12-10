package ru.itmo.wp.lesson8.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ru.itmo.wp.lesson8.domain.User;
import ru.itmo.wp.lesson8.service.UserService;

import javax.validation.constraints.Pattern;

@Controller
public class UserPage extends Page {
    private final UserService userService;

    public UserPage(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user/{id}")
    public String user(Model model, @Pattern(regexp = "[0-9]+", message = "Only numbers allowed") @PathVariable String id) {
        User user = null;
        try {
            user = userService.findById(Long.parseLong(id));
        } catch (NumberFormatException ignored) {
        }
        if (user != null) {
            model.addAttribute("pageUser", user);
        }
        return "UserPage";
    }
}
