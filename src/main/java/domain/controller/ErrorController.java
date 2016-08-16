package domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by slavpetroff on 8/16/16.
 */
@Controller
@RequestMapping("/error")
public class ErrorController {

    @GetMapping("/login")
    public String failedLogin() {
        return "error/login";
    }

    @GetMapping("/register")
    public String failedRegister() {
        return "error/register";
    }
}
