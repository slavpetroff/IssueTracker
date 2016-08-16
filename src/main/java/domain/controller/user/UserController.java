package domain.controller.user;

import domain.enums.Role;
import domain.models.dto.UserDto;
import domain.models.entity.User;
import domain.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Created by slavpetroff on 8/15/16.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login(Model model) {
        model.addAttribute("user", new UserDto());

        return "user/login";
    }

    @GetMapping("/loginFailed")
    public String failedLogin() {

        return "error/loginFailed";
    }

    @GetMapping("/fetch")
    public String fetchUsers(Model model) {
        model.addAttribute("users", this.userService.findAll());

        return "user/fetch";
    }

    @GetMapping("/{userId}/info")
    public String getInfo(Model model, @PathVariable long userId) {
        User user = this.userService.findOne(userId);
        model.addAttribute("user", user);

        return "user/info";
    }

    @GetMapping("/register")
    public String register(Model model) {
        model.addAttribute("user", new UserDto());

        return "user/register";
    }

    @PostMapping("/register")
    public String processRegister(@ModelAttribute User userToAdd) throws InstantiationException,
            IllegalAccessException {
        this.userService.save(userToAdd, Role.ROLE_USER);

        return "redirect:/user/login";
    }
}
