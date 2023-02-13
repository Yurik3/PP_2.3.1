package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import web.dao.UserDao;
import web.service.UserService;
import web.model.User;

import java.util.ArrayList;
import java.util.Optional;


@Controller
@RequestMapping("/")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController (UserService userService) {
        this.userService = userService;
    }

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
    public String addUsers(@ModelAttribute("user") User user) {
        userService.add(user);
        return "redirect:/user";
    }

    @GetMapping("/{id}/delete")
    public String deleteUser(@PathVariable(value = "id") long id, Model model) {
        userService.deleteUser(id);
        return "redirect:/user";
    }

    @GetMapping("/{id}/edit")
    public String editUser(@PathVariable(value = "id") long id, Model model) {
        Optional<User> user = Optional.ofNullable(userService.findUser(id));
        ArrayList<User> res = new ArrayList<>();
        user.ifPresent(res::add);
        model.addAttribute("user", res);
        return "edit";
    }

    @PostMapping("/{id}/edit")
    public String editUsers(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String secondName, @RequestParam int old, Model model) {
        User user = userService.findUser(id);
        user.setName(name);
        user.setSecondName(secondName);
        user.setOld(old);
        userService.editUser(user);
        return "redirect:/user";
    }
}
