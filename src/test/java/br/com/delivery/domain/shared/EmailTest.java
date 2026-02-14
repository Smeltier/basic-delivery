package br.com.delivery.domain.shared;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EmailTest {
  @Test
  void shouldCreateValidEmail() {
    var email = new Email("user@test.com");

    assertEquals("user@test.com", email.value());
  }

  @Test
  void shouldConvertEmailToLowerCase() {
    var str = "USER@TEST.COM";
    var email = new Email(str);

    assertEquals(str.toLowerCase(), email.value());
  }

  @Test
  void shouldNotBeAbleToCreateWithBlankValue() {
    assertThrows(IllegalArgumentException.class,
        () -> new Email("connect.gocalves@gmail.com"));
  }

  @Test
  void shouldNotBeAbleToCreateWithInvalidMatch() {
    assertThrows(IllegalArgumentException.class,
        () -> new Email("///@gmail.com"));
  }

  @Test
  void emailsWithSameValueShouldBeEqual() {
    var str = "user@test.com";

    var em1 = new Email(str);
    var em2 = new Email(str);

    assertEquals(em1, em2);
  }
}
