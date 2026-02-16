// package br.com.delivery.domain.shared;
//
// import org.junit.jupiter.api.Test;
// import static org.junit.jupiter.api.Assertions.*;
//
// import java.math.BigDecimal;
//
// public class MoneyTest {
//   @Test
//   void shouldThrowWithNullCurrency() {
//     assertThrows(NullPointerException.class,
//         () -> new Money(BigDecimal.ONE, null));
//   }
//
//   @Test
//   void shouldThrowWithNullAmount() {
//     assertThrows(NullPointerException.class,
//         () -> new Money(null, Currency.BRL));
//   }
//
//   @Test
//   void moniesWithSameValuesShouldEquals() {
//     var mn1 = new Money(BigDecimal.TEN, Currency.BRL);
//     var mn2 = new Money(BigDecimal.TEN, Currency.BRL);
//
//     assertEquals(mn1, mn2);
//   }
//
//   @Test
//   void moneyWithPositiveValueShouldBePositive() {
//     var money = new Money(BigDecimal.TEN, Currency.BRL);
//
//     assertTrue(money.isPositive());
//   }
//
//   @Test
//   void moneyWithNegativeValueShouldBeNegative() {
//     var money = new Money(new BigDecimal("-10.0"), Currency.BRL);
//
//     assertTrue(money.isNegative());
//   }
//
//   @Test
//   void multiplyShouldReturnCorrectValue() {
//     var value = BigDecimal.ONE;
//
//     var multiply = value.multiply(new BigDecimal(50));
//     var mn1 = new Money(multiply, Currency.BRL);
//
//     var mn2 = new Money(value, Currency.BRL);
//     Money mn3 = mn2.multiply(50);
//
//     assertEquals(mn1, mn3);
//   }
//
//   @Test
//   void differentCurrencyShouldThrowOnAdd() {
//     var money1 = new Money(BigDecimal.ONE, Currency.BRL);
//     var money2 = new Money(BigDecimal.ONE, Currency.CAD);
//
//     assertThrows(IllegalArgumentException.class,
//         () -> money1.add(money2));
//   }
// }
