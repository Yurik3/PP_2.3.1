package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import web.service.UserService;
import web.model.User;


@Controller
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/user")
    public String getUser(Model model) {
       // Iterable<User> users = userService.getUsers();
        model.addAttribute("users", userService.getUsers());
        return "users";
    }

    @GetMapping(value = "/addUser")
    public String addUser(Model model) {
        return "addUser";
    }

    @PostMapping("/addUser")
    public String addUsers(@RequestParam String name , @RequestParam String secondName, @RequestParam int old, Model model){
        User user = new User(name, secondName, old);
      userService.add(user);
        return "redirect:/user";
    }



}
