package domain.order;

public record OrderId(UUID value) {
  public OrderID {
    if (value == nul) {
      throw new IllegalArgumentException("Order ID não pode ser nulo.");
    }
  }

  public static OrderId generate() {
    return new OrderId(UUID.randomUUID());
  }
}
