package pl.coderslab.labnotebook.service;

import org.springframework.beans.factory.annotation.Autowired;
import pl.coderslab.labnotebook.entity.Experiment;
import pl.coderslab.labnotebook.repository.ExperimentRepository;

import java.util.List;
import java.util.Optional;

public class ExperimentService {
    ExperimentRepository experimentRepository;
    @Autowired
    public void ExperimentRepository(ExperimentRepository experimentRepository) {
        this.experimentRepository = experimentRepository;
    }
    public Optional<Experiment> findById(long id) {
        return experimentRepository.findById(id);
    }

    private List<Experiment> findAll() {
        return experimentRepository.findAll();
    }

    private void save(Experiment experiment) {
        experimentRepository.save(experiment);
    }

    private void delete(long id) {
        experimentRepository.deleteById(id);
    }
    private List<Experiment> findExperimentsByTaskId(long taskId) {
        return experimentRepository.findExperimentsByTaskId(taskId);
    }
}
