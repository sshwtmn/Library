package org.example.library.Exceptions.Auth;

public class PasswordIsEmptyException extends AuthException {
    public PasswordIsEmptyException() {
        super("Password is empty");
    }
}
