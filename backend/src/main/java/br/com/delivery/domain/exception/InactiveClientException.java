package br.com.delivery.domain.exception;

public class InactiveClientException extends RuntimeException {
  public InactiveClientException(String message) {
    super(message);
  }
}
