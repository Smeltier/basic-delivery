package br.com.delivery.domain.payment;

public class FakeApprovedPaymentMethod implements IPaymentMethod {
  public PaymentProcessingResult process(Payment payment) {
    return PaymentProcessingResult.APPROVED;
  }
}
