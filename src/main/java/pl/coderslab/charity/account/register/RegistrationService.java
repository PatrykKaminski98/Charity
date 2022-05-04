package pl.coderslab.charity.account.register;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import pl.coderslab.charity.account.user.User;
import pl.coderslab.charity.account.user.UserRole;
import pl.coderslab.charity.account.user.UserService;

@Service
@AllArgsConstructor
public class RegistrationService {
    private final UserService userService;

    public String register(UserDto userDto) {
        String token = userService.signUpUser(
                new User(
                        userDto.getEmail(),
                        userDto.getPassword(),
                        UserRole.ROLE_USER
                )
        );

        //String link = "http://localhost:8080/register/confirm?token=" + token;
        //emailService.send(userDto.getEmail(), buildEmail(userDto.getUsername(), link));
        return "token";
    }

}
