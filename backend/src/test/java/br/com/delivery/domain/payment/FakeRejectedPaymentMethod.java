package br.com.delivery.domain.payment;

public class FakeRejectedPaymentMethod implements IPaymentMethod {
  public PaymentProcessingResult process(Payment payment) {
    return PaymentProcessingResult.REJECTED;
  }
}
