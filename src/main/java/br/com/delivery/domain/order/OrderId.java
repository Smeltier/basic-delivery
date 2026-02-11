package br.com.delivery.domain.order;

import java.util.UUID;

public record OrderId(UUID value) {
  public OrderId {
    if (value == null) {
      throw new IllegalArgumentException("Order ID não pode ser nulo.");
    }
  }

  public static OrderId generate() {
    return new OrderId(UUID.randomUUID());
  }
}
