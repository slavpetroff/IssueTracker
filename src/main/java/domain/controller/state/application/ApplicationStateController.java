package domain.controller.state.application;

import domain.models.entity.Project;
import domain.models.entity.state.ApplicationState;
import domain.models.service.ApplicationStateService;
import domain.models.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by slavpetroff on 8/15/16.
 */
@Controller
@RequestMapping("/state/application")
public class ApplicationStateController {
    private final ApplicationStateService applicationStateService;
    private final ProjectService projectService;

    @Autowired
    public ApplicationStateController(
            ApplicationStateService applicationStateService,
            ProjectService projectService) {
        this.applicationStateService = applicationStateService;
        this.projectService = projectService;
    }

    @GetMapping("/register/{projectId}")
    public String register(Model model, @PathVariable long projectId) {
        model.addAttribute("state", new ApplicationState());

        return "state/application/register";
    }

    @PostMapping("/register/{projectId}")
    public String register(@ModelAttribute @Valid ApplicationState applicationState,
                           @PathVariable long projectId) {

        Project project = this.projectService.findOne(projectId);
        applicationState.getProjects().add(project);

        project.getApplicationStates().add(applicationState);
        this.applicationStateService.save(applicationState);
        return "redirect:/project/fetch";
    }
}
