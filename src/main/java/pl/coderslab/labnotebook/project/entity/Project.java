package pl.coderslab.labnotebook.project.entity;

import lombok.Data;
import org.springframework.stereotype.Service;
import pl.coderslab.labnotebook.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
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
    @Size(min = 2, max = 260)
    private String name;
    @ManyToMany
    @JoinTable(name = "users_projects",
    joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
    @Column(length = 1000)
    @NotEmpty
    @Size(min = 2, max = 1000)
    private String description;
    @Column(name = "start_date")
    private LocalDateTime startDate;
    @Column(name = "finish_date")
    private LocalDateTime finishDate;




}
