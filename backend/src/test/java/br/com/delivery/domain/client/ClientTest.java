package br.com.delivery.domain.client;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import br.com.delivery.domain.shared.Email;
import br.com.delivery.domain.exception.InvalidClientOperationException;
import br.com.delivery.domain.exception.InactiveClientException;

public class ClientTest {
  private final Email email = new Email("test@gmail.com");

  @Test
  void shouldStartActive() {
    Client client = Client.create("Name", this.email);
    assertTrue(client.isActive());
  }

  @Test
  void shouldThrowWithNullEmail() {
    assertThrows(NullPointerException.class,
        () -> Client.create("name", null));
  }

  @Test
  void shouldThrowWithBlankName() {
    assertThrows(InvalidClientOperationException.class,
        () -> Client.create("", this.email));
  }

  @Test
  void shouldThrowWhenSetNameInInactiveClient() {
    Client client = Client.create("name", this.email);
    client.deactivate();

    assertThrows(InactiveClientException.class,
        () -> client.setName("George"));
  }

  @Test
  void shouldThrowWhenSetEmailIninactiveClient() {
    Client client = Client.create("name", this.email);
    client.deactivate();

    assertThrows(InactiveClientException.class,
        () -> client.setEmail(new Email("novo@gmail.com")));
  }
}
