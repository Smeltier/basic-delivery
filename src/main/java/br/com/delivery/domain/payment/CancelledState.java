package br.com.delivery.domain.payment;

public class CancelledState implements PaymentState {
  @Override
  public void approve(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi cancelado.");
  }

  @Override
  public void decline(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi cancelado.");
  }

  @Override
  public void cancel(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi cancelado.");
  }

  @Override
  public void refund(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi cancelado.");
  }
}
