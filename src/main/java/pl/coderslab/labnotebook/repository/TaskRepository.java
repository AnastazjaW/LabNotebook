package pl.coderslab.labnotebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.labnotebook.entity.Task;

import java.util.List;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
    @Query(value = "select * from tasks as t join users_projects as up on t.project_id = up.project_id where up.user_id = :userId order by t.last_modification desc", nativeQuery = true)
    List<Task> findNotFinishedTasksByUserIdSortByLastModificationDate(@Param("userId") long userId);
    @Query("select t from Task t where t.project.id = :projectId order by t.lastModificationDate desc")
    List<Task> findTasksByProjectIdSortByLastModificationDate(@Param("projectId") long projectId);

}
