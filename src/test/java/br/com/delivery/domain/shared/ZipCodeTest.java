package br.com.delivery.domain.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ZipCodeTest {
  @Test
  void shouldNotAbleNullValues() {
    assertThrows(IllegalArgumentException.class,
        () -> new ZipCode(null));
  }

  @Test
  void shouldNotAbleBlankValues() {
    assertThrows(IllegalArgumentException.class,
        () -> new ZipCode(""));
  }

  @Test
  void shouldNormalizeValue() {
    var value = "36703072";
    var zip = new ZipCode("36703-072");

    assertEquals(value, zip.value());
  }

  @Test
  void shouldThrowsIfNotMatchWithPattern() {
    assertThrows(IllegalArgumentException.class,
        () -> new ZipCode("afafafafaf"));
  }
}
