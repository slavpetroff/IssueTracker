package domain.controller.type;

import domain.models.entity.Issue;
import domain.models.entity.Project;
import domain.models.entity.Type;
import domain.models.service.IssueService;
import domain.models.service.ProjectService;
import domain.models.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by slavpetroff on 8/15/16.
 */
@Controller
@RequestMapping("/type")
public class TypeController {

    private final TypeService typeService;
    private final IssueService issueService;
    private final ProjectService projectService;

    @Autowired
    public TypeController(TypeService typeService,
                          IssueService issueService,
                          ProjectService projectService) {
        this.typeService = typeService;
        this.issueService = issueService;
        this.projectService = projectService;
    }

    @GetMapping("/register/project/{projectId}")
    public String registerProjectType(Model model,
                           @PathVariable long projectId) {
        model.addAttribute("type", new Type());
        model.addAttribute("projectId", projectId);

        return "type/project/register";
    }

    @PostMapping("/register/project/{projectId}")
    public String processRegisterProjectType(@ModelAttribute @Valid Type type,
                                  @PathVariable long projectId) {
        Project project = this.projectService.findOne(projectId);
        project.setType(type);
        type.getProjects().add(project);

        this.typeService.save(type);
        return "redirect:/project/fetch";
    }

    @GetMapping("/register/issue/{issueId}")
    public String registerIssueType(Model model,
                           @PathVariable long issueId) {
        model.addAttribute("type", new Type());
        model.addAttribute("issueId", issueId);

        return "type/issue/register";
    }

    @PostMapping("/register/issue/{issueId}")
    public String processRegisterIsuueType(@ModelAttribute @Valid Type type,
                           @PathVariable long issueId) {
        Issue issue = this.issueService.findOne(issueId);
        issue.setType(type);
        type.getIssues().add(issue);

        this.typeService.save(type);
        return "redirect:/project/fetch";
    }
}
