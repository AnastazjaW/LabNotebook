package pl.coderslab.labnotebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.labnotebook.entity.Experiment;

import java.util.List;
@Repository
public interface ExperimentRepository extends JpaRepository<Experiment, Long> {
    @Query("select e from Experiment e where e.task.id = :taskId order by e.lastModificationDate desc")
    List<Experiment> findExperimentsByTaskId(@Param("taskId") long taskId);

}
