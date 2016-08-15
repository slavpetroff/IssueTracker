//package domain.controller.state;
//
//import domain.models.entity.Project;
//import domain.models.entity.state.AbstractState;
//import domain.models.entity.state.ApplicationState;
//import domain.models.entity.state.LocalState;
//import domain.models.service.ApplicationStateService;
//import domain.models.service.LocalStateService;
//import domain.models.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//import javax.naming.OperationNotSupportedException;
//import javax.validation.Valid;
//
///**
// * Created by slavpetroff on 8/13/16.
// */
//@Controller
//@RequestMapping("/state")
//public class StateController {
//
//    private final ApplicationStateService applicationStateService;
//    private final LocalStateService localStateService;
//    private final ProjectService projectService;
//
//
//    @Autowired
//    public StateController(
//            ApplicationStateService applicationStateService,
//            LocalStateService localStateService,
//            ProjectService projectService) {
//        this.applicationStateService = applicationStateService;
//        this.localStateService = localStateService;
//        this.projectService = projectService;
//    }
//
//    @GetMapping("/{type}/register/{projectId}")
//    public String register(
//            Model model,
//            @PathVariable String type,
//            @PathVariable long projectId) throws OperationNotSupportedException {
//
//        AbstractState state = null;
//        Project project = this.projectService.findOne(projectId);
//
//        switch (type) {
//            case "local":
//                state = new LocalState();
//                model.addAttribute("local", state);
//                break;
//            case "application":
//                state = new ApplicationState();
//                model.addAttribute("application", state);
//                break;
//            default:
//                throw new OperationNotSupportedException("Unrecognized state! Could be: local or application!");
//        }
//
//        model.addAttribute("type", type);
//        model.addAttribute("projectId", projectId);
//
//        return "state/register";
//    }
//
//    @PostMapping("/{type}/register/{projectId}")
//    public String processRegister(
//            @ModelAttribute("local") @Valid ApplicationState appState,
//            @ModelAttribute("application") @Valid LocalState localState,
//            @PathVariable String type,
//            @PathVariable long projectId) throws OperationNotSupportedException {
//        Project project = this.projectService.findOne(projectId);
//
//        if (!type.equalsIgnoreCase("local")) {
//            project.getApplicationStates().add(appState);
//            this.applicationStateService.save(appState);
//            return "redirect:/project/fetch";
//        }
//
//        project.getLocalStates().add(localState);
//        this.localStateService.save(localState);
//
//        return "redirect:/project/fetch";
//    }
//
//}
