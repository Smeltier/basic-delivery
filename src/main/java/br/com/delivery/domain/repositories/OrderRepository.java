package br.com.delivery.domain.order;

import java.util.Optional;

import br.com.delivery.domain.order.OrderId;
import br.com.delivery.domain.order.Order;

public interface OrderRepository {
  Optional<Order> findById(OrderId id);

  void save(Order order);
}
