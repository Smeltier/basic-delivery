package br.com.delivery.application.usecases;

import br.com.delivery.domain.order.Order;
import br.com.delivery.domain.order.OrderId;
import br.com.delivery.domain.order.OrderRepository;

import java.util.UUID;
import java.util.Objects;

public class CreateOrderUseCase {
  private final OrderRepository orderRepository;
  private final ClientRepository clientRepository;
  private final ProductRepository productRepository;

  public CreateOrderUseCase(OrderRepository orderRepository, ClientRepository clientRepository,
      ProductRepository productRepository) {
    this.orderRepository = Objects.requireNonNull(orderRepository);
    this.productRepository = Objects.requireNonNull(productRepository);
    this.clientRepository = Objects.requireNonNull(clientRepository);
  }

  public OrderId execute(CreateOrderInput input) {
    ClientId clientId = new ClientId(input.clientId());
    Client client = clientRepository.findById(clientId);

    if (client == null) {
      throw new IllegalArgumentException("Cliente não encontrado.");
    }

    OrderId orderId = OrderId.generate();
    Order order = new Order(orderId, clientId);

    for (ItemInput itemInput : input.items()) {
      ProductId productId = new ProductId(itemInput.productId());
      Product product = productRepository.findById(productId);

      if (product == null) {
        throw new IllegalArgumentException("Produto não encontrado.");
      }

      order.addItem(product.getId(), product.getName(), product.getCurrentPrice(), itemInput.quantity());
    }

    orderRepository.save(order);

    return order.getId();
  }
}
