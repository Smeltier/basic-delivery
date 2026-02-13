package br.com.delivery.domain.repositories;

import java.util.Optional;

import br.com.delivery.domain.product.Product;
import br.com.delivery.domain.product.ProductId;

public interface ProductRepository {
  Optional<Product> findById(ProductId id);

  void save(Product product);
}
