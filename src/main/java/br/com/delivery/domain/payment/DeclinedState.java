package br.com.delivery.domain.payment;

public class DeclinedState implements PaymentState {
  @Override
  public void approve(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi recusado.");
  }

  @Override
  public void decline(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi recusado.");
  }

  @Override
  public void cancel(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi recusado.");
  }

  @Override
  public void refund(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi recusado.");
  }
}
