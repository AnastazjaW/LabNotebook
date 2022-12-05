package pl.coderslab.labnotebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.labnotebook.entity.Task;
import pl.coderslab.labnotebook.repository.TaskRepository;

import java.util.List;
import java.util.Optional;

public class TaskService {
    TaskRepository taskRepository;
    @Autowired
    public void TaskRepository(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }
    public Optional<Task> findById(long id) {
        return taskRepository.findById(id);
    }

    private List<Task> findAll() {
        return taskRepository.findAll();
    }

    private void save(Task task) {
        taskRepository.save(task);
    }

    private void delete(long id) {
        taskRepository.deleteById(id);
    }
    private List<Task> findNotFinishedTasksSortByLastModificationDate(long userId) {
        return taskRepository.findNotFinishedTasksByUserIdSortByLastModificationDate(userId);
    }
    private List<Task> findTasksByProjectIdSortByLastModificationDate(long projectId) {
        return taskRepository.findTasksByProjectIdSortByLastModificationDate(projectId);
    }
}
