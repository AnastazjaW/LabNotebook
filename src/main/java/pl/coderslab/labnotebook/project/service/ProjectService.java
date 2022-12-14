package pl.coderslab.labnotebook.project.service;

import lombok.RequiredArgsConstructor;
import org.hibernate.Hibernate;
import org.springframework.stereotype.Service;
import pl.coderslab.labnotebook.project.entity.Project;
import pl.coderslab.labnotebook.project.repository.ProjectRepository;
import pl.coderslab.labnotebook.user.service.UserService;

import javax.transaction.Transactional;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final UserService userService;
    public Optional<Project> findById(long id) {
        return projectRepository.findById(id);
    }

    public List<Project> findAll() {
        return projectRepository.findAll();
    }

    public void save(Project project) {
        LocalDateTime startDate = LocalDateTime.now();
        project.setStartDate(startDate);
        projectRepository.save(project);
    }

    public void addProjectCreatorToProjectUsersList(Project project) {
        project.getUsers().add(userService.getAuthenticatedUser());
    }

    public void delete(long id) {
        projectRepository.deleteById(id);
    }
    public List<Project> findAllProjectsByUserIdOrderByStartDate(long userId) {
       return projectRepository.findAllProjectsOrderByStartDate(userId);
    }
    private void addUsersToProject(Project project) {
        Hibernate.initialize(project.getUsers());
    }
    public Project findWithUsersById(long id) {
        Project project = projectRepository.getOne(id);
        addUsersToProject(project);
        return project;
    }

    public void addFinishDateToProject(long id) {
        Project project = projectRepository.getOne(id);
        LocalDateTime finishDate = LocalDateTime.now();
        project.setFinishDate(finishDate);
    }
}
