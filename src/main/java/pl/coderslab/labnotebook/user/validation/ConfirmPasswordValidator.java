package pl.coderslab.labnotebook.user.validation;

import pl.coderslab.labnotebook.user.dto.UserRegisterDTO;
import pl.coderslab.labnotebook.user.validation.adnotations.ConfirmPassword;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ConfirmPasswordValidator implements ConstraintValidator<ConfirmPassword, UserRegisterDTO> {
    @Override
    public void initialize(ConfirmPassword constraintAnnotation) {

    }

    @Override
    public boolean isValid(UserRegisterDTO user, ConstraintValidatorContext constraintValidatorContext) {
                    constraintValidatorContext
                            .buildConstraintViolationWithTemplate("{invalid.password.confirm-password}")
                            .addPropertyNode("confirmPassword").addConstraintViolation();
        return user.getPassword().equals(user.getConfirmPassword());
    }
}
