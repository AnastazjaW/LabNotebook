package pl.coderslab.labnotebook.experiment.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.labnotebook.protocol.entity.Protocol;
import pl.coderslab.labnotebook.tasks.entity.Task;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Entity
@Table(name = Experiment.TABLE_NAME)
@Data
public class Experiment {
    final static String TABLE_NAME = "experiments";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotEmpty
    @Size(min = 2, max = 100)
    private String name;
    @Column
    @NotEmpty
    @Size(min = 2, max = 260)
    private String description;
    @Column(name = "last_modification_date")
    private LocalDateTime lastModificationDate;
    @Column(name = "is_finished")
    @Range(min = 0, max = 1)
    private byte isFinished;
    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;
    @ManyToOne
    @JoinColumn(name = "protocol_id")
    private Protocol protocol;

}
