package br.com.delivery.domain.exception;

public class InvalidCpfValueException extends RuntimeException {
  public InvalidCpfValueException(String message) {
    super(message);
  }
}
