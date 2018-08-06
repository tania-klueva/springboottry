package com.example.springboottry.controllers;
import com.example.springboottry.model.User;
import com.example.springboottry.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class MainController {
    @Autowired
    UserService userService;

    @GetMapping("/")
    public String initPage(Model model){
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "index";
    }


    @PostMapping("user/create/")
    public String savePerson(
            @RequestParam String name,
            @RequestParam int age
    ){
        userService.save(new User(age, name));
        return "redirect:/";
    }

    @GetMapping("user/{id}")
    public String getUser(
            @PathVariable int id,
            Model model
    ){
        Optional<User> userOptional = userService.findById(id);
        User user = userOptional.get();
        model.addAttribute("user",user);
        return "user";
    }

    @GetMapping("user/{id}/delete")
    public String deleteUser(
            @PathVariable int id
    ){
        userService.deleteById(id);
        return "redirect:/";
    }
}
