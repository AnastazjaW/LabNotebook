package pl.coderslab.labnotebook.lastTask;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.coderslab.labnotebook.tasks.entity.Task;
import pl.coderslab.labnotebook.tasks.service.TaskService;
import pl.coderslab.labnotebook.user.service.UserService;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class LastTaskController {
    private final TaskService taskService;
    private final UserService userService;

    @GetMapping("/last_task")
    public String lastTasks(Model model) {
        long userId = userService.getAuthenticatedUserId();
        Task lastTask = taskService.findNotFinishedTaskByUserIdWithMaxLastModificationDate(userId);
        model.addAttribute("lastTask", lastTask);
        if (null != lastTask) {
            model.addAttribute("project", lastTask.getProject());
        }
        return "last_task";

    }
}
