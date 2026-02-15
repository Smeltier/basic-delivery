package br.com.delivery.domain.client;

import java.util.Objects;

import br.com.delivery.domain.shared.Email;

public class Client {
  private final ClientId id;
  private Email email;
  private String name;
  private boolean active;

  private Client(ClientId id, String name, Email email) {
    this.id = Objects.requireNonNull(id);
    setEmail(email);
    setName(name);
    this.active = true;
  }

  public static Client create(String name, Email email) {
    return new Client(ClientId.generate(), name, email);
  }

  public boolean isActive() {
    return this.active;
  }

  public void deactivate() {
    this.active = false;
  }

  public void activate() {
    this.active = true;
  }

  public String getName() {
    return name;
  }

  public ClientId getId() {
    return id;
  }

  public Email getEmail() {
    return email;
  }

  public void setEmail(Email newEmail) {
    if (!this.active) {
      throw new IllegalArgumentException("Cliente inativo.");
    }
    email = Objects.requireNonNull(newEmail);
  }

  public void setName(String newName) {
    if (!this.active) {
      throw new IllegalArgumentException("Cliente inativo.");
    }
    if (newName == null || newName.isBlank()) {
      throw new IllegalArgumentException("Nome inválido");
    }
    this.name = newName;
  }
}
