package pl.coderslab.labnotebook.user.dto;

import lombok.Data;
import pl.coderslab.labnotebook.user.validation.adnotations.ConfirmPassword;
import pl.coderslab.labnotebook.user.validation.adnotations.Password;
import pl.coderslab.labnotebook.user.validation.adnotations.UniqueEmail;

import javax.validation.constraints.*;

@Data
@ConfirmPassword
@UniqueEmail
public class UserRegisterDTO {
    @NotBlank
    @Size(min = 2, max = 30)
    private String firstName;
    @NotBlank
    @Size(min = 2, max = 30)
    private String lastName;
    @NotBlank
    private String degree;
    @NotBlank
    @Size(min = 2, max = 30)
    private String affiliation;
    @NotBlank
    @Email
    private String email;
    @NotBlank
    @Password
    private String password;
    @NotBlank
    private String confirmPassword;
}
