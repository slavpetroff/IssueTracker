package domain.controller.project;

import domain.models.entity.Project;
import domain.models.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by slavpetroff on 8/8/16.
 */
@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final TypeService typeService;
    private final ApplicationStateService applicationStateService;
    private final LocalStateService localStateService;
    private final UserService userService;

    @Autowired
    public ProjectController(
            ProjectService projectService,
            TypeService typeService,
            UserService userService,
            ApplicationStateService applicationStateService,
            LocalStateService localStateService) {
        this.projectService = projectService;
        this.typeService = typeService;
        this.userService = userService;
        this.applicationStateService = applicationStateService;
        this.localStateService = localStateService;
    }

    @GetMapping("/fetch")
    public String getAllProjects(Model model) {
        model.addAttribute("projects", this.projectService.findAll());

        return "project/fetch";
    }

    @GetMapping("/{projectId}/info")
    public String getInfo(Model model, @PathVariable long projectId) {
        Project project = this.projectService.findOne(projectId);

        model.addAttribute("project", project);
        return "project/info";
    }

    @GetMapping("/register")
    public String registerProject(Model model) {
        model.addAttribute("states", this.applicationStateService.findAll());
        model.addAttribute("types", this.typeService.findAll());
        model.addAttribute("users", this.userService.findAll());
        model.addAttribute("project", new Project());

        return "project/register";
    }

    @PostMapping("/register")
    public String processRegisterProject(@ModelAttribute @Valid Project project) {
        this.projectService.save(project);

        return "redirect:/project/fetch";
    }

    @GetMapping("/{projectId}/issues")
    public String fetchIssues(Model model,
                              @PathVariable long projectId) {
        model.addAttribute("issues", this.projectService.findOne(projectId).getIssues());

        return "project/fetchIssues";
    }
}
