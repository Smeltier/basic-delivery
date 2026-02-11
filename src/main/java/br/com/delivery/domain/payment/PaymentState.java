package br.com.delivery.domain.payment;

public interface PaymentState {
  void approve(Payment payment);

  void decline(Payment payment);

  void cancel(Payment payment);

  void refund(Payment payment);
}
