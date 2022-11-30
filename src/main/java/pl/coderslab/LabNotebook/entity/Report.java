package pl.coderslab.LabNotebook.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = Report.TABLE_NAME)
@Data
public class Report {
    final static String TABLE_NAME = "reports";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "last_modification")
    private Date lastModification;
    @OneToOne
    @JoinColumn(name = "experiment_id")
    private Experiment experiment;
}
