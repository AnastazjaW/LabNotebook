package pl.coderslab.labnotebook.experiment.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.labnotebook.experiment.entity.Experiment;
import pl.coderslab.labnotebook.experiment.repository.ExperimentRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
@RequiredArgsConstructor
@Service
public class ExperimentService {
    private final ExperimentRepository experimentRepository;

    public Optional<Experiment> findById(long id) {
        return experimentRepository.findById(id);
    }

    public List<Experiment> findAll() {
        return experimentRepository.findAll();
    }

    public void save(Experiment experiment) {
        LocalDateTime date = LocalDateTime.now();
        experiment.setLastModificationDate(date);
        experimentRepository.save(experiment);
    }

    public void delete(long id) {
        experimentRepository.deleteById(id);
    }
    public List<Experiment> findExperimentsByTaskId(long taskId) {
        return experimentRepository.findExperimentsByTaskId(taskId);
    }
    public void markExperimentAsFinished(long id) {
        Experiment experiment = experimentRepository.getById(id);
        experiment.setIsFinished((byte) 1);
        save(experiment);
    }
}
