package pl.coderslab.labnotebook.project.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.labnotebook.project.entity.Project;
import pl.coderslab.labnotebook.project.service.ProjectService;
import pl.coderslab.labnotebook.user.entity.User;
import pl.coderslab.labnotebook.user.service.UserService;

import javax.validation.Valid;
import java.util.List;


@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    private final UserService userService;
    @ModelAttribute("users")
    public List<User> users() {
        return userService.findAllUsersWithoutProjectCreator();
    }

    @ModelAttribute("projectsList")
    public List<Project> projects() {
        return projectService.findAllProjectsByUserIdOrderByStartDate(userService.getAuthenticatedUserId());
    }
    @GetMapping("/add")
    public String addProject(Model model) {
        model.addAttribute("project", new Project());
        return "project/create_project_form";
    }

    @PostMapping("/add")
    public String saveProject(@ModelAttribute("project") @Valid Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "project/create_project_form";
        }
        projectService.addProjectCreatorToProjectUsersList(project);
        projectService.save(project);
        return "redirect:/project/list";
    }
    @GetMapping("/list")
    public String projectsList() {
        return "project/projects_list";
    }

    @RequestMapping("/delete/{id}")
    public String deleteProject(@PathVariable long id) {
        projectService.delete(id);
        return "redirect:/project/list";
    }
    @GetMapping("/edit/{id}")
    public String editProject(@PathVariable long id, Model model) {
        model.addAttribute("project", projectService.findWithUsersById(id));
        return "project/edit_project_form";

    }
    @PostMapping("/edit/{id}")
    public String editProject(@PathVariable long id, @Valid Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "project/edit_project_form";
        }
        projectService.addProjectCreatorToProjectUsersList(project);
        projectService.save(project);
        return "redirect:/project/list";
    }

    @RequestMapping("/finish/{id}")
    public String addFinishDateToProject(@PathVariable long id) {
        projectService.addFinishDateToProject(id);
        return "redirect:/project/list";
    }

}
