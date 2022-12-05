package pl.coderslab.labnotebook.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.labnotebook.entity.Project;
import pl.coderslab.labnotebook.service.ProjectService;

import javax.validation.Valid;


@Controller
@RequestMapping("/project")
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;
    @GetMapping("/add")
    public String form(Model model) {
        model.addAttribute("project", new Project());
        return "project/create_project_form";
    }

    @PostMapping("/add")
    public String saveProject(@Valid Project project, BindingResult result) {
        if (result.hasErrors()) {
            return "project/create_project_form";
        }
        projectService.save(project);
        return "/project/projects_list";
    }
}
