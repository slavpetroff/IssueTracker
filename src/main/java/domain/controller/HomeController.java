package domain.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by slavpetroff on 7/17/16.
 */
@Controller(value = "/")
@PreAuthorize("hasAnyRole('ADMIN', 'USER')")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String defaultPage() {

        return "redirect:/index";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index() {

        return "redirect:/project/fetch";
    }


}
