package pl.coderslab.labnotebook.entity;

import lombok.Data;
import pl.coderslab.labnotebook.user.User;

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
    @Column(name = "last_modification_date")
    private Date lastModificationDate;
    @OneToOne
    @JoinColumn(name = "experiment_id")
    private Experiment experiment;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}
