package br.com.delivery.domain.payment;

import br.com.delivery.domain.shared.Money;

import java.util.Objects;

public class Payment {
  private final PaymentId id;
  private final PaymentMethod method;
  private final Money amount;
  private PaymentState state;

  public Payment(PaymentId id, PaymentMethod method, Money amount) {
    this.id = Objects.requireNonNull(id);
    this.method = Objects.requireNonNull(method);
    this.amount = Objects.requireNonNull(amount);
    this.state = new PendingState();
  }

  public void confirm() {
    state.approve(this);
  }

  public void fail() {
    state.decline(this);
  }

  public void cancel() {
    state.cancel(this);
  }

  public void refund() {
    state.refund(this);
  }

  public PaymentId getId() {
    return id;
  }

  public Money getAmount() {
    return amount;
  }

  public PaymentState getState() {
    return state;
  }

  public PaymentMethod getMethod() {
    return method;
  }

  protected void changeState(PaymentState newState) {
    this.state = newState;
  }
}
