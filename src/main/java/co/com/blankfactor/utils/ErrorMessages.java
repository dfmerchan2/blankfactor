package co.com.blankfactor.utils;

public enum ErrorMessages {
    UNEXPECTED_MESSAGE_ERROR("The message presented is not what was expected.")
    ;

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
