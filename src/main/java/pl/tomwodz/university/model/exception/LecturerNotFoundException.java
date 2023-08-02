package pl.tomwodz.university.model.exception;

public class LecturerNotFoundException extends RuntimeException {
    public LecturerNotFoundException(String message) {
        super(message);
    }
}
