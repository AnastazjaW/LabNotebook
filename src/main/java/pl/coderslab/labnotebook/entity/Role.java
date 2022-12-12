package pl.coderslab.labnotebook.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = Role.TABLE_NAME)
@Data
@NoArgsConstructor
public class Role {
    final static String TABLE_NAME = "roles";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;

    public Role(String name) {
        this.name = name;

    }

}
