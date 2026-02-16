// package br.com.delivery.domain.product;
//
// import org.junit.jupiter.api.Test;
//
// import br.com.delivery.domain.shared.Currency;
// import br.com.delivery.domain.shared.Money;
//
// import static org.junit.jupiter.api.Assertions.*;
//
// import java.math.BigDecimal;
//
// public class ProductTest {
//   @Test
//   void shouldCreateActive() {
//     var product = new Product(ProductId.generate(), "name", new Money(BigDecimal.ONE, Currency.BRL));
//
//     assertTrue(product.isActive());
//   }
//
//   @Test
//   void shouldThrowWithNullName() {
//     assertThrows(IllegalArgumentException.class,
//         () -> new Product(ProductId.generate(), "", new Money(BigDecimal.ONE, Currency.BRL)));
//   }
//
//   @Test
//   void shouldThrowWhenChangePriceWithDeactiveProduct() {
//     var product = new Product(ProductId.generate(), "name", new Money(BigDecimal.ONE, Currency.BRL));
//     product.deactivate();
//
//     var newPrice = new Money(BigDecimal.TEN, Currency.BRL);
//
//     assertThrows(IllegalStateException.class,
//         () -> product.changePrice(newPrice));
//   }
// }
