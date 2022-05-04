package pl.coderslab.charity.validators;

import pl.coderslab.charity.account.register.UserDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordMatchesValidator
        implements ConstraintValidator<PasswordsMatches, Object> {

    @Override
    public void initialize(PasswordsMatches constraintAnnotation) {
    }
    @Override
    public boolean isValid(Object obj, ConstraintValidatorContext context){
        UserDto user = (UserDto) obj;
        return user.getPassword().equals(user.getConfirmPassword());
    }
}