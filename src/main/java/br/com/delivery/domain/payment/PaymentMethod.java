package br.com.delivery.domain.payment;

import br.com.delivery.domain.shared.Money;

public interface PaymentMethod {
  PaymentProcessingResult process(Payment payment);
}
