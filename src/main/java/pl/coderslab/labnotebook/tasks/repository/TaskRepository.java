package pl.coderslab.labnotebook.tasks.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.labnotebook.tasks.entity.Task;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select * from tasks t  join users_projects as up on t.project_id = up.project_id where up.user_id = :userId and t.is_finished = 0 order by t.last_modification_date desc limit 1", nativeQuery = true)
    Task findNotFinishedTaskByUserIdWithMaxLastModificationDate(@Param("userId") long userId);
    @Query(value = "select * from tasks t where t.project_id = :projectId order by t.last_modification_date desc", nativeQuery = true)
    List<Task> findTasksByProjectIdSortByLastModificationDate(@Param("projectId") long projectId);


}
