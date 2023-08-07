package boot.controllers;

import boot.models.User;
import boot.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping()
    public String carsView() {
        return "hellopage";
    }

    @GetMapping("/users")
    public String getUserList(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/users/{id}")
    public String getUser(@PathVariable("id") Long id, Model model) {
        model.addAttribute("user", userService.findById(id));
        return "show";
    }

    @GetMapping("/users/new")
    public String newUserForm(@ModelAttribute("newuser") User user) {
        return "new";
    }

    @PostMapping("/users")
    public String saveNewUser(@ModelAttribute("newuser") User user) {
        userService.save(user);
        return "redirect:/users";
    }

    @GetMapping("/users/{id}/edit")
    public String updateUserForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("updateduser", userService.findById(id));
        return "edit";
    }

    @PatchMapping("/users/{id}")
    public String updateUser(User user) {
        userService.update(user.getId(), user);
        return "redirect:/users/" + user.getId();
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable("id") Long id) {
        userService.delete(id);
        return "redirect:/users";
    }

}

