package pl.coderslab.labnotebook.tasks.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import pl.coderslab.labnotebook.project.entity.Project;
import pl.coderslab.labnotebook.project.service.ProjectService;
import pl.coderslab.labnotebook.tasks.entity.Task;
import pl.coderslab.labnotebook.tasks.service.TaskService;
import pl.coderslab.labnotebook.user.entity.User;
import pl.coderslab.labnotebook.user.service.UserService;

import javax.swing.*;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("/project/{projectID}")
public class TaskController {
    private final TaskService taskService;
    private final ProjectService projectService;
    private final UserService userService;
    @ModelAttribute("users")
    public List<User> users() {
        return userService.findAllUsersWithoutProjectCreator();
    }

    @GetMapping("/tasks")
    public String findProjectTasks(@PathVariable long projectID, Model model) {
        List<Task> projectTasks = taskService.findTasksByProjectIdSortByLastModificationDate(projectID);
        model.addAttribute("project", projectService.findById(projectID).get());
        model.addAttribute("taskList", projectTasks);
        return "task/task_list";
    }

    @GetMapping("/task/add")
    public String addTask(Model model) {
        model.addAttribute("task", new Task());
        return "task/create_task_form";
    }

    @PostMapping("/task/add")
    public String saveTask(@ModelAttribute("task") @Valid Task task, BindingResult result, @PathVariable long projectID) {
        if (result.hasErrors()) {
            return "task/create_task_form";
        }
        task.setProject(projectService.findWithUsersById(projectID));
        taskService.save(task);
        return "redirect:/project/{projectID}/tasks";
    }

    @RequestMapping("/task/delete/{taskId}")
    public String deleteTask(@PathVariable long taskId) {
        taskService.delete(taskId);
        return "redirect:/project/{projectID}/tasks";
    }

    @GetMapping("task/edit/{taskId}")
    public String editTask(@PathVariable long taskId, Model model) {
        model.addAttribute("taskToEdit", taskService.findById(taskId).get());
        return "task/edit_task_form";
    }

    @PostMapping("task/edit/{taskId}")
    public String editTask(@Valid Task task, BindingResult result,
                           @PathVariable long taskId, @PathVariable long projectID) {
        if (result.hasErrors()) {
            return "task/edit_task_form";
        }
        task.setProject(projectService.findWithUsersById(projectID));
        task.setId(taskId);
        taskService.save(task);
        return "redirect:/project/{projectID}/tasks";
    }

    @RequestMapping("/task/finish/{taskId}")
    public String markTaskAsFinished(@PathVariable long taskId) {
        taskService.markTaskAsFinished(taskId);
        return "redirect:/project/{projectID}/tasks";

    }
}
