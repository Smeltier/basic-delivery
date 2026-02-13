package br.com.delivery.domain.payment;

public class RefundedState implements PaymentState {
  @Override
  public void approve(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi reembolsado.");
  }

  @Override
  public void decline(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi reembolsado.");
  }

  @Override
  public void cancel(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi reembolsado.");
  }

  @Override
  public void refund(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi reembolsado.");
  }
}
