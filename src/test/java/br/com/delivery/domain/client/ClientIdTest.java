package br.com.delivery.domain.client;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClientIdTest {
  @Test
  void shouldCreateClientIdWithValidUUID() {
    UUID uuid = UUID.randomUUID();
    ClientId id = new ClientId(uuid);

    assertEquals(uuid, id.value());
  }
}
