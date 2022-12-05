package pl.coderslab.labnotebook.user;

import lombok.Data;
import lombok.NoArgsConstructor;
import pl.coderslab.labnotebook.entity.Role;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Entity
@Table(name = User.TABLE_NAME)
@Data
@NoArgsConstructor
public class User {
    final static String TABLE_NAME = "users";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotEmpty
    @Column(name = "first_name")
    private String firstName;

    @NotEmpty
    @Column(name = "last_name")
    private String lastName;


    @Column
    @NotEmpty
    private String degree;

    @NotEmpty
    @Column
    private String affiliation;

    @NotEmpty
    @Column
    private String email;

    @NotEmpty
    @Column
    private String password;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role"
            , joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;


    public User(String firstName, String lastName, String degree, String affiliation, String email, String password, Set<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.degree = degree;
        this.affiliation = affiliation;
        this.email = email;
        this.password = password;
        this.roles = roles;
    }

}
