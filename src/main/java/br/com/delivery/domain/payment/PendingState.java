package br.com.delivery.domain.payment;

public class PendingState implements PaymentState {
  @Override
  public void approve(Payment payment) {
    payment.changeState(new ApprovedState());
  }

  @Override
  public void decline(Payment payment) {
    payment.changeState(new DeclinedState());
  }

  @Override
  public void cancel(Payment payment) {
    payment.changeState(new CancelledState());
  }

  @Override
  public void refund(Payment payment) {
    payment.changeState(new RefundedState());
  }
}
