package pl.coderslab.labnotebook.tasks.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.labnotebook.tasks.entity.Task;
import pl.coderslab.labnotebook.tasks.repository.TaskRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository taskRepository;
    public Optional<Task> findById(long id) {
        return taskRepository.findById(id);
    }

    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    public void save(Task task) {
        LocalDateTime date = LocalDateTime.now();
        task.setLastModificationDate(date);
        taskRepository.save(task);
    }

    public void delete(long id) {
        taskRepository.deleteById(id);
    }
    public List<Task> findNotFinishedTasksSortByLastModificationDate(long userId) {
        return taskRepository.findNotFinishedTasksByUserIdSortByLastModificationDate(userId);
    }
    public List<Task> findTasksByProjectIdSortByLastModificationDate(long projectId) {
        return taskRepository.findTasksByProjectIdSortByLastModificationDate(projectId);
    }
    private void addProjectToTask(Task task) {
        Hibernate.initialize(task.getProject());
    }
    public Task findWithProjectById(long id) {
        Task task = taskRepository.getById(id);
        addProjectToTask(task);
        return task;
    }
    public void markTaskAsFinished(long id) {
        Task task = findWithProjectById(id);
        task.setIsFinished((byte) 1);
        save(task);
    }
}
