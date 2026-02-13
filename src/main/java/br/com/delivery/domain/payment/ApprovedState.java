package br.com.delivery.domain.payment;

public class ApprovedState implements PaymentState {
  @Override
  public void approve(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi aprovado.");
  }

  @Override
  public void decline(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi aprovado.");
  }

  @Override
  public void cancel(Payment payment) {
    throw new IllegalArgumentException("O pagamento já foi aprovado.");
  }

  @Override
  public void refund(Payment payment) {
    payment.changeState(new RefundedState());
  }
}
