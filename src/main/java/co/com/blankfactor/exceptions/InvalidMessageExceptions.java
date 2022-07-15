package co.com.blankfactor.exceptions;

public class InvalidMessageExceptions extends AssertionError {

  public InvalidMessageExceptions(String message, Throwable cause) {
    super(message, cause);
  }
}
