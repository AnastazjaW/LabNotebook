package pl.coderslab.LabNotebook.entity;

import lombok.Data;

import javax.persistence.*;
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
    private String name;
    @ManyToMany
    @JoinTable(name = "users_projects",
    joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> users;
    @Column
    private String description;
    @Column(name = "start_date")
    private Date startDate;
    @Column(name = "finish_date")
    private Date finishDate;




}
