package br.com.delivery.domain.product;

import java.util.Objects;

import br.com.delivery.domain.shared.Money;

public class Product {
  private final ProductId id;
  private String name;
  private Money price;
  private boolean active;

  private Product(ProductId id, String name, Money price) {
    this.id = Objects.requireNonNull(id);
    this.price = Objects.requireNonNull(price);
    setName(name);
    this.active = true;
  }

  public static Product create(String name, Money price) {
    return new Product(ProductId.generate(), name, price);
  }

  public Money currentPrice() {
    if (!this.active) {
      throw new IllegalStateException("Produto inativo.");
    }
    return price;
  }

  public void changePrice(Money newPrice) {
    if (newPrice == null) {
      throw new IllegalArgumentException("Novo preço inválido.");
    }
    if (!this.active) {
      throw new IllegalStateException("Produto inativo.");
    }
    this.price = newPrice;
  }

  public void deactivate() {
    this.active = false;
  }

  public void activate() {
    this.active = true;
  }

  public boolean isActive() {
    return this.active;
  }

  public ProductId getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public void setName(String newName) {
    if (newName.isBlank()) {
      throw new IllegalArgumentException("Nome inválido.");
    }
    this.name = Objects.requireNonNull(newName);
  }
}
