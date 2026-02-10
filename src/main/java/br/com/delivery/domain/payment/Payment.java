package domain.payment;

public class Payment {
  private final PaymentID id;
  private final PaymentMethod method;
  private final Money amount;
  private PaymentState state;

  public Payment(PaymentID id, PaymentMethod method, Money amount) {
    if (id == null) {
      throw new IllegalArgumentException("ID não pode ser nulo.");
    }
    if (method == null) {
      throw new IllegalArgumentException("Método de pagamento não pode ser nulo.");
    }
    if (amount == null) {
      throw new IllegalArgumentException("Valor monetário não pode ser nula");
    }
    this.id = id;
    this.method = method;
    this.amount = amount;
    this.state = new PendingState();
  }

  public void confirm() {
    state.confirm(this);
  }

  public void fail() {
    state.fail(this);
  }
}
