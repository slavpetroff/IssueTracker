package domain.controller;

import domain.models.service.IssueService;
import domain.models.service.ProjectService;
import domain.models.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by slavpetroff on 8/18/16.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    private final IssueService issueService;
    private final TypeService typeService;
    private final ProjectService projectService;

    @Autowired
    public TestController(IssueService issueService,
                          ProjectService projectService,
                          TypeService typeService) {
        this.issueService = issueService;
        this.projectService = projectService;
        this.typeService = typeService;
    }

    @GetMapping
    public String test(Model model) {
        model.addAttribute("issues", this.projectService.findOne(3L).getIssues());
        model.addAttribute("types", this.typeService.findAll());
        model.addAttribute("types", this.typeService.findAll());
        return "test";
    }
}
