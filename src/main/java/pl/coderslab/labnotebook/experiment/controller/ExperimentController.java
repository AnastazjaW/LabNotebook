package pl.coderslab.labnotebook.experiment.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.labnotebook.experiment.entity.Experiment;
import pl.coderslab.labnotebook.experiment.service.ExperimentService;
import pl.coderslab.labnotebook.project.service.ProjectService;
import pl.coderslab.labnotebook.tasks.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/project/{projectID}/task/{taskId}")
public class ExperimentController {
    private final ExperimentService experimentService;
    private final TaskService taskService;
    private final ProjectService projectService;

    @GetMapping("/experiments")
    public String findExperimentsOfTask(@ PathVariable long projectID, @PathVariable long taskId, Model model) {
        List<Experiment> experiments = experimentService.findExperimentsByTaskId(taskId);
        model.addAttribute("project", projectService.findById(projectID).get());
        model.addAttribute("task", taskService.findById(taskId).get());
        model.addAttribute("experimentsList", experiments);
        return "experiment/experiments_list";
    }
    @GetMapping("/experiment/add")
    public String addExperiment(Model model) {
        model.addAttribute("experiment", new Experiment());
        return "experiment/create_experiment_form";
    }

    @PostMapping("/experiment/add")
    public String addExperiment(@ModelAttribute("experiment") @Valid Experiment experiment, BindingResult result, @PathVariable long taskId) {
        if (result.hasErrors()) {
            return "experiment/create_experiment_form";
        }
        experiment.setTask(taskService.findWithProjectById(taskId));
        experimentService.save(experiment);
        return "redirect:/project/{projectID}/task/{taskId}/experiments";
    }
    @RequestMapping("/experiment/delete/{expId}")
    public String deleteExperiment(@PathVariable long expId) {
        experimentService.delete(expId);
        return "redirect:/project/{projectID}/task/{taskId}/experiments";
    }
    @GetMapping("experiment/edit/{expId}")
    public String editExperiment(@PathVariable long expId, Model model) {
        model.addAttribute("experimentToEdit", experimentService.findById(expId).get());
        return "experiment/edit_experiment_form";
    }

    @PostMapping("experiment/edit/{expId}")
    public String editExperiment(@ModelAttribute("experimentToEdit") @Valid Experiment experiment, BindingResult result,
                           @PathVariable long expId,
                                 @PathVariable long taskId) {
        if (result.hasErrors()) {
            return "experiment/edit_experiment_form";
        }
        experiment.setTask(taskService.findById(taskId).get());
        experiment.setId(expId);
        experimentService.save(experiment);
        return "redirect:/project/{projectID}/task/{taskId}/experiments";
    }
    @RequestMapping("/experiment/finish/{expId}")
    public String markTaskAsFinished(@PathVariable long expId) {
        experimentService.markExperimentAsFinished(expId);
        return "redirect:/project/{projectID}/task/{taskId}/experiments";
    }
}
