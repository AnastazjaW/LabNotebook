package pl.coderslab.labnotebook.user.validation;

import lombok.RequiredArgsConstructor;
import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.service.UserService;
import pl.coderslab.labnotebook.user.validation.adnotations.UniqueEmail;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@RequiredArgsConstructor
public class UniqueEmailValidator implements ConstraintValidator<UniqueEmail, UserRegisterDTO> {
    private final UserService userService;

    @Override
    public void initialize(UniqueEmail constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserRegisterDTO user, ConstraintValidatorContext constraintValidatorContext) {
        if (userService.loadUserByEmail(user.getEmail()) != null) {
            constraintValidatorContext
                    .buildConstraintViolationWithTemplate("{invalid.email.email-unique}")
                    .addPropertyNode("email").addConstraintViolation();
            return false;
        }
        return true;
    }
}