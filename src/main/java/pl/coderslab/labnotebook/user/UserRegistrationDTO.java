package pl.coderslab.labnotebook.user;

import lombok.Data;

import java.util.PrimitiveIterator;
@Data
public class UserRegistrationDTO {
    private String firstName;
    private String lastName;
    private String degree;
    private String affiliation;
    private String email;
    private String password;


}
