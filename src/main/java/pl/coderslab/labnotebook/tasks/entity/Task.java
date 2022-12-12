package pl.coderslab.labnotebook.tasks.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.labnotebook.project.entity.Project;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Date;


@Entity
@Table(name = Task.TABLE_NAME)
@Data
public class Task {
    final static String TABLE_NAME = "tasks";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotEmpty
    @Size(min = 2)
    private String name;
    @Column
    @NotEmpty
    @Size(min = 2)
    private String description;
    @Column(name = "last_modification_date")
    private Date lastModificationDate;
    @Column(name = "is_finished")
    @Range(min = 0, max = 1)
    private byte isFinished;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
