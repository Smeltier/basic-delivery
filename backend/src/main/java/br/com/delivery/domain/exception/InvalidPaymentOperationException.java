package br.com.delivery.domain.exception;

public class InvalidPaymentOperationException extends RuntimeException {
  public InvalidPaymentOperationException(String message) {
    super(message);
  }
}
