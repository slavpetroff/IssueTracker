package domain.controller.board;

import domain.models.service.ApplicationStateService;
import domain.models.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by slavpetroff on 8/15/16.
 */
@Controller
public class BoardController {

    private final ApplicationStateService applicationStateService;
    private final ProjectService projectService;

    @Autowired
    public BoardController(ApplicationStateService applicationStateService, ProjectService projectService) {
        this.applicationStateService = applicationStateService;
        this.projectService = projectService;
    }

    @GetMapping("/dashboard")
    public String getDashboard(Model model) {
        model.addAttribute("states", this.applicationStateService.findAll());
        model.addAttribute("projects");

        return null;
    }


}
