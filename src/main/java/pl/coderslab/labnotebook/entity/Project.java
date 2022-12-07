package pl.coderslab.labnotebook.entity;

import lombok.Data;
import pl.coderslab.labnotebook.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Project.TABLE_NAME)
@Data
public class Project {
    public final static String TABLE_NAME = "projects";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    @NotEmpty
    private String name;
    @ManyToMany
    @JoinTable(name = "users_projects",
    joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
    @Column
    @NotEmpty
    private String description;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "finish_date")
    private Date finishDate;




}
