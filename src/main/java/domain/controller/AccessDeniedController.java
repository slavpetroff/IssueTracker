package domain.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by slavpetroff on 7/21/16.
 */
@Controller(value = "/accessDenied")
public class AccessDeniedController {

    @RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
    public String processTheError() {

        return "error/accessDenied";
    }
}
