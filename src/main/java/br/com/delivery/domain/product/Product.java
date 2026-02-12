package br.com.delivery.domain.product;

import br.com.delivery.domain.shared.Money;

import java.util.Objects;

public class Product {
  private final ProductId id;
  private String name;
  private Money price;
  private boolean active;

  public Product(ProductId id, String name, Money price) {
    this.id = Objects.requireNonNull(id);
    this.name = Objects.requireNonNull(name);
    this.price = Objects.requireNonNull(price);
    this.active = true;
  }

  public Money currentPrice() {
    if (!this.active) {
      throw new IllegalStateException("Produto inativo.");
    }
    return price;
  }

  public void changePrice(Money newPrice) {
    if (newPrice == null || newPrice.isNegative()) {
      throw new IllegalArgumentException("Novo preço inválido.");
    }
    this.price = newPrice;
  }

  public ProductId getId() {
    return id;
  }

  public String getName() {
    return name;
  }
}
