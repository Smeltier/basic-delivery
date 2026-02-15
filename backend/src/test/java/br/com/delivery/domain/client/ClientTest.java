package br.com.delivery.domain.client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.com.delivery.domain.shared.Email;

public class ClientTest {
  @Test
  void shouldStartActive() {
    var client = new Client(ClientId.generate(), "Name", new Email("test@gmail.com"));

    assertTrue(client.isActive());
  }

  @Test
  void shouldThrowWithNullId() {
    assertThrows(IllegalArgumentException.class,
        () -> new Client(null, "name", new Email("test@gmail.com")));
  }

  @Test
  void shouldThrowWithNullEmail() {
    assertThrows(IllegalArgumentException.class,
        () -> new Client(ClientId.generate(), "name", null));
  }

  @Test
  void shouldThrowWithBlankName() {
    assertThrows(IllegalArgumentException.class,
        () -> new Client(ClientId.generate(), "", new Email("client@gmail.com")));
  }

  @Test
  void shouldThrowWhenSetNameInInactiveClient() {
    var client = new Client(ClientId.generate(), "name", new Email("test@gmail.com"));
    client.deactivate();

    assertThrows(IllegalArgumentException.class,
        () -> client.setName("George"));
  }
}
