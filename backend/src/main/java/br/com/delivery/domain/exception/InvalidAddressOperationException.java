package br.com.delivery.domain.exception;

public class InvalidAddressOperationException extends RuntimeException {
  public InvalidAddressOperationException(String message) {
    super(message);
  }
}
