package br.com.delivery.domain.product;

import java.util.Objects;
import java.util.UUID;

public record ProductId(UUID value) {
  public ProductId {
    Objects.requireNonNull(value);
  }

  public static ProductId generate() {
    return new ProductId(UUID.randomUUID());
  }
}
