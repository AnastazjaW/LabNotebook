package pl.coderslab.LabNotebook.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = User.TABLE_NAME)
@Data
public class User {
    final static String TABLE_NAME = "users";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column
    private String degree;
    @Column
    private String affiliation;
    @Column
    private String email;
    @Column
    private String password;



}
