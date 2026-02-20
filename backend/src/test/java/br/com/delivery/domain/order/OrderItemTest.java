package br.com.delivery.domain.order;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import br.com.delivery.domain.product.ProductId;
import br.com.delivery.domain.shared.Currency;
import br.com.delivery.domain.shared.Money;

public class OrderItemTest {
  private final ProductId productId = ProductId.generate();
  private final String productName = "produto";
  private final Money unitPrice = Money.zero(Currency.BRL);

  @Test
  void shouldThrowWhenQuantityIsNegative() {
    assertThrows(IllegalArgumentException.class,
        () -> new OrderItem(this.productId, this.productName, this.unitPrice, -10));
  }

  @Test
  void shouldThrowWhenQuantityIsZero() {
    assertThrows(IllegalArgumentException.class,
        () -> new OrderItem(this.productId, this.productName, this.unitPrice, 0));
  }

  @Test
  void shouldThrowWhenProductNameIsBlank() {
    assertThrows(IllegalArgumentException.class,
        () -> new OrderItem(this.productId, "", this.unitPrice, 2));
  }

  @Test
  void shouldCreateOrderItemWithCorrectValue() {
    OrderItem item = new OrderItem(this.productId, this.productName, this.unitPrice, 5);
    assertEquals(this.productId, item.getProductId());
    assertEquals(this.productName, item.getProductName());
    assertEquals(this.unitPrice, item.getUnitPrice());
    assertEquals(5, item.getQuantity());
  }

  @Test
  void shouldCalculateTotalCorrectly() {
    Money price = new Money(new BigDecimal("10.50"), Currency.BRL);
    OrderItem item = new OrderItem(productId, productName, price, 2);

    Money total = new Money(new BigDecimal("21.00"), Currency.BRL);

    assertEquals(total, item.total());
  }
}
