package pl.coderslab.labnotebook.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.coderslab.labnotebook.entity.Project;
import pl.coderslab.labnotebook.repository.ProjectRepository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@Service
@Transactional
@RequiredArgsConstructor
public class ProjectService {
    ProjectRepository projectRepository;
    @Autowired
    public void ProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
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

    public void delete(long id) {
        projectRepository.deleteById(id);
    }
    public List<Project> findAllProjectsOrderByStartDate(long userId) {
       return projectRepository.findAllProjectsOrderByStartDate(userId);
    }
}
