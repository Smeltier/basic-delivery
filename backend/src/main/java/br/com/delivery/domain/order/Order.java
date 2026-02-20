package br.com.delivery.domain.order;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Collections;

import br.com.delivery.domain.exception.InvalidOrderOperationException;
import br.com.delivery.domain.client.ClientId;
import br.com.delivery.domain.shared.Money;
import br.com.delivery.domain.shared.Currency;
import br.com.delivery.domain.payment.PaymentId;
import br.com.delivery.domain.product.ProductId;

public class Order {
  private final OrderId id;
  private final ClientId clientId;
  private final Currency currency;
  private final List<OrderItem> items;
  private final List<PaymentId> payments;
  private OrderStatus status;

  private Order(OrderId id, ClientId clientId, Currency currency) {
    this.id = Objects.requireNonNull(id);
    this.clientId = Objects.requireNonNull(clientId);
    this.currency = Objects.requireNonNull(currency);

    this.items = new ArrayList<>();
    this.payments = new ArrayList<>();
    this.status = OrderStatus.CREATED;
  }

  public static Order create(ClientId clientId, Currency currency) {
    return new Order(OrderId.generate(), clientId, currency);
  }

  public void addItem(ProductId productId, String productName, Money unitPrice, int quantity) {
    if (status != OrderStatus.CREATED) {
      throw new InvalidOrderOperationException("Não pode adicionar itens no estado " + status);
    }
    OrderItem item = new OrderItem(productId, productName, unitPrice, quantity);
    items.add(item);
  }

  public void removeItem(ProductId productId) {
    if (status != OrderStatus.CREATED) {
      throw new InvalidOrderOperationException("Não pode adicionar itens no estado " + status);
    }
    items.removeIf(item -> item.getProductId().equals(productId));
  }

  public void registerPayment(PaymentId paymentId) {
    Objects.requireNonNull(paymentId);
    payments.add(paymentId);
  }

  public void markAsPaid() {
    if (status != OrderStatus.CREATED) {
      throw new InvalidOrderOperationException("O pedido não pode ser pago no estado " + status);
    }
    status = OrderStatus.PAID;
  }

  public void confirm() {
    if (status != OrderStatus.PAID) {
      throw new InvalidOrderOperationException("Apenas pedidos pagos podem ser confirmados.");
    }
    status = OrderStatus.CONFIRMED;
  }

  public void cancel() {
    if (status == OrderStatus.CONFIRMED) {
      throw new InvalidOrderOperationException("Pedidos confirmados não podem ser cancelados.");
    }
    status = OrderStatus.CANCELLED;
  }

  public Money total() {
    Money total = Money.zero(currency);
    for (OrderItem item : this.items) {
      total = total.add(item.total());
    }
    return total;
  }

  public OrderId getId() {
    return id;
  }

  public ClientId getClientId() {
    return clientId;
  }

  public OrderStatus getStatus() {
    return status;
  }

  public Currency getCurrency() {
    return currency;
  }

  public List<PaymentId> getPayments() {
    return Collections.unmodifiableList(payments);
  }

  public List<OrderItem> getItems() {
    return Collections.unmodifiableList(items);
  }
}
