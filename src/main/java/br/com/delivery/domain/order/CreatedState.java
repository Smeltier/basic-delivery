package br.com.delivery.domain.order;

public class CreatedState implements OrderState {
  @Override
  public void addItem(Order order, OrderItem item) {
    order.internalAddItem(item);
  }

  @Override
  public void pay(Order order) {
    if (order.total().isZero()) {
      throw new IllegalArgumentException(
          "Pedido vazio não pode ser pago.");
    }
    order.changeState(new PaidState());
  }

  @Override
  public void cancel(Order order) {
    order.changeState(new CancelledState());
  }
}
