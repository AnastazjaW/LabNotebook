package pl.coderslab.LabNotebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.w3c.dom.stylesheets.LinkStyle;
import pl.coderslab.LabNotebook.LabNotebookApplication;
import pl.coderslab.LabNotebook.entity.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
