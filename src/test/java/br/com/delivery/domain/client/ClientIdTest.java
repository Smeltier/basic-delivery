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

  @Test
  void shouldThrowExceptionWhenUUIDIsNull() {
    assertThrows(NullPointerException.class,
        () -> new ClientId(null));
  }

  @Test
  void generateShouldReturnNonNullValue() {
    ClientId id = ClientId.generate();

    assertNotNull(id);
    assertNotNull(id.value());
  }

  @Test
  void generateShouldCreateDifferentIds() {
    ClientId id1 = ClientId.generate();
    ClientId id2 = ClientId.generate();

    assertNotEquals(id1, id2);
  }

  @Test
  void twoClientsWithSameUUIDNeedToBeEquals() {
    UUID id = UUID.randomUUID();
    ClientId id1 = new ClientId(id);
    ClientId id2 = new ClientId(id);

    assertEquals(id1, id2);
  }
}
