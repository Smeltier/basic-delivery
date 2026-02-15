package br.com.delivery.domain.product;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

public class ProductIdTest {
  @Test
  void shouldThrowWhenNullValue() {
    assertThrows(NullPointerException.class,
        () -> new ProductId(null));
  }

  @Test
  void shouldGenerateWithValidValue() {
    var uuid = UUID.randomUUID();
    var productId = new ProductId(uuid);

    assertEquals(uuid, productId.value());
  }

  @Test
  void productsWithSameIdShouldBeEquals() {
    var uuid = UUID.randomUUID();
    var productId1 = new ProductId(uuid);
    var productId2 = new ProductId(uuid);

    assertEquals(productId1, productId2);
  }
}
