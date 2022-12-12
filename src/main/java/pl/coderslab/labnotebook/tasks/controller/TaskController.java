package pl.coderslab.labnotebook.tasks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.labnotebook.project.service.ProjectService;
import pl.coderslab.labnotebook.tasks.entity.Task;
import pl.coderslab.labnotebook.tasks.service.TaskService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/task")
public class TaskController {
    private final TaskService taskService;
    private final ProjectService projectService;

    @GetMapping("/list/{id}")
    public List<Task> findProjectTasks(@PathVariable long id, Model model) {
        List<Task> projectTasks = taskService.findTasksByProjectIdSortByLastModificationDate(id);
        model.addAttribute("taskList", projectTasks);
        return projectTasks;
    }

    @GetMapping("/add")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        return "task/create_task_form";
    }

    @PostMapping("/add")
    public String saveTask(@ModelAttribute("task") @Valid Task task, BindingResult result) {
        if (result.hasErrors()) {
            return "task/create_task_form";
        }
        taskService.save(task);
        return "redirect:/list/{id}";

    }
}
