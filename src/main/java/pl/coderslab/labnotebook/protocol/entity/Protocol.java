package pl.coderslab.labnotebook.protocol.entity;

import lombok.Data;
import org.hibernate.validator.constraints.Range;
import pl.coderslab.labnotebook.user.entity.User;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = Protocol.TABLE_NAME)
@Data
public class Protocol {
    final static String TABLE_NAME = "protocols";
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column
    @NotEmpty
    @Size(min = 2, max = 260)
    private String name;
    @Column
    @NotEmpty
    @Size(min = 2, max = 1000)
    private String description;
    @Column(name = "last_modification_date")
    private LocalDateTime lastModificationDate;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
