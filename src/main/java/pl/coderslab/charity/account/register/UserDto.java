package pl.coderslab.charity.account.register;

import lombok.Getter;
import lombok.Setter;
import pl.coderslab.charity.validators.PasswordsMatches;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@PasswordsMatches
public class UserDto {

    @NotNull
    @NotEmpty
    @Email(message = "Niepoprawny adres email")
    private String email;

    @NotNull
    @NotEmpty
    private String password;
    private String confirmPassword;
}
