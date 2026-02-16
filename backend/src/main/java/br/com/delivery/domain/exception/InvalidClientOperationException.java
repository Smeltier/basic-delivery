package br.com.delivery.domain.exception;

public class InvalidClientOperationException extends RuntimeException {
  public InvalidClientOperationException(String message) {
    super(message);
  }
}
