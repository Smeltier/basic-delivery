// package br.com.delivery.application.usecases.order;
//
// import br.com.delivery.domain.order.Order;
// import br.com.delivery.domain.order.OrderId;
// import br.com.delivery.domain.client.ClientId;
// import br.com.delivery.domain.product.Product;
// import br.com.delivery.domain.product.ProductId;
// import br.com.delivery.domain.shared.Currency;
// import br.com.delivery.domain.repositories.OrderRepository;
// import br.com.delivery.domain.repositories.ProductRepository;
//
// import java.util.Objects;
//
// public class CreateOrderUseCase {
// private final OrderRepository orderRepository;
// private final ProductRepository productRepository;
//
// public CreateOrderUseCase(OrderRepository orderRepository, ProductRepository
// productRepository) {
// this.orderRepository = Objects.requireNonNull(orderRepository);
// this.productRepository = Objects.requireNonNull(productRepository);
// }
//
// public OrderId execute(CreateOrderInput input) {
// ClientId clientId = new ClientId(input.clientId());
// Currency currency = input.currency();
//
// OrderId orderId = OrderId.generate();
// Order order = new Order(orderId, clientId, currency);
//
// for (ItemInput itemInput : input.items()) {
// ProductId productId = itemInput.productId();
//
// Product product = productRepository.findById(productId)
// .orElseThrow(() -> new IllegalArgumentException("Produto não encontrado."));
//
// order.addItem(product.getId(), product.getName(), product.currentPrice(),
// itemInput.quantity());
// }
//
// orderRepository.save(order);
//
// return order.getId();
// }
// }
