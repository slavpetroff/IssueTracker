package domain.controller.state.local;

import domain.models.entity.Project;
import domain.models.entity.state.LocalState;
import domain.models.service.LocalStateService;
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
@RequestMapping("/state/local")
public class LocalStateController {

    private final LocalStateService localStateService;
    private final ProjectService projectService;

    @Autowired
    public LocalStateController(
            LocalStateService localStateService,
            ProjectService projectService) {
        this.localStateService = localStateService;
        this.projectService = projectService;
    }

    @GetMapping("/register/{projectId}")
    public String registerProjectState(Model model, @PathVariable long projectId) {
        model.addAttribute("state", new LocalState());

        return "state/local/register";
    }

    @PostMapping("/register/{projectId}")
    public String processRegisterProjectState(@ModelAttribute @Valid LocalState localState,
                           @PathVariable long projectId) {

        Project project = this.projectService.findOne(projectId);
        localState.getProjects().add(project);

        project.getLocalStates().add(localState);
        this.localStateService.save(localState);
        return "redirect:/project/fetch";
    }
}
