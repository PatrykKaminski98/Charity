package pl.coderslab.charity.account.user;

import org.springframework.security.core.AuthenticationException;

public class UserDisabledException extends AuthenticationException {
    public UserDisabledException(String message) {
        super(message);
    }
}
