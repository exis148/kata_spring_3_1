package com.example.sprtingcrud.controller;


import com.example.sprtingcrud.models.User;
import com.example.sprtingcrud.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("")
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getUsers());
        return "/user";
    }

    @GetMapping("/new")
    public String newUser( Model model, User user) {

        return "/new";
    }

    @PostMapping()
    public String create(@Valid @ModelAttribute("user") User user, BindingResult bindingResult) {


        if (bindingResult.hasErrors()) {
            return "/new";
        }
        userService.saveUserButton(user);
        return "redirect:/user";
    }

    @GetMapping("/edit")
    public String editUser(@RequestParam int id, Model model) {


        model.addAttribute("user", userService.getUserById(id));
        return "/edit";
    }

    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, @RequestParam int id) {

        if (bindingResult.hasErrors()) {
            return "/edit";
        }
        userService.updateUser(id, user);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam int id) {
        userService.deleteUser(id);
        return "redirect:/user";
    }
}
