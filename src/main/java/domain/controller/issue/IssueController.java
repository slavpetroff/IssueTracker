package domain.controller.issue;

import domain.models.entity.Issue;
import domain.models.entity.Project;
import domain.models.service.IssueService;
import domain.models.service.ProjectService;
import domain.models.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by slavpetroff on 8/10/16.
 */
@Controller
@RequestMapping("/issue")
public class IssueController {

    private final IssueService issueService;
    private final ProjectService projectService;
    private final UserService userService;

    @Autowired
    public IssueController(IssueService issueService, ProjectService projectService, UserService userService) {
        this.issueService = issueService;
        this.projectService = projectService;
        this.userService = userService;
    }

    @GetMapping("/fetch")
    public String fetchIssues(Model model) {
        model.addAttribute("issues", this.issueService.findAll());
        model.addAttribute("projects", this.projectService.findAll());

        return "issue/fetch";
    }

    @GetMapping("/{issueId}/info")
    public String getInfo(Model model, @PathVariable long issueId) {
        Issue issue = this.issueService.findOne(issueId);
        model.addAttribute("issue", issue);

        return "issue/info";
    }

    @GetMapping("/register/{projectId}")
    public String register(Model model, @PathVariable long projectId) {
        Issue issue = new Issue();
        Project project = this.projectService.findOne(projectId);
        model.addAttribute("issue", issue);
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("states", project.getAllowedStates());
        model.addAttribute("types", project.getType());
        model.addAttribute("projectId", projectId);

        return "issue/register";
    }

    @PostMapping("/register/{projectId}")
    public String processRegister(@ModelAttribute @Valid Issue issue, @PathVariable long projectId) {
        Project project = this.projectService.findOne(projectId);
        project.getIssues().add(issue);
        issue.setProject(project);
        this.issueService.save(issue);

        return "redirect:/issue/fetch";
    }
}
