package pl.coderslab.labnotebook.user.validation;

import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;
import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.service.UserServiceImpl;
import pl.coderslab.labnotebook.user.validation.adnotations.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Setter
@RequiredArgsConstructor
@Component
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserRegisterDTO> {
    private final UserServiceImpl userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserRegisterDTO user, ConstraintValidatorContext constraintValidatorContext) {
        if (userService.loadUserByUsername(user.getEmail()) != null) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.email.email-unique}")
                    .addPropertyNode("email").addConstraintViolation();
            return false;
        }
        return true;
    }
}