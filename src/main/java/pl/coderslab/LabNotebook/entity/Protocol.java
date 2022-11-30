package pl.coderslab.LabNotebook.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = Protocol.TABLE_NAME)
@Data
public class Protocol {
    final static String TABLE_NAME = "protocols";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column(name = "last_modification")
    private Date lastModification;
    @Column(name = "is_finished")
    @Range(min = 0, max = 1)
    private byte isFinished;

}
