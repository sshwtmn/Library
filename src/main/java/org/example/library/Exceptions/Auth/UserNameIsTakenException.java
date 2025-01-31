package org.example.library.Exceptions.Auth;

public class UserNameIsTakenException extends AuthException {
    public UserNameIsTakenException() {
        super("User name is taken");
    }
}
