package br.com.delivery.domain.client;

import java.util.Objects;
import java.util.UUID;

public record ClientId(UUID value) {
  public ClientId {
    Objects.requireNonNull(value);
  }

  public static ClientId generate() {
    return new ClientId(UUID.randomUUID());
  }
}
