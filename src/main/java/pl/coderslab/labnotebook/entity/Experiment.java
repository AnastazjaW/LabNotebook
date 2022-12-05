package pl.coderslab.labnotebook.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = Experiment.TABLE_NAME)
@Data
public class Experiment {
    final static String TABLE_NAME = "experiments";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "last_modification_date")
    private Date lastModificationDate;
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
