package by.beatdev.userservice.exception.custom;

public class UserEmailInBlacklistException extends RuntimeException {
    public UserEmailInBlacklistException(String message) {
        super(message);
    }
}
