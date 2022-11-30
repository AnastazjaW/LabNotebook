package pl.coderslab.LabNotebook.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
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
    private String name;
    @Column
    private String description;
    @Column(name = "last_modification")
    private Date lastModification;
    @Column(name = "is_finished")
    @Range(min = 0, max = 1)
    private byte isFinished;
    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;
}
