package pl.coderslab.labnotebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.coderslab.labnotebook.entity.Project;

import java.util.List;
@Repository
public interface ProjectRepository extends JpaRepository<Project, Long> {
    @Query(value = "select * from projects p join users_projects up on p.id = up.project_id where up.user_id = :userId order by p.start_date desc", nativeQuery = true)
    List<Project> findAllProjectsOrderByStartDate(@Param("userId") long userId);
}
