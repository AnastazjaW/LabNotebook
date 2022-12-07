package pl.coderslab.labnotebook.user.dto;

import lombok.Data;
import pl.coderslab.labnotebook.user.validation.adnotations.ConfirmPassword;
import pl.coderslab.labnotebook.user.validation.adnotations.Password;
import pl.coderslab.labnotebook.user.validation.adnotations.UniqueEmail;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ConfirmPassword
@UniqueEmail
public class UserRegisterDTO {
    @NotEmpty
    @Size(min = 2, max = 30)
    private String firstName;
    @NotEmpty
    @Size(min = 2, max = 30)
    private String lastName;
    @NotEmpty
    private String degree;
    @NotEmpty
    @Size(min = 2, max = 30)
    private String affiliation;
    @NotEmpty
    @Email
    private String email;
    @NotEmpty
    @Password
    private String password;
    @NotEmpty
    private String confirmPassword;


}
