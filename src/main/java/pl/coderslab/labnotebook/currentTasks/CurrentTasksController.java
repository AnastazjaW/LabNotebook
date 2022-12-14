package pl.coderslab.labnotebook.currentTasks;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.labnotebook.tasks.entity.Task;
import pl.coderslab.labnotebook.tasks.service.TaskService;
import pl.coderslab.labnotebook.user.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class CurrentTasksController {
    private final TaskService taskService;
    private final UserService userService;

    @GetMapping("/current_tasks")
    public String currentTasks(Model model) {
        long userId = userService.getAuthenticatedUserId();
        List<Task> tasks = taskService.findNotFinishedTasksSortByLastModificationDate(userId);
        for (Task t : tasks) {
            model.addAttribute("project", t.getProject());
        }
        model.addAttribute("currentTasks", tasks);
        return "current_tasks";

    }
}
